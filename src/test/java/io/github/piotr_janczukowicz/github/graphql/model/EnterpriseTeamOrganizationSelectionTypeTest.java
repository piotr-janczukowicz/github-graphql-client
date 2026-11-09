package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseTeamOrganizationSelectionTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseTeamOrganizationSelectionType enterpriseTeamOrganizationSelectionType =
                EnterpriseTeamOrganizationSelectionType.fromWire("ALL");

        assertThat(enterpriseTeamOrganizationSelectionType).isEqualTo(EnterpriseTeamOrganizationSelectionType.ALL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseTeamOrganizationSelectionType enterpriseTeamOrganizationSelectionType =
                EnterpriseTeamOrganizationSelectionType.fromWire("NOT_A_VALUE");

        assertThat(enterpriseTeamOrganizationSelectionType)
                .isEqualTo(EnterpriseTeamOrganizationSelectionType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> EnterpriseTeamOrganizationSelectionType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
