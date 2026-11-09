package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PinnedDiscussionGradientTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final PinnedDiscussionGradient pinnedDiscussionGradient = PinnedDiscussionGradient.fromWire("BLUE_MINT");

        assertThat(pinnedDiscussionGradient).isEqualTo(PinnedDiscussionGradient.BLUE_MINT);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final PinnedDiscussionGradient pinnedDiscussionGradient = PinnedDiscussionGradient.fromWire("NOT_A_VALUE");

        assertThat(pinnedDiscussionGradient).isEqualTo(PinnedDiscussionGradient.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> PinnedDiscussionGradient.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
