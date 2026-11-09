package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RejectPendingIssueSuggestionsPayloadTest {

    @Test
    void constructor_shouldFail_whenActorIdIsNull() {
        final RejectPendingIssueSuggestionsPayloadBuilder builder =
                RejectPendingIssueSuggestionsPayloadBuilder.builder()
                        .issueId("x")
                        .suggestions(List.of(PendingIssueSuggestionRefBuilder.builder()
                                .kind(PendingIssueSuggestionKind.ASSIGNEE)
                                .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("actorId must not be null");
    }

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final RejectPendingIssueSuggestionsPayloadBuilder builder =
                RejectPendingIssueSuggestionsPayloadBuilder.builder()
                        .actorId("x")
                        .suggestions(List.of(PendingIssueSuggestionRefBuilder.builder()
                                .kind(PendingIssueSuggestionKind.ASSIGNEE)
                                .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSuggestionsIsNull() {
        final RejectPendingIssueSuggestionsPayloadBuilder builder =
                RejectPendingIssueSuggestionsPayloadBuilder.builder()
                        .actorId("x")
                        .issueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("suggestions must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RejectPendingIssueSuggestionsPayload input = RejectPendingIssueSuggestionsPayloadBuilder.builder()
                .actorId("x")
                .issueId("x")
                .suggestions(List.of(PendingIssueSuggestionRefBuilder.builder()
                        .kind(PendingIssueSuggestionKind.ASSIGNEE)
                        .build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("actorId", "x"),
                        entry("issueId", "x"),
                        entry("suggestions", List.of(Map.ofEntries(entry("kind", "ASSIGNEE")))));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RejectPendingIssueSuggestionsPayload input = RejectPendingIssueSuggestionsPayloadBuilder.builder()
                .actorId("x")
                .clientMutationId("x")
                .issueId("x")
                .suggestions(List.of(PendingIssueSuggestionRefBuilder.builder()
                        .kind(PendingIssueSuggestionKind.ASSIGNEE)
                        .build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("actorId", "x"),
                        entry("clientMutationId", "x"),
                        entry("issueId", "x"),
                        entry("suggestions", List.of(Map.ofEntries(entry("kind", "ASSIGNEE")))));
    }
}
