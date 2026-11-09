package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueStateTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final IssueState issueState = IssueState.fromWire("CLOSED");

        assertThat(issueState).isEqualTo(IssueState.CLOSED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final IssueState issueState = IssueState.fromWire("NOT_A_VALUE");

        assertThat(issueState).isEqualTo(IssueState.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> IssueState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = IssueState.CLOSED.wireValue();

        assertThat(value).isEqualTo("CLOSED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(IssueState.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
