package io.github.piotr_janczukowicz.github.graphql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class PageTest {

    @Test
    void constructor_shouldCopyTheItems_whenTheSourceListChangesLater() {
        final List<String> source = new ArrayList<>(List.of("a"));

        final Page<String> page = new Page<>(source, true, "c1");
        source.add("b");

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly("a");
            softly.assertThat(page.hasNext()).isTrue();
            softly.assertThat(page.endCursor()).isEqualTo("c1");
        });
    }

    @Test
    void items_shouldBeUnmodifiable_whenThePageIsCreated() {
        final Page<String> page = new Page<>(List.of("a"), false, null);
        final List<String> items = page.items();

        final Throwable thrown = catchThrowable(() -> items.add("b"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldFail_whenTheItemsAreNull() {
        final List<String> items = null;

        final Throwable thrown = catchThrowable(() -> new Page<>(items, false, null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("items must not be null");
    }
}
