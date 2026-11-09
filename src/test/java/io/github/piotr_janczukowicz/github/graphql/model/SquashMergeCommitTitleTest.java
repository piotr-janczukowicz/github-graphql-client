package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SquashMergeCommitTitleTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SquashMergeCommitTitle squashMergeCommitTitle = SquashMergeCommitTitle.fromWire("COMMIT_OR_PR_TITLE");

        assertThat(squashMergeCommitTitle).isEqualTo(SquashMergeCommitTitle.COMMIT_OR_PR_TITLE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SquashMergeCommitTitle squashMergeCommitTitle = SquashMergeCommitTitle.fromWire("NOT_A_VALUE");

        assertThat(squashMergeCommitTitle).isEqualTo(SquashMergeCommitTitle.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SquashMergeCommitTitle.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
