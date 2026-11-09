package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class LabelUpdateInputTest {

    @Test
    void constructor_shouldFail_whenLabelIdIsNull() {
        final LabelUpdateInputBuilder builder = LabelUpdateInputBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("labelId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final LabelUpdateInput input =
                LabelUpdateInputBuilder.builder().labelId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("labelId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final LabelUpdateInput input = LabelUpdateInputBuilder.builder()
                .confidence(IssueEventConfidenceLevel.HIGH)
                .labelId("x")
                .rationale("x")
                .suggest(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("confidence", "HIGH"),
                        entry("labelId", "x"),
                        entry("rationale", "x"),
                        entry("suggest", true));
    }
}
