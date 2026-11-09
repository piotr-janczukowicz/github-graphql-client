package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class RepoChangeMergeSettingAuditEntryMergeTypeTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final RepoChangeMergeSettingAuditEntryMergeType repoChangeMergeSettingAuditEntryMergeType =
                RepoChangeMergeSettingAuditEntryMergeType.fromWire("MERGE");

        assertThat(repoChangeMergeSettingAuditEntryMergeType)
                .isEqualTo(RepoChangeMergeSettingAuditEntryMergeType.MERGE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final RepoChangeMergeSettingAuditEntryMergeType repoChangeMergeSettingAuditEntryMergeType =
                RepoChangeMergeSettingAuditEntryMergeType.fromWire("NOT_A_VALUE");

        assertThat(repoChangeMergeSettingAuditEntryMergeType)
                .isEqualTo(RepoChangeMergeSettingAuditEntryMergeType.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> RepoChangeMergeSettingAuditEntryMergeType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
