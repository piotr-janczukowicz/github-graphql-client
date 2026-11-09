package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrganizationInvitationRoleTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrganizationInvitationRole organizationInvitationRole = OrganizationInvitationRole.fromWire("ADMIN");

        assertThat(organizationInvitationRole).isEqualTo(OrganizationInvitationRole.ADMIN);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrganizationInvitationRole organizationInvitationRole =
                OrganizationInvitationRole.fromWire("NOT_A_VALUE");

        assertThat(organizationInvitationRole).isEqualTo(OrganizationInvitationRole.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrganizationInvitationRole.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
