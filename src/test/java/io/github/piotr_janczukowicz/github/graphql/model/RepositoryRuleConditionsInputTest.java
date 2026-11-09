package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryRuleConditionsInputTest {

    private static final String EXCLUDE = "exclude";

    private static final String NAME = "name";

    private static final String PROPERTY_VALUES = "propertyValues";

    private static final String INCLUDE = "include";

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RepositoryRuleConditionsInput input =
                RepositoryRuleConditionsInputBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RepositoryRuleConditionsInput input = RepositoryRuleConditionsInputBuilder.builder()
                .organizationProperty(OrganizationPropertyConditionTargetInputBuilder.builder()
                        .exclude(List.of(OrganizationPropertyTargetDefinitionInputBuilder.builder()
                                .name("x")
                                .propertyValues(List.of("x"))
                                .build()))
                        .include(List.of(OrganizationPropertyTargetDefinitionInputBuilder.builder()
                                .name("x")
                                .propertyValues(List.of("x"))
                                .build()))
                        .build())
                .refName(RefNameConditionTargetInputBuilder.builder()
                        .exclude(List.of("x"))
                        .include(List.of("x"))
                        .build())
                .repositoryId(RepositoryIdConditionTargetInputBuilder.builder()
                        .repositoryIds(List.of("x"))
                        .build())
                .repositoryName(RepositoryNameConditionTargetInputBuilder.builder()
                        .exclude(List.of("x"))
                        .include(List.of("x"))
                        .build())
                .repositoryProperty(RepositoryPropertyConditionTargetInputBuilder.builder()
                        .exclude(List.of(PropertyTargetDefinitionInputBuilder.builder()
                                .name("x")
                                .propertyValues(List.of("x"))
                                .build()))
                        .include(List.of(PropertyTargetDefinitionInputBuilder.builder()
                                .name("x")
                                .propertyValues(List.of("x"))
                                .build()))
                        .build())
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry(
                                "organizationProperty",
                                Map.ofEntries(
                                        entry(
                                                EXCLUDE,
                                                List.of(Map.ofEntries(
                                                        entry(NAME, "x"), entry(PROPERTY_VALUES, List.of("x"))))),
                                        entry(
                                                INCLUDE,
                                                List.of(Map.ofEntries(
                                                        entry(NAME, "x"), entry(PROPERTY_VALUES, List.of("x"))))))),
                        entry("refName", Map.ofEntries(entry(EXCLUDE, List.of("x")), entry(INCLUDE, List.of("x")))),
                        entry("repositoryId", Map.ofEntries(entry("repositoryIds", List.of("x")))),
                        entry(
                                "repositoryName",
                                Map.ofEntries(entry(EXCLUDE, List.of("x")), entry(INCLUDE, List.of("x")))),
                        entry(
                                "repositoryProperty",
                                Map.ofEntries(
                                        entry(
                                                EXCLUDE,
                                                List.of(Map.ofEntries(
                                                        entry(NAME, "x"), entry(PROPERTY_VALUES, List.of("x"))))),
                                        entry(
                                                INCLUDE,
                                                List.of(Map.ofEntries(
                                                        entry(NAME, "x"), entry(PROPERTY_VALUES, List.of("x"))))))));
    }
}
