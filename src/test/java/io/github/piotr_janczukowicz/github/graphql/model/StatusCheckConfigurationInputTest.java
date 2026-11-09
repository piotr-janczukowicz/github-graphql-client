package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class StatusCheckConfigurationInputTest {

    @Test
    void constructor_shouldFail_whenContextIsNull() {
        final StatusCheckConfigurationInputBuilder builder = StatusCheckConfigurationInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("context must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final StatusCheckConfigurationInput input =
                StatusCheckConfigurationInputBuilder.builder().context("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("context", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final StatusCheckConfigurationInput input = StatusCheckConfigurationInputBuilder.builder()
                .context("x")
                .integrationId(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("context", "x"), entry("integrationId", 1));
    }
}
