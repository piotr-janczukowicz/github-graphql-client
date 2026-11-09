package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SquashMergeCommitMessageTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SquashMergeCommitMessage squashMergeCommitMessage = SquashMergeCommitMessage.fromWire("BLANK");

        assertThat(squashMergeCommitMessage).isEqualTo(SquashMergeCommitMessage.BLANK);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SquashMergeCommitMessage squashMergeCommitMessage = SquashMergeCommitMessage.fromWire("NOT_A_VALUE");

        assertThat(squashMergeCommitMessage).isEqualTo(SquashMergeCommitMessage.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SquashMergeCommitMessage.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
