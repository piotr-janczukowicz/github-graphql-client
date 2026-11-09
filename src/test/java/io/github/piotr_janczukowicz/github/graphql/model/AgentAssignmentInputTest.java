package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AgentAssignmentInputTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AgentAssignmentInput input = AgentAssignmentInputBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AgentAssignmentInput input = AgentAssignmentInputBuilder.builder()
                .baseRef("x")
                .customAgent("x")
                .customInstructions("x")
                .targetRepositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("baseRef", "x"),
                        entry("customAgent", "x"),
                        entry("customInstructions", "x"),
                        entry("targetRepositoryId", "x"));
    }
}
