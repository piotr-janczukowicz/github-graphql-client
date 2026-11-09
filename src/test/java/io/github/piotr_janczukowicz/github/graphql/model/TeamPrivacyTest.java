package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class TeamPrivacyTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final TeamPrivacy teamPrivacy = TeamPrivacy.fromWire("SECRET");

        assertThat(teamPrivacy).isEqualTo(TeamPrivacy.SECRET);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final TeamPrivacy teamPrivacy = TeamPrivacy.fromWire("NOT_A_VALUE");

        assertThat(teamPrivacy).isEqualTo(TeamPrivacy.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> TeamPrivacy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
