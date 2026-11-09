package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class OauthApplicationCreateAuditEntryStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final OauthApplicationCreateAuditEntryState oauthApplicationCreateAuditEntryState =
                OauthApplicationCreateAuditEntryState.fromWire("ACTIVE");

        assertThat(oauthApplicationCreateAuditEntryState).isEqualTo(OauthApplicationCreateAuditEntryState.ACTIVE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final OauthApplicationCreateAuditEntryState oauthApplicationCreateAuditEntryState =
                OauthApplicationCreateAuditEntryState.fromWire("NOT_A_VALUE");

        assertThat(oauthApplicationCreateAuditEntryState).isEqualTo(OauthApplicationCreateAuditEntryState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> OauthApplicationCreateAuditEntryState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
