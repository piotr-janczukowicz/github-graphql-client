package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectV2ItemFieldValuePayloadTest {

    @Test
    void constructor_shouldFail_whenFieldIdIsNull() {
        final UpdateProjectV2ItemFieldValuePayloadBuilder builder =
                UpdateProjectV2ItemFieldValuePayloadBuilder.builder()
                        .itemId("x")
                        .projectId("x")
                        .value(ProjectV2FieldValueBuilder.builder().build());

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("fieldId must not be null");
    }

    @Test
    void constructor_shouldFail_whenItemIdIsNull() {
        final UpdateProjectV2ItemFieldValuePayloadBuilder builder =
                UpdateProjectV2ItemFieldValuePayloadBuilder.builder()
                        .fieldId("x")
                        .projectId("x")
                        .value(ProjectV2FieldValueBuilder.builder().build());

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("itemId must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final UpdateProjectV2ItemFieldValuePayloadBuilder builder =
                UpdateProjectV2ItemFieldValuePayloadBuilder.builder()
                        .fieldId("x")
                        .itemId("x")
                        .value(ProjectV2FieldValueBuilder.builder().build());

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void constructor_shouldFail_whenValueIsNull() {
        final UpdateProjectV2ItemFieldValuePayloadBuilder builder =
                UpdateProjectV2ItemFieldValuePayloadBuilder.builder()
                        .fieldId("x")
                        .itemId("x")
                        .projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("value must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectV2ItemFieldValuePayload input = UpdateProjectV2ItemFieldValuePayloadBuilder.builder()
                .fieldId("x")
                .itemId("x")
                .projectId("x")
                .value(ProjectV2FieldValueBuilder.builder().build())
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("fieldId", "x"),
                        entry("itemId", "x"),
                        entry("projectId", "x"),
                        entry("value", Map.ofEntries()));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectV2ItemFieldValuePayload input = UpdateProjectV2ItemFieldValuePayloadBuilder.builder()
                .clientMutationId("x")
                .fieldId("x")
                .itemId("x")
                .projectId("x")
                .value(ProjectV2FieldValueBuilder.builder().build())
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("fieldId", "x"),
                        entry("itemId", "x"),
                        entry("projectId", "x"),
                        entry("value", Map.ofEntries()));
    }
}
