package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueEventConfidenceLevelTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final IssueEventConfidenceLevel issueEventConfidenceLevel = IssueEventConfidenceLevel.fromWire("HIGH");

        assertThat(issueEventConfidenceLevel).isEqualTo(IssueEventConfidenceLevel.HIGH);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final IssueEventConfidenceLevel issueEventConfidenceLevel = IssueEventConfidenceLevel.fromWire("NOT_A_VALUE");

        assertThat(issueEventConfidenceLevel).isEqualTo(IssueEventConfidenceLevel.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> IssueEventConfidenceLevel.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = IssueEventConfidenceLevel.HIGH.wireValue();

        assertThat(value).isEqualTo("HIGH");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(IssueEventConfidenceLevel.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
