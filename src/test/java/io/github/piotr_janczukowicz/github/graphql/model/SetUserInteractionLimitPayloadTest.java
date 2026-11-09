package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SetUserInteractionLimitPayloadTest {

    @Test
    void constructor_shouldFail_whenLimitIsNull() {
        final SetUserInteractionLimitPayloadBuilder builder =
                SetUserInteractionLimitPayloadBuilder.builder().userId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("limit must not be null");
    }

    @Test
    void constructor_shouldFail_whenUserIdIsNull() {
        final SetUserInteractionLimitPayloadBuilder builder =
                SetUserInteractionLimitPayloadBuilder.builder().limit(RepositoryInteractionLimit.COLLABORATORS_ONLY);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("userId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final SetUserInteractionLimitPayload input = SetUserInteractionLimitPayloadBuilder.builder()
                .limit(RepositoryInteractionLimit.COLLABORATORS_ONLY)
                .userId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("limit", "COLLABORATORS_ONLY"), entry("userId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final SetUserInteractionLimitPayload input = SetUserInteractionLimitPayloadBuilder.builder()
                .clientMutationId("x")
                .expiry(RepositoryInteractionLimitExpiry.ONE_DAY)
                .limit(RepositoryInteractionLimit.COLLABORATORS_ONLY)
                .userId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("expiry", "ONE_DAY"),
                        entry("limit", "COLLABORATORS_ONLY"),
                        entry("userId", "x"));
    }
}
