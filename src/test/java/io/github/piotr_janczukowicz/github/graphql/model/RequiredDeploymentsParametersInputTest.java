package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RequiredDeploymentsParametersInputTest {

    @Test
    void constructor_shouldFail_whenRequiredDeploymentEnvironmentsIsNull() {
        final RequiredDeploymentsParametersInputBuilder builder = RequiredDeploymentsParametersInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("requiredDeploymentEnvironments must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RequiredDeploymentsParametersInput input = RequiredDeploymentsParametersInputBuilder.builder()
                .requiredDeploymentEnvironments(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("requiredDeploymentEnvironments", List.of("x")));
    }
}
