package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckSuiteAutoTriggerPreferenceTest {

    @Test
    void constructor_shouldFail_whenAppIdIsNull() {
        final CheckSuiteAutoTriggerPreferenceBuilder builder =
                CheckSuiteAutoTriggerPreferenceBuilder.builder().setting(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("appId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSettingIsNull() {
        final CheckSuiteAutoTriggerPreferenceBuilder builder =
                CheckSuiteAutoTriggerPreferenceBuilder.builder().appId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("setting must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CheckSuiteAutoTriggerPreference input = CheckSuiteAutoTriggerPreferenceBuilder.builder()
                .appId("x")
                .setting(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("appId", "x"), entry("setting", true));
    }
}
