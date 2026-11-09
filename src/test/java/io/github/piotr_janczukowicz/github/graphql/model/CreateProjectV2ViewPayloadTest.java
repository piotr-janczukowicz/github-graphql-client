package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateProjectV2ViewPayloadTest {

    @Test
    void constructor_shouldFail_whenLayoutIsNull() {
        final CreateProjectV2ViewPayloadBuilder builder =
                CreateProjectV2ViewPayloadBuilder.builder().name("x").projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("layout must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateProjectV2ViewPayloadBuilder builder = CreateProjectV2ViewPayloadBuilder.builder()
                .layout(ProjectV2ViewLayout.BOARD_LAYOUT)
                .projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final CreateProjectV2ViewPayloadBuilder builder = CreateProjectV2ViewPayloadBuilder.builder()
                .layout(ProjectV2ViewLayout.BOARD_LAYOUT)
                .name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateProjectV2ViewPayload input = CreateProjectV2ViewPayloadBuilder.builder()
                .layout(ProjectV2ViewLayout.BOARD_LAYOUT)
                .name("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("layout", "BOARD_LAYOUT"), entry("name", "x"), entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateProjectV2ViewPayload input = CreateProjectV2ViewPayloadBuilder.builder()
                .clientMutationId("x")
                .configuration(ProjectV2ViewConfigurationInputBuilder.builder().build())
                .layout(ProjectV2ViewLayout.BOARD_LAYOUT)
                .name("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("configuration", Map.ofEntries()),
                        entry("layout", "BOARD_LAYOUT"),
                        entry("name", "x"),
                        entry("projectId", "x"));
    }
}
