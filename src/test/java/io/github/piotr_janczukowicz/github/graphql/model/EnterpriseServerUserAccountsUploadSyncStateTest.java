package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class EnterpriseServerUserAccountsUploadSyncStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final EnterpriseServerUserAccountsUploadSyncState enterpriseServerUserAccountsUploadSyncState =
                EnterpriseServerUserAccountsUploadSyncState.fromWire("FAILURE");

        assertThat(enterpriseServerUserAccountsUploadSyncState)
                .isEqualTo(EnterpriseServerUserAccountsUploadSyncState.FAILURE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final EnterpriseServerUserAccountsUploadSyncState enterpriseServerUserAccountsUploadSyncState =
                EnterpriseServerUserAccountsUploadSyncState.fromWire("NOT_A_VALUE");

        assertThat(enterpriseServerUserAccountsUploadSyncState)
                .isEqualTo(EnterpriseServerUserAccountsUploadSyncState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> EnterpriseServerUserAccountsUploadSyncState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
