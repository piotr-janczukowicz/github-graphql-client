package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateProjectV2CollaboratorsPayloadTest {

    @Test
    void constructor_shouldFail_whenCollaboratorsIsNull() {
        final UpdateProjectV2CollaboratorsPayloadBuilder builder =
                UpdateProjectV2CollaboratorsPayloadBuilder.builder().projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("collaborators must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final UpdateProjectV2CollaboratorsPayloadBuilder builder = UpdateProjectV2CollaboratorsPayloadBuilder.builder()
                .collaborators(List.of(ProjectV2CollaboratorBuilder.builder()
                        .role(ProjectV2Roles.ADMIN)
                        .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateProjectV2CollaboratorsPayload input = UpdateProjectV2CollaboratorsPayloadBuilder.builder()
                .collaborators(List.of(ProjectV2CollaboratorBuilder.builder()
                        .role(ProjectV2Roles.ADMIN)
                        .build()))
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("collaborators", List.of(Map.ofEntries(entry("role", "ADMIN")))),
                        entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateProjectV2CollaboratorsPayload input = UpdateProjectV2CollaboratorsPayloadBuilder.builder()
                .clientMutationId("x")
                .collaborators(List.of(ProjectV2CollaboratorBuilder.builder()
                        .role(ProjectV2Roles.ADMIN)
                        .build()))
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("collaborators", List.of(Map.ofEntries(entry("role", "ADMIN")))),
                        entry("projectId", "x"));
    }
}
