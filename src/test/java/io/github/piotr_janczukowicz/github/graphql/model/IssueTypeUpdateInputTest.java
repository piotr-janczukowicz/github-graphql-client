package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.json.OptionalNull;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;

@UnitTest
class IssueTypeUpdateInputTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final IssueTypeUpdateInput input = IssueTypeUpdateInputBuilder.builder().build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final IssueTypeUpdateInput input = IssueTypeUpdateInputBuilder.builder()
                .confidence(IssueEventConfidenceLevel.HIGH)
                .issueTypeId(OptionalNull.of("x"))
                .rationale("x")
                .suggest(true)
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("confidence", "HIGH"),
                        entry("issueTypeId", "x"),
                        entry("rationale", "x"),
                        entry("suggest", true));
    }

    @Test
    void toVariable_shouldSendNull_whenIssueTypeIdIsExplicitlyNull() {
        final IssueTypeUpdateInput input = IssueTypeUpdateInputBuilder.builder()
                .issueTypeId(OptionalNull.ofNull())
                .build();

        final Map<String, @Nullable Object> variable = input.toVariable();

        assertThat(variable).containsEntry("issueTypeId", null);
    }
}
