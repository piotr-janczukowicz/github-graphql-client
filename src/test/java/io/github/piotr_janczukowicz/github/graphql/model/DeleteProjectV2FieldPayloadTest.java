package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteProjectV2FieldPayloadTest {

    @Test
    void constructor_shouldFail_whenFieldIdIsNull() {
        final DeleteProjectV2FieldPayloadBuilder builder = DeleteProjectV2FieldPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("fieldId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteProjectV2FieldPayload input =
                DeleteProjectV2FieldPayloadBuilder.builder().fieldId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("fieldId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteProjectV2FieldPayload input = DeleteProjectV2FieldPayloadBuilder.builder()
                .clientMutationId("x")
                .fieldId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("fieldId", "x"));
    }
}
