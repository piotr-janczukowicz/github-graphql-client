package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class TeamNotificationSettingTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final TeamNotificationSetting teamNotificationSetting =
                TeamNotificationSetting.fromWire("NOTIFICATIONS_DISABLED");

        assertThat(teamNotificationSetting).isEqualTo(TeamNotificationSetting.NOTIFICATIONS_DISABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final TeamNotificationSetting teamNotificationSetting = TeamNotificationSetting.fromWire("NOT_A_VALUE");

        assertThat(teamNotificationSetting).isEqualTo(TeamNotificationSetting.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> TeamNotificationSetting.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }
}
