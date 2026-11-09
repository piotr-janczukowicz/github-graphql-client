package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateTeamsRepositoryPayloadTest {

    @Test
    void constructor_shouldFail_whenPermissionIsNull() {
        final UpdateTeamsRepositoryPayloadBuilder builder =
                UpdateTeamsRepositoryPayloadBuilder.builder().repositoryId("x").teamIds(List.of("x"));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("permission must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final UpdateTeamsRepositoryPayloadBuilder builder = UpdateTeamsRepositoryPayloadBuilder.builder()
                .permission(RepositoryPermission.ADMIN)
                .teamIds(List.of("x"));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTeamIdsIsNull() {
        final UpdateTeamsRepositoryPayloadBuilder builder = UpdateTeamsRepositoryPayloadBuilder.builder()
                .permission(RepositoryPermission.ADMIN)
                .repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("teamIds must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateTeamsRepositoryPayload input = UpdateTeamsRepositoryPayloadBuilder.builder()
                .permission(RepositoryPermission.ADMIN)
                .repositoryId("x")
                .teamIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("permission", "ADMIN"), entry("repositoryId", "x"), entry("teamIds", List.of("x")));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateTeamsRepositoryPayload input = UpdateTeamsRepositoryPayloadBuilder.builder()
                .clientMutationId("x")
                .permission(RepositoryPermission.ADMIN)
                .repositoryId("x")
                .teamIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("permission", "ADMIN"),
                        entry("repositoryId", "x"),
                        entry("teamIds", List.of("x")));
    }
}
