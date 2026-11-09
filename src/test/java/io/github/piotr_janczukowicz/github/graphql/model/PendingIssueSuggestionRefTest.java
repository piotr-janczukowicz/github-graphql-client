package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class PendingIssueSuggestionRefTest {

    @Test
    void constructor_shouldFail_whenKindIsNull() {
        final PendingIssueSuggestionRefBuilder builder = PendingIssueSuggestionRefBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("kind must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final PendingIssueSuggestionRef input = PendingIssueSuggestionRefBuilder.builder()
                .kind(PendingIssueSuggestionKind.ASSIGNEE)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("kind", "ASSIGNEE"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final PendingIssueSuggestionRef input = PendingIssueSuggestionRefBuilder.builder()
                .assigneeId("x")
                .issueFieldId("x")
                .issueTypeId("x")
                .kind(PendingIssueSuggestionKind.ASSIGNEE)
                .labelId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("assigneeId", "x"),
                        entry("issueFieldId", "x"),
                        entry("issueTypeId", "x"),
                        entry("kind", "ASSIGNEE"),
                        entry("labelId", "x"));
    }
}
