package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class OrganizationPropertyConditionTargetInputTest {

    @Test
    void constructor_shouldFail_whenExcludeIsNull() {
        final OrganizationPropertyConditionTargetInputBuilder builder =
                OrganizationPropertyConditionTargetInputBuilder.builder()
                        .include(List.of(OrganizationPropertyTargetDefinitionInputBuilder.builder()
                                .name("x")
                                .propertyValues(List.of("x"))
                                .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("exclude must not be null");
    }

    @Test
    void constructor_shouldFail_whenIncludeIsNull() {
        final OrganizationPropertyConditionTargetInputBuilder builder =
                OrganizationPropertyConditionTargetInputBuilder.builder()
                        .exclude(List.of(OrganizationPropertyTargetDefinitionInputBuilder.builder()
                                .name("x")
                                .propertyValues(List.of("x"))
                                .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("include must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final OrganizationPropertyConditionTargetInput input = OrganizationPropertyConditionTargetInputBuilder.builder()
                .exclude(List.of(OrganizationPropertyTargetDefinitionInputBuilder.builder()
                        .name("x")
                        .propertyValues(List.of("x"))
                        .build()))
                .include(List.of(OrganizationPropertyTargetDefinitionInputBuilder.builder()
                        .name("x")
                        .propertyValues(List.of("x"))
                        .build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry(
                                "exclude",
                                List.of(Map.ofEntries(entry("name", "x"), entry("propertyValues", List.of("x"))))),
                        entry(
                                "include",
                                List.of(Map.ofEntries(entry("name", "x"), entry("propertyValues", List.of("x"))))));
    }
}
