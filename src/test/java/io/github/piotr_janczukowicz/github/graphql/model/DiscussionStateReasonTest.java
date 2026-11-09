package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class DiscussionStateReasonTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final DiscussionStateReason discussionStateReason = DiscussionStateReason.fromWire("DUPLICATE");

        assertThat(discussionStateReason).isEqualTo(DiscussionStateReason.DUPLICATE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final DiscussionStateReason discussionStateReason = DiscussionStateReason.fromWire("NOT_A_VALUE");

        assertThat(discussionStateReason).isEqualTo(DiscussionStateReason.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> DiscussionStateReason.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
