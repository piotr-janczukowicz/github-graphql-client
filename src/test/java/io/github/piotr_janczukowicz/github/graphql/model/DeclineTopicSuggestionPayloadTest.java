package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
@SuppressWarnings("removal")
class DeclineTopicSuggestionPayloadTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeclineTopicSuggestionPayload input =
                DeclineTopicSuggestionPayloadBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeclineTopicSuggestionPayload input = DeclineTopicSuggestionPayloadBuilder.builder()
                .clientMutationId("x")
                .name("x")
                .reason(TopicSuggestionDeclineReason.NOT_RELEVANT)
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("name", "x"),
                        entry("reason", "NOT_RELEVANT"),
                        entry("repositoryId", "x"));
    }
}
