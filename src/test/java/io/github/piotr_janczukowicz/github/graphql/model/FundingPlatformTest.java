package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class FundingPlatformTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final FundingPlatform fundingPlatform = FundingPlatform.fromWire("BUY_ME_A_COFFEE");

        assertThat(fundingPlatform).isEqualTo(FundingPlatform.BUY_ME_A_COFFEE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final FundingPlatform fundingPlatform = FundingPlatform.fromWire("NOT_A_VALUE");

        assertThat(fundingPlatform).isEqualTo(FundingPlatform.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> FundingPlatform.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
