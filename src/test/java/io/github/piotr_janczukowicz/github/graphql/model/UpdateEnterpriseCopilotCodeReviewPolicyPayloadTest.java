package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnterpriseCopilotCodeReviewPolicyPayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final UpdateEnterpriseCopilotCodeReviewPolicyPayloadBuilder builder =
                UpdateEnterpriseCopilotCodeReviewPolicyPayloadBuilder.builder()
                        .policyState(EnterpriseCopilotCodeReviewPolicyState.CONFIGURED_BY_ORGANIZATION_ADMINS);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void constructor_shouldFail_whenPolicyStateIsNull() {
        final UpdateEnterpriseCopilotCodeReviewPolicyPayloadBuilder builder =
                UpdateEnterpriseCopilotCodeReviewPolicyPayloadBuilder.builder().enterpriseId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("policyState must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnterpriseCopilotCodeReviewPolicyPayload input =
                UpdateEnterpriseCopilotCodeReviewPolicyPayloadBuilder.builder()
                        .enterpriseId("x")
                        .policyState(EnterpriseCopilotCodeReviewPolicyState.CONFIGURED_BY_ORGANIZATION_ADMINS)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("enterpriseId", "x"), entry("policyState", "CONFIGURED_BY_ORGANIZATION_ADMINS"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnterpriseCopilotCodeReviewPolicyPayload input =
                UpdateEnterpriseCopilotCodeReviewPolicyPayloadBuilder.builder()
                        .clientMutationId("x")
                        .enterpriseId("x")
                        .policyState(EnterpriseCopilotCodeReviewPolicyState.CONFIGURED_BY_ORGANIZATION_ADMINS)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("enterpriseId", "x"),
                        entry("policyState", "CONFIGURED_BY_ORGANIZATION_ADMINS"));
    }
}
