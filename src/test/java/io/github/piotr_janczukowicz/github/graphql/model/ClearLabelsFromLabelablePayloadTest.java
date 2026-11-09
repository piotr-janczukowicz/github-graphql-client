package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ClearLabelsFromLabelablePayloadTest {

    @Test
    void constructor_shouldFail_whenLabelableIdIsNull() {
        final ClearLabelsFromLabelablePayloadBuilder builder = ClearLabelsFromLabelablePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("labelableId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ClearLabelsFromLabelablePayload input = ClearLabelsFromLabelablePayloadBuilder.builder()
                .labelableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("labelableId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ClearLabelsFromLabelablePayload input = ClearLabelsFromLabelablePayloadBuilder.builder()
                .clientMutationId("x")
                .labelableId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("labelableId", "x"));
    }
}
