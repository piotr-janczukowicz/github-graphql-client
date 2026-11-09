package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ResolveReviewThreadPayloadTest {

    @Test
    void constructor_shouldFail_whenThreadIdIsNull() {
        final ResolveReviewThreadPayloadBuilder builder = ResolveReviewThreadPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("threadId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ResolveReviewThreadPayload input =
                ResolveReviewThreadPayloadBuilder.builder().threadId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("threadId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ResolveReviewThreadPayload input = ResolveReviewThreadPayloadBuilder.builder()
                .clientMutationId("x")
                .resolutionReason(PullRequestReviewThreadResolutionReason.ADDRESSED)
                .threadId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("resolutionReason", "ADDRESSED"), entry("threadId", "x"));
    }
}
