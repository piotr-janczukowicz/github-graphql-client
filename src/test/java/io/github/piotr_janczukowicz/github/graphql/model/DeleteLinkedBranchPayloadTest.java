package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteLinkedBranchPayloadTest {

    @Test
    void constructor_shouldFail_whenLinkedBranchIdIsNull() {
        final DeleteLinkedBranchPayloadBuilder builder = DeleteLinkedBranchPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("linkedBranchId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteLinkedBranchPayload input =
                DeleteLinkedBranchPayloadBuilder.builder().linkedBranchId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("linkedBranchId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteLinkedBranchPayload input = DeleteLinkedBranchPayloadBuilder.builder()
                .clientMutationId("x")
                .linkedBranchId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("linkedBranchId", "x"));
    }
}
