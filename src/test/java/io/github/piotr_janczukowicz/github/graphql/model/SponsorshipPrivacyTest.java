package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class SponsorshipPrivacyTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final SponsorshipPrivacy sponsorshipPrivacy = SponsorshipPrivacy.fromWire("PRIVATE");

        assertThat(sponsorshipPrivacy).isEqualTo(SponsorshipPrivacy.PRIVATE);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final SponsorshipPrivacy sponsorshipPrivacy = SponsorshipPrivacy.fromWire("NOT_A_VALUE");

        assertThat(sponsorshipPrivacy).isEqualTo(SponsorshipPrivacy.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> SponsorshipPrivacy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = SponsorshipPrivacy.PRIVATE.wireValue();

        assertThat(value).isEqualTo("PRIVATE");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(SponsorshipPrivacy.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
