package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.pagination.GitHubPaginationLimitExceededException;
import io.github.piotr_janczukowicz.github.pagination.GitHubPaginationLoopException;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

@UnitTest
class PageWalkTest {

    private static Page<String> page(final String cursor, final boolean hasNext, final String... items) {
        return new Page<>(List.of(items), hasNext, cursor);
    }

    private static final class Script implements PageWalk.Fetch<String> {

        private final Iterator<Page<String>> pages;
        private final List<Paging> requested = new ArrayList<>();

        Script(final List<Page<String>> pages) {
            this.pages = pages.iterator();
        }

        @Override
        public Page<String> fetch(final Paging paging) {
            requested.add(paging);
            return pages.next();
        }
    }

    @SafeVarargs
    private static Script script(final Page<String>... pages) {
        return new Script(List.of(pages));
    }

    @Test
    void stream_shouldReturnTheItemsOfAllPagesInOrder_whenEveryPageHasANextCursor() {
        final Script script = script(page("c1", true, "a", "b"), page("c2", true, "c"), page(null, false, "d"));

        final List<String> items =
                PageWalk.stream(Paging.first(2), null, script).toList();

        assertSoftly(softly -> {
            softly.assertThat(items).containsExactly("a", "b", "c", "d");
            softly.assertThat(script.requested).extracting(Paging::after).containsExactly(null, "c1", "c2");
            softly.assertThat(script.requested).extracting(Paging::first).containsOnly(2);
        });
    }

    @Test
    void stream_shouldNotFetchAnything_whenTheStreamIsOnlyCreated() {
        final Script script = script(page(null, false, "a"));

        PageWalk.stream(Paging.first(2), null, script);

        assertThat(script.requested).isEmpty();
    }

    @Test
    void stream_shouldFetchLazily_whenOnlyTheFirstItemIsConsumed() {
        final Script script = script(page("c1", true, "a", "b"), page(null, false, "c"));

        final List<String> items =
                PageWalk.stream(Paging.first(2), null, script).limit(1).toList();

        assertSoftly(softly -> {
            softly.assertThat(items).containsExactly("a");
            softly.assertThat(script.requested).hasSize(1);
        });
    }

    @Test
    void stream_shouldContinue_whenAPageIsEmptyButHasANextPage() {
        final Script script = script(page("c1", true), page(null, false, "x"));

        final List<String> items =
                PageWalk.stream(Paging.first(2), null, script).toList();

        assertThat(items).containsExactly("x");
    }

    @Test
    void stream_shouldFail_whenMaxPagesIsReachedAndMoreIsAvailable() {
        final Script script = script(page("c1", true, "a"), page(null, false, "b"));

        final Throwable thrown =
                catchThrowable(() -> PageWalk.stream(Paging.first(1), 1, script).toList());

        assertThat(thrown).isInstanceOfSatisfying(GitHubPaginationLimitExceededException.class, exception -> {
            assertThat(exception.maxPages()).isEqualTo(1);
            assertThat(exception.pageCount()).isEqualTo(1);
        });
    }

    @Test
    void stream_shouldNotFail_whenTheLastPageIsTheMaxPage() {
        final Script script = script(page("c1", true, "a"), page(null, false, "b"));

        final List<String> items = PageWalk.stream(Paging.first(1), 2, script).toList();

        assertThat(items).containsExactly("a", "b");
    }

    @Test
    void stream_shouldFail_whenTheCursorRepeats() {
        final Script script = script(page("c1", true, "a"), page("c1", true, "b"), page(null, false, "c"));

        final Throwable thrown = catchThrowable(
                () -> PageWalk.stream(Paging.first(1), null, script).toList());

        assertThat(thrown).isInstanceOf(GitHubPaginationLoopException.class).hasMessageContaining("c1");
    }

    @Test
    void stream_shouldFail_whenThereIsANextPageButNoCursor() {
        final Script script = script(page(null, true, "a"));

        final Throwable thrown = catchThrowable(
                () -> PageWalk.stream(Paging.first(1), null, script).toList());

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("no end cursor");
    }

    @Test
    void stream_shouldNotFail_whenTheCursorIsMissingButNoFurtherPageIsNeeded() {
        final Script script = script(page(null, true, "a"));

        final List<String> items =
                PageWalk.stream(Paging.first(1), null, script).limit(1).toList();

        assertSoftly(softly -> {
            softly.assertThat(items).containsExactly("a");
            softly.assertThat(script.requested).hasSize(1);
        });
    }

    @Test
    void stream_shouldNotFail_whenTheCursorRepeatsButNoFurtherPageIsNeeded() {
        final Script script = script(page("c1", true, "a"), page("c1", true, "b"));

        final List<String> items =
                PageWalk.stream(Paging.first(1), null, script).limit(2).toList();

        assertThat(items).containsExactly("a", "b");
    }

    @Test
    void stream_shouldFail_whenTheStartingCursorIsReturnedAgain() {
        final Script script = script(page("x", true, "a"), page(null, false, "b"));

        final Throwable thrown = catchThrowable(
                () -> PageWalk.stream(Paging.first(1).after("x"), null, script).toList());

        assertSoftly(softly -> {
            softly.assertThat(thrown).isInstanceOf(GitHubPaginationLoopException.class);
            softly.assertThat(script.requested).hasSize(1);
        });
    }

    @Test
    void stream_shouldNotFetchTheNextPage_whenTheLastRequestedItemIsTheLastOfAPage() {
        final Script script = script(page("c1", true, "a", "b"), page(null, false, "c"));

        final List<String> items =
                PageWalk.stream(Paging.first(2), null, script).limit(2).toList();

        assertSoftly(softly -> {
            softly.assertThat(items).containsExactly("a", "b");
            softly.assertThat(script.requested).hasSize(1);
        });
    }

    @Test
    void stream_shouldFetchOnlyTheNeededPages_whenTheStreamIsParallel() {
        final AtomicInteger fetches = new AtomicInteger();
        final PageWalk.Fetch<String> fetch = paging -> {
            final int number = fetches.incrementAndGet();
            final List<String> items = new ArrayList<>();
            for (int index = 0; index < 10; index++) {
                items.add("p" + number + "-" + index);
            }
            return new Page<>(items, true, "c" + number);
        };

        final List<String> items = PageWalk.stream(Paging.first(10), null, fetch)
                .parallel()
                .limit(20)
                .toList();

        assertSoftly(softly -> {
            softly.assertThat(items).hasSize(20);
            softly.assertThat(fetches).hasValue(2);
        });
    }

    @Test
    void stream_shouldThrowAnUncheckedIoException_whenTheFetchFails() {
        final IOException failure = new IOException("connection reset");
        final PageWalk.Fetch<String> fetch = paging -> {
            throw failure;
        };

        final Throwable thrown = catchThrowable(
                () -> PageWalk.stream(Paging.first(1), null, fetch).toList());

        assertThat(thrown).isInstanceOf(UncheckedIOException.class).hasCause(failure);
    }
}
