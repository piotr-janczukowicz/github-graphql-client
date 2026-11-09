package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.pagination.GitHubPaginationLimitExceededException;
import io.github.piotr_janczukowicz.github.pagination.GitHubPaginationLoopException;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.jspecify.annotations.Nullable;

/**
 * Follows the pages of a connection lazily: a page is fetched only when the stream needs its first item, and the end
 * cursor of a page is checked only when the next page is requested.
 *
 * <p>Like the REST client's page walk, it fails when {@code maxPages} pages were read and another page is still
 * available, and when an end cursor repeats. The stream is sequential: it cannot be split, so {@code parallel()} does
 * not read pages ahead.
 */
public final class PageWalk {

    private PageWalk() {}

    /**
     * Streams the items of all pages, fetching pages on demand.
     *
     * @param first the paging of the first page
     * @param maxPages the most pages to read, or {@code null} for no limit
     * @param fetch fetches one page
     * @param <R> the item type
     * @return the lazy stream; a failed request surfaces as {@link UncheckedIOException}
     */
    public static <R> Stream<R> stream(final Paging first, final @Nullable Integer maxPages, final Fetch<R> fetch) {
        return StreamSupport.stream(new Items<>(first, maxPages, fetch), false);
    }

    /** Fetches one page for the given paging. */
    @FunctionalInterface
    public interface Fetch<R> {

        /**
         * Fetches a page.
         *
         * @param paging how many items, and after which cursor
         * @return the page
         * @throws IOException when the request fails
         */
        Page<R> fetch(Paging paging) throws IOException;
    }

    private static final class Items<R> extends Spliterators.AbstractSpliterator<R> {

        private final @Nullable Integer maxPages;
        private final Fetch<R> fetch;
        private final Set<String> seenCursors = new HashSet<>();
        private Paging lastPaging;
        private @Nullable Page<R> lastPage;
        private Iterator<R> current = Collections.emptyIterator();
        private int pageCount;

        Items(final Paging first, final @Nullable Integer maxPages, final Fetch<R> fetch) {
            super(Long.MAX_VALUE, ORDERED);
            this.lastPaging = first;
            this.maxPages = maxPages;
            this.fetch = fetch;
            if (first.after() != null) {
                seenCursors.add(first.after());
            }
        }

        @Override
        public boolean tryAdvance(final Consumer<? super R> action) {
            while (!current.hasNext()) {
                if (lastPage != null && !lastPage.hasNext()) {
                    return false;
                }
                loadPage();
            }
            action.accept(current.next());
            return true;
        }

        @Override
        public @Nullable Spliterator<R> trySplit() {
            return null;
        }

        private void loadPage() {
            if (maxPages != null && pageCount >= maxPages) {
                throw new GitHubPaginationLimitExceededException(maxPages, pageCount);
            }
            final Paging paging = lastPage == null ? lastPaging : following(lastPaging, lastPage);
            final Page<R> page;
            try {
                page = fetch.fetch(paging);
            } catch (final IOException failure) {
                throw new UncheckedIOException(failure);
            }
            pageCount++;
            lastPaging = paging;
            lastPage = page;
            current = page.items().iterator();
        }

        private Paging following(final Paging paging, final Page<R> page) {
            final String cursor = page.endCursor();
            if (cursor == null) {
                throw new IllegalStateException("page " + pageCount + " has a next page but no end cursor");
            }
            if (!seenCursors.add(cursor)) {
                throw new GitHubPaginationLoopException(
                        "end cursor repeated after " + pageCount + " page(s): " + cursor);
            }
            return paging.after(cursor);
        }
    }
}
