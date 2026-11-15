package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateOrganizationCopilotCodeReviewSettingsPayloadTest {

    @Test
    void constructor_shouldFail_whenOrganizationIdIsNull() {
        final UpdateOrganizationCopilotCodeReviewSettingsPayloadBuilder builder =
                UpdateOrganizationCopilotCodeReviewSettingsPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("organizationId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateOrganizationCopilotCodeReviewSettingsPayload input =
                UpdateOrganizationCopilotCodeReviewSettingsPayloadBuilder.builder()
                        .organizationId("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("organizationId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateOrganizationCopilotCodeReviewSettingsPayload input =
                UpdateOrganizationCopilotCodeReviewSettingsPayloadBuilder.builder()
                        .clientMutationId("x")
                        .defaultReviewEffort(OrganizationCopilotCodeReviewEffortSetting.AUTO)
                        .organizationId("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("defaultReviewEffort", "AUTO"),
                        entry("organizationId", "x"));
    }
}
