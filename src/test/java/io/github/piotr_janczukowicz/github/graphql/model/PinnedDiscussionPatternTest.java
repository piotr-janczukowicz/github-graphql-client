package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PinnedDiscussionPatternTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PinnedDiscussionPattern pinnedDiscussionPattern = PinnedDiscussionPattern.fromWire("CHEVRON_UP");

        assertThat(pinnedDiscussionPattern).isEqualTo(PinnedDiscussionPattern.CHEVRON_UP);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PinnedDiscussionPattern pinnedDiscussionPattern = PinnedDiscussionPattern.fromWire("NOT_A_VALUE");

        assertThat(pinnedDiscussionPattern).isEqualTo(PinnedDiscussionPattern.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PinnedDiscussionPattern.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
