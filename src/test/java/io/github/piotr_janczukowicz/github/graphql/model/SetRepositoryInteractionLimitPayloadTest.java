package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SetRepositoryInteractionLimitPayloadTest {

    @Test
    void constructor_shouldFail_whenLimitIsNull() {
        final SetRepositoryInteractionLimitPayloadBuilder builder =
                SetRepositoryInteractionLimitPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("limit must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final SetRepositoryInteractionLimitPayloadBuilder builder =
                SetRepositoryInteractionLimitPayloadBuilder.builder()
                        .limit(RepositoryInteractionLimit.COLLABORATORS_ONLY);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final SetRepositoryInteractionLimitPayload input = SetRepositoryInteractionLimitPayloadBuilder.builder()
                .limit(RepositoryInteractionLimit.COLLABORATORS_ONLY)
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("limit", "COLLABORATORS_ONLY"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final SetRepositoryInteractionLimitPayload input = SetRepositoryInteractionLimitPayloadBuilder.builder()
                .clientMutationId("x")
                .expiry(RepositoryInteractionLimitExpiry.ONE_DAY)
                .limit(RepositoryInteractionLimit.COLLABORATORS_ONLY)
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("expiry", "ONE_DAY"),
                        entry("limit", "COLLABORATORS_ONLY"),
                        entry("repositoryId", "x"));
    }
}
