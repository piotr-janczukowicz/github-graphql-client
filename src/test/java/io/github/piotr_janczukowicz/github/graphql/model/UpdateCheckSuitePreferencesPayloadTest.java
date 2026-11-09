package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateCheckSuitePreferencesPayloadTest {

    @Test
    void constructor_shouldFail_whenAutoTriggerPreferencesIsNull() {
        final UpdateCheckSuitePreferencesPayloadBuilder builder =
                UpdateCheckSuitePreferencesPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("autoTriggerPreferences must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final UpdateCheckSuitePreferencesPayloadBuilder builder = UpdateCheckSuitePreferencesPayloadBuilder.builder()
                .autoTriggerPreferences(List.of(CheckSuiteAutoTriggerPreferenceBuilder.builder()
                        .appId("x")
                        .setting(true)
                        .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateCheckSuitePreferencesPayload input = UpdateCheckSuitePreferencesPayloadBuilder.builder()
                .autoTriggerPreferences(List.of(CheckSuiteAutoTriggerPreferenceBuilder.builder()
                        .appId("x")
                        .setting(true)
                        .build()))
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry(
                                "autoTriggerPreferences",
                                List.of(Map.ofEntries(entry("appId", "x"), entry("setting", true)))),
                        entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateCheckSuitePreferencesPayload input = UpdateCheckSuitePreferencesPayloadBuilder.builder()
                .autoTriggerPreferences(List.of(CheckSuiteAutoTriggerPreferenceBuilder.builder()
                        .appId("x")
                        .setting(true)
                        .build()))
                .clientMutationId("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry(
                                "autoTriggerPreferences",
                                List.of(Map.ofEntries(entry("appId", "x"), entry("setting", true)))),
                        entry("clientMutationId", "x"),
                        entry("repositoryId", "x"));
    }
}
