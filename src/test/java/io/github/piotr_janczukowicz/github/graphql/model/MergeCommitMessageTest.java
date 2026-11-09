package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class MergeCommitMessageTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final MergeCommitMessage mergeCommitMessage = MergeCommitMessage.fromWire("BLANK");

        assertThat(mergeCommitMessage).isEqualTo(MergeCommitMessage.BLANK);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final MergeCommitMessage mergeCommitMessage = MergeCommitMessage.fromWire("NOT_A_VALUE");

        assertThat(mergeCommitMessage).isEqualTo(MergeCommitMessage.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> MergeCommitMessage.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
