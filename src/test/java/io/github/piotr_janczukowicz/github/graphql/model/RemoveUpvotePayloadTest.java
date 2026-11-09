package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RemoveUpvotePayloadTest {

    @Test
    void constructor_shouldFail_whenSubjectIdIsNull() {
        final RemoveUpvotePayloadBuilder builder = RemoveUpvotePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("subjectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RemoveUpvotePayload input =
                RemoveUpvotePayloadBuilder.builder().subjectId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("subjectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RemoveUpvotePayload input = RemoveUpvotePayloadBuilder.builder()
                .clientMutationId("x")
                .subjectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("subjectId", "x"));
    }
}
