package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class CommentCannotUpdateReasonTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final CommentCannotUpdateReason commentCannotUpdateReason = CommentCannotUpdateReason.fromWire("ARCHIVED");

        assertThat(commentCannotUpdateReason).isEqualTo(CommentCannotUpdateReason.ARCHIVED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final CommentCannotUpdateReason commentCannotUpdateReason = CommentCannotUpdateReason.fromWire("NOT_A_VALUE");

        assertThat(commentCannotUpdateReason).isEqualTo(CommentCannotUpdateReason.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> CommentCannotUpdateReason.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
