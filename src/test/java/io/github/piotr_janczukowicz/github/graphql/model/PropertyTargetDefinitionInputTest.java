package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class PropertyTargetDefinitionInputTest {

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final PropertyTargetDefinitionInputBuilder builder =
                PropertyTargetDefinitionInputBuilder.builder().propertyValues(List.of("x"));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenPropertyValuesIsNull() {
        final PropertyTargetDefinitionInputBuilder builder =
                PropertyTargetDefinitionInputBuilder.builder().name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("propertyValues must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final PropertyTargetDefinitionInput input = PropertyTargetDefinitionInputBuilder.builder()
                .name("x")
                .propertyValues(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("name", "x"), entry("propertyValues", List.of("x")));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final PropertyTargetDefinitionInput input = PropertyTargetDefinitionInputBuilder.builder()
                .name("x")
                .propertyValues(List.of("x"))
                .source("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("name", "x"), entry("propertyValues", List.of("x")), entry("source", "x"));
    }
}
