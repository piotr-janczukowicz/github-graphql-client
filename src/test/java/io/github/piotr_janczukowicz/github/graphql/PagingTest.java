package io.github.piotr_janczukowicz.github.graphql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PagingTest {

    @Test
    void first_shouldReject_whenTheCountIsZero() {
        final Throwable thrown = catchThrowable(() -> Paging.first(0));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("at least 1");
    }

    @Test
    void first_shouldReject_whenTheCountIsAbove100() {
        final Throwable thrown = catchThrowable(() -> Paging.first(101));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("at most 100");
    }

    @Test
    void first_shouldHaveNoCursor_whenItIsTheFirstPage() {
        final Paging paging = Paging.first(100);

        assertSoftly(softly -> {
            softly.assertThat(paging.first()).isEqualTo(100);
            softly.assertThat(paging.after()).isNull();
        });
    }

    @Test
    void after_shouldKeepTheCountAndSetTheCursor_whenTheCursorIsGiven() {
        final Paging paging = Paging.first(10);

        final Paging next = paging.after("c1");

        assertSoftly(softly -> {
            softly.assertThat(next.first()).isEqualTo(10);
            softly.assertThat(next.after()).isEqualTo("c1");
            softly.assertThat(paging.after()).isNull();
        });
    }

    @Test
    void after_shouldFail_whenTheCursorIsNull() {
        final Paging paging = Paging.first(10);
        final String cursor = null;

        final Throwable thrown = catchThrowable(() -> paging.after(cursor));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("cursor must not be null");
    }
}
