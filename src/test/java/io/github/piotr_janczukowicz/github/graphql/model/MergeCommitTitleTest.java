package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeCommitTitleTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MergeCommitTitle mergeCommitTitle = MergeCommitTitle.fromWire("MERGE_MESSAGE");

        assertThat(mergeCommitTitle).isEqualTo(MergeCommitTitle.MERGE_MESSAGE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MergeCommitTitle mergeCommitTitle = MergeCommitTitle.fromWire("NOT_A_VALUE");

        assertThat(mergeCommitTitle).isEqualTo(MergeCommitTitle.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MergeCommitTitle.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
