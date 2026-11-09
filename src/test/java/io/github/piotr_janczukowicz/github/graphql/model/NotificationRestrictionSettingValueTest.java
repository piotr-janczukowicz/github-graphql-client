package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class NotificationRestrictionSettingValueTest {

    @Test
    void fromWire_shouldReturnTheConstant_whenTheValueIsKnown() {
        final NotificationRestrictionSettingValue notificationRestrictionSettingValue =
                NotificationRestrictionSettingValue.fromWire("DISABLED");

        assertThat(notificationRestrictionSettingValue).isEqualTo(NotificationRestrictionSettingValue.DISABLED);
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final NotificationRestrictionSettingValue notificationRestrictionSettingValue =
                NotificationRestrictionSettingValue.fromWire("NOT_A_VALUE");

        assertThat(notificationRestrictionSettingValue).isEqualTo(NotificationRestrictionSettingValue.UNRECOGNIZED);
    }

    @Test
    void fromWire_shouldFail_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> NotificationRestrictionSettingValue.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void wireValue_shouldReturnTheName_whenTheConstantIsKnown() {
        final String value = NotificationRestrictionSettingValue.DISABLED.wireValue();

        assertThat(value).isEqualTo("DISABLED");
    }

    @Test
    void wireValue_shouldFail_whenTheConstantIsUnrecognized() {
        final Throwable thrown = catchThrowable(NotificationRestrictionSettingValue.UNRECOGNIZED::wireValue);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("UNRECOGNIZED");
    }
}
