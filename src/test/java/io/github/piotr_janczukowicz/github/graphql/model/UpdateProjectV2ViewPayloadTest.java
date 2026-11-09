package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectV2ViewPayloadTest {

    @Test
    void constructor_shouldFail_whenViewIdIsNull() {
        final UpdateProjectV2ViewPayloadBuilder builder = UpdateProjectV2ViewPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("viewId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectV2ViewPayload input =
                UpdateProjectV2ViewPayloadBuilder.builder().viewId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("viewId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectV2ViewPayload input = UpdateProjectV2ViewPayloadBuilder.builder()
                .clientMutationId("x")
                .configuration(ProjectV2ViewConfigurationInputBuilder.builder().build())
                .filter("x")
                .layout(ProjectV2ViewLayout.BOARD_LAYOUT)
                .name("x")
                .viewId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("configuration", Map.ofEntries()),
                        entry("filter", "x"),
                        entry("layout", "BOARD_LAYOUT"),
                        entry("name", "x"),
                        entry("viewId", "x"));
    }
}
