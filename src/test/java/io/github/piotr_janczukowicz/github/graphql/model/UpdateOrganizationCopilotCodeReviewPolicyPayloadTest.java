package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateOrganizationCopilotCodeReviewPolicyPayloadTest {

    @Test
    void constructor_shouldFail_whenOrganizationIdIsNull() {
        final UpdateOrganizationCopilotCodeReviewPolicyPayloadBuilder builder =
                UpdateOrganizationCopilotCodeReviewPolicyPayloadBuilder.builder()
                        .state(OrganizationCopilotCodeReviewPolicyState.DISABLED);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationId must not be null");
    }

    @Test
    void constructor_shouldFail_whenStateIsNull() {
        final UpdateOrganizationCopilotCodeReviewPolicyPayloadBuilder builder =
                UpdateOrganizationCopilotCodeReviewPolicyPayloadBuilder.builder()
                        .organizationId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("state must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateOrganizationCopilotCodeReviewPolicyPayload input =
                UpdateOrganizationCopilotCodeReviewPolicyPayloadBuilder.builder()
                        .organizationId("x")
                        .state(OrganizationCopilotCodeReviewPolicyState.DISABLED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("organizationId", "x"), entry("state", "DISABLED"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateOrganizationCopilotCodeReviewPolicyPayload input =
                UpdateOrganizationCopilotCodeReviewPolicyPayloadBuilder.builder()
                        .clientMutationId("x")
                        .organizationId("x")
                        .state(OrganizationCopilotCodeReviewPolicyState.DISABLED)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("organizationId", "x"), entry("state", "DISABLED"));
    }
}
