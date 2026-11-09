package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueFieldSingleSelectOptionColorTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final IssueFieldSingleSelectOptionColor issueFieldSingleSelectOptionColor =
                IssueFieldSingleSelectOptionColor.fromWire("BLUE");

        assertThat(issueFieldSingleSelectOptionColor).isEqualTo(IssueFieldSingleSelectOptionColor.BLUE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final IssueFieldSingleSelectOptionColor issueFieldSingleSelectOptionColor =
                IssueFieldSingleSelectOptionColor.fromWire("NOT_A_VALUE");

        assertThat(issueFieldSingleSelectOptionColor).isEqualTo(IssueFieldSingleSelectOptionColor.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> IssueFieldSingleSelectOptionColor.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = IssueFieldSingleSelectOptionColor.BLUE.wireValue();

        assertThat(value).isEqualTo("BLUE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(IssueFieldSingleSelectOptionColor.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
