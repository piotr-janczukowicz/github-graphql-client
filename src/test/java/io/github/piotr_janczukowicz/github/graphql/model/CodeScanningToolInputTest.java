package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CodeScanningToolInputTest {

    @Test
    void constructor_shouldFail_whenAlertsThresholdIsNull() {
        final CodeScanningToolInputBuilder builder = CodeScanningToolInputBuilder.builder()
                .securityAlertsThreshold("x")
                .tool("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("alertsThreshold must not be null");
    }

    @Test
    void constructor_shouldFail_whenSecurityAlertsThresholdIsNull() {
        final CodeScanningToolInputBuilder builder =
                CodeScanningToolInputBuilder.builder().alertsThreshold("x").tool("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("securityAlertsThreshold must not be null");
    }

    @Test
    void constructor_shouldFail_whenToolIsNull() {
        final CodeScanningToolInputBuilder builder =
                CodeScanningToolInputBuilder.builder().alertsThreshold("x").securityAlertsThreshold("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("tool must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CodeScanningToolInput input = CodeScanningToolInputBuilder.builder()
                .alertsThreshold("x")
                .securityAlertsThreshold("x")
                .tool("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("alertsThreshold", "x"), entry("securityAlertsThreshold", "x"), entry("tool", "x"));
    }
}
