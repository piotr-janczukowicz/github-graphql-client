package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrganizationInvitationSourceTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrganizationInvitationSource organizationInvitationSource =
                OrganizationInvitationSource.fromWire("ENTERPRISE_ORGANIZATION_CREATION");

        assertThat(organizationInvitationSource)
                .isEqualTo(OrganizationInvitationSource.ENTERPRISE_ORGANIZATION_CREATION);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrganizationInvitationSource organizationInvitationSource =
                OrganizationInvitationSource.fromWire("NOT_A_VALUE");

        assertThat(organizationInvitationSource).isEqualTo(OrganizationInvitationSource.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrganizationInvitationSource.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
