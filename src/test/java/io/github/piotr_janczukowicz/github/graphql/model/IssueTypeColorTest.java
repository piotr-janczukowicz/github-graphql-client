package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueTypeColorTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final IssueTypeColor issueTypeColor = IssueTypeColor.fromWire("BLUE");

        assertThat(issueTypeColor).isEqualTo(IssueTypeColor.BLUE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final IssueTypeColor issueTypeColor = IssueTypeColor.fromWire("NOT_A_VALUE");

        assertThat(issueTypeColor).isEqualTo(IssueTypeColor.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> IssueTypeColor.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = IssueTypeColor.BLUE.wireValue();

        assertThat(value).isEqualTo("BLUE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(IssueTypeColor.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
