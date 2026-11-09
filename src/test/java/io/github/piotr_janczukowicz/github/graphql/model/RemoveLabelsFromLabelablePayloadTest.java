package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RemoveLabelsFromLabelablePayloadTest {

    @Test
    void constructor_shouldFail_whenLabelIdsIsNull() {
        final RemoveLabelsFromLabelablePayloadBuilder builder =
                RemoveLabelsFromLabelablePayloadBuilder.builder().labelableId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("labelIds must not be null");
    }

    @Test
    void constructor_shouldFail_whenLabelableIdIsNull() {
        final RemoveLabelsFromLabelablePayloadBuilder builder =
                RemoveLabelsFromLabelablePayloadBuilder.builder().labelIds(List.of("x"));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("labelableId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RemoveLabelsFromLabelablePayload input = RemoveLabelsFromLabelablePayloadBuilder.builder()
                .labelIds(List.of("x"))
                .labelableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("labelIds", List.of("x")), entry("labelableId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RemoveLabelsFromLabelablePayload input = RemoveLabelsFromLabelablePayloadBuilder.builder()
                .clientMutationId("x")
                .labelIds(List.of("x"))
                .labelableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("labelIds", List.of("x")), entry("labelableId", "x"));
    }
}
