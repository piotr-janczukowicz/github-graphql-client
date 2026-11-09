package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SponsorshipPaymentSourceTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SponsorshipPaymentSource sponsorshipPaymentSource = SponsorshipPaymentSource.fromWire("GITHUB");

        assertThat(sponsorshipPaymentSource).isEqualTo(SponsorshipPaymentSource.GITHUB);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SponsorshipPaymentSource sponsorshipPaymentSource = SponsorshipPaymentSource.fromWire("NOT_A_VALUE");

        assertThat(sponsorshipPaymentSource).isEqualTo(SponsorshipPaymentSource.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SponsorshipPaymentSource.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
