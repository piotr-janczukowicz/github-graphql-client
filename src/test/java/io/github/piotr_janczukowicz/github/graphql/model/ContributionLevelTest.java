package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class ContributionLevelTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final ContributionLevel contributionLevel = ContributionLevel.fromWire("FIRST_QUARTILE");

        assertThat(contributionLevel).isEqualTo(ContributionLevel.FIRST_QUARTILE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final ContributionLevel contributionLevel = ContributionLevel.fromWire("NOT_A_VALUE");

        assertThat(contributionLevel).isEqualTo(ContributionLevel.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> ContributionLevel.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
