package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class InputRecordBehaviorTest {

    @Test
    void build_shouldCopyTheLists_whenTheSourceListsChangeLater() {
        final List<String> labels = new ArrayList<>(List.of("bug"));
        final List<IssueFieldValueFilter> values = new ArrayList<>();

        final IssueFilters filters = IssueFiltersBuilder.builder()
                .labels(labels)
                .issueFieldValues(values)
                .build();
        labels.add("ui");
        values.add(IssueFieldValueFilterBuilder.builder().build());

        assertSoftly(softly -> {
            softly.assertThat(filters.labels()).containsExactly("bug");
            softly.assertThat(filters.issueFieldValues()).isEmpty();
        });
    }

    @Test
    void labels_shouldBeUnmodifiable_whenTheFiltersAreBuilt() {
        final IssueFilters filters =
                IssueFiltersBuilder.builder().labels(List.of("bug")).build();
        final List<String> labels = filters.labels();

        final Throwable thrown = catchThrowable(() -> labels.add("ui"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toVariable_shouldBeUnmodifiable_whenCalled() {
        final Map<String, Object> variable =
                IssueFiltersBuilder.builder().build().toVariable();

        final Throwable thrown = catchThrowable(() -> variable.put("x", "y"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toVariable_shouldFailNamingTheEnum_whenAStateIsUnrecognized() {
        final IssueFilters filters = IssueFiltersBuilder.builder()
                .states(List.of(IssueState.UNRECOGNIZED))
                .build();

        final Throwable thrown = catchThrowable(filters::toVariable);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }

    @Test
    void build_shouldRejectNullElements_whenAListHasANull() {
        final IssueFiltersBuilder builder = IssueFiltersBuilder.builder().labels(Arrays.asList("bug", null));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }
}
