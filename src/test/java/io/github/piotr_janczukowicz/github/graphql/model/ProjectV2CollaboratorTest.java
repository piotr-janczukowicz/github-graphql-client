package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ProjectV2CollaboratorTest {

    @Test
    void constructor_shouldFail_whenRoleIsNull() {
        final ProjectV2CollaboratorBuilder builder = ProjectV2CollaboratorBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("role must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ProjectV2Collaborator input = ProjectV2CollaboratorBuilder.builder()
                .role(ProjectV2Roles.ADMIN)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("role", "ADMIN"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ProjectV2Collaborator input = ProjectV2CollaboratorBuilder.builder()
                .role(ProjectV2Roles.ADMIN)
                .teamId("x")
                .userId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("role", "ADMIN"), entry("teamId", "x"), entry("userId", "x"));
    }
}
