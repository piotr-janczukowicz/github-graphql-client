package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AcceptTopicSuggestionPayloadTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AcceptTopicSuggestionPayload input =
                AcceptTopicSuggestionPayloadBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AcceptTopicSuggestionPayload input = AcceptTopicSuggestionPayloadBuilder.builder()
                .clientMutationId("x")
                .name("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("name", "x"), entry("repositoryId", "x"));
    }
}
