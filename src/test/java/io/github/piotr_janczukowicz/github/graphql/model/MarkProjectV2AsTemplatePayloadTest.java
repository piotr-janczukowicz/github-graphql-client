package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class MarkProjectV2AsTemplatePayloadTest {

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final MarkProjectV2AsTemplatePayloadBuilder builder = MarkProjectV2AsTemplatePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final MarkProjectV2AsTemplatePayload input =
                MarkProjectV2AsTemplatePayloadBuilder.builder().projectId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final MarkProjectV2AsTemplatePayload input = MarkProjectV2AsTemplatePayloadBuilder.builder()
                .clientMutationId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("clientMutationId", "x"), entry("projectId", "x"));
    }
}
