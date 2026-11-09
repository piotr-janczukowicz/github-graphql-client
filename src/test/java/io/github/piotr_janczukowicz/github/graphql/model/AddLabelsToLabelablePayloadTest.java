package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddLabelsToLabelablePayloadTest {

    @Test
    void constructor_shouldFail_whenLabelableIdIsNull() {
        final AddLabelsToLabelablePayloadBuilder builder = AddLabelsToLabelablePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("labelableId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddLabelsToLabelablePayload input =
                AddLabelsToLabelablePayloadBuilder.builder().labelableId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("labelableId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddLabelsToLabelablePayload input = AddLabelsToLabelablePayloadBuilder.builder()
                .clientMutationId("x")
                .labelIds(List.of("x"))
                .labelableId("x")
                .labels(List.of(LabelUpdateInputBuilder.builder().labelId("x").build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("labelIds", List.of("x")),
                        entry("labelableId", "x"),
                        entry("labels", List.of(Map.ofEntries(entry("labelId", "x")))));
    }
}
