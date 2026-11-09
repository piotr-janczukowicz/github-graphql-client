package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OrganizationInvitationTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OrganizationInvitationType organizationInvitationType = OrganizationInvitationType.fromWire("EMAIL");

        assertThat(organizationInvitationType).isEqualTo(OrganizationInvitationType.EMAIL);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OrganizationInvitationType organizationInvitationType =
                OrganizationInvitationType.fromWire("NOT_A_VALUE");

        assertThat(organizationInvitationType).isEqualTo(OrganizationInvitationType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OrganizationInvitationType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
