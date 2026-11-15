package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrganizationCopilotCodeReviewSettingsConflictTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrganizationCopilotCodeReviewSettingsConflict organizationCopilotCodeReviewSettingsConflict =
                OrganizationCopilotCodeReviewSettingsConflict.fromWire("SETTING_NOT_EDITABLE");

        assertThat(organizationCopilotCodeReviewSettingsConflict)
                .isEqualTo(OrganizationCopilotCodeReviewSettingsConflict.SETTING_NOT_EDITABLE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrganizationCopilotCodeReviewSettingsConflict organizationCopilotCodeReviewSettingsConflict =
                OrganizationCopilotCodeReviewSettingsConflict.fromWire("NOT_A_VALUE");

        assertThat(organizationCopilotCodeReviewSettingsConflict)
                .isEqualTo(OrganizationCopilotCodeReviewSettingsConflict.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrganizationCopilotCodeReviewSettingsConflict.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
