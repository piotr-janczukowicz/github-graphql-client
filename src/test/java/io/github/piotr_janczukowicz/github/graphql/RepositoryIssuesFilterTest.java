package io.github.piotr_janczukowicz.github.graphql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilterBuilder;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryIssuesFilterTest {

    @Test
    void build_shouldLeaveEveryArgumentNull_whenNothingIsSet() {
        final RepositoryIssuesFilter arguments =
                RepositoryIssuesFilterBuilder.builder().build();

        assertSoftly(softly -> {
            softly.assertThat(arguments.labels()).isNull();
            softly.assertThat(arguments.states()).isNull();
        });
    }

    @Test
    void builder_shouldSetEveryArgument_whenAllAreGiven() {
        final RepositoryIssuesFilter arguments = RepositoryIssuesFilterBuilder.builder()
                .labels(List.of("bug"))
                .states(List.of(IssueState.OPEN))
                .build();

        assertSoftly(softly -> {
            softly.assertThat(arguments.labels()).containsExactly("bug");
            softly.assertThat(arguments.states()).containsExactly(IssueState.OPEN);
        });
    }

    @Test
    void build_shouldCopyTheLists_whenTheSourceListChangesLater() {
        final List<String> labels = new ArrayList<>(List.of("bug"));

        final RepositoryIssuesFilter arguments =
                RepositoryIssuesFilterBuilder.builder().labels(labels).build();
        labels.add("ui");

        assertThat(arguments.labels()).containsExactly("bug");
    }

    @Test
    void labels_shouldBeUnmodifiable_whenTheArgumentsAreBuilt() {
        final RepositoryIssuesFilter arguments =
                RepositoryIssuesFilterBuilder.builder().labels(List.of("bug")).build();
        final List<String> labels = arguments.labels();

        final Throwable thrown = catchThrowable(() -> labels.add("ui"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
