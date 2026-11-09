package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RemoveReactionPayloadTest {

    @Test
    void constructor_shouldFail_whenContentIsNull() {
        final RemoveReactionPayloadBuilder builder =
                RemoveReactionPayloadBuilder.builder().subjectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("content must not be null");
    }

    @Test
    void constructor_shouldFail_whenSubjectIdIsNull() {
        final RemoveReactionPayloadBuilder builder =
                RemoveReactionPayloadBuilder.builder().content(ReactionContent.CONFUSED);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("subjectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RemoveReactionPayload input = RemoveReactionPayloadBuilder.builder()
                .content(ReactionContent.CONFUSED)
                .subjectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("content", "CONFUSED"), entry("subjectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RemoveReactionPayload input = RemoveReactionPayloadBuilder.builder()
                .clientMutationId("x")
                .content(ReactionContent.CONFUSED)
                .subjectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("content", "CONFUSED"), entry("subjectId", "x"));
    }
}
