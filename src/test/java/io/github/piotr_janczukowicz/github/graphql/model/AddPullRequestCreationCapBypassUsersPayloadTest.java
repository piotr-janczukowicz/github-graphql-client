package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddPullRequestCreationCapBypassUsersPayloadTest {

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final AddPullRequestCreationCapBypassUsersPayloadBuilder builder =
                AddPullRequestCreationCapBypassUsersPayloadBuilder.builder().userIds(List.of("x"));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void constructor_shouldFail_whenUserIdsIsNull() {
        final AddPullRequestCreationCapBypassUsersPayloadBuilder builder =
                AddPullRequestCreationCapBypassUsersPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("userIds must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddPullRequestCreationCapBypassUsersPayload input =
                AddPullRequestCreationCapBypassUsersPayloadBuilder.builder()
                        .repositoryId("x")
                        .userIds(List.of("x"))
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryId", "x"), entry("userIds", List.of("x")));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddPullRequestCreationCapBypassUsersPayload input =
                AddPullRequestCreationCapBypassUsersPayloadBuilder.builder()
                        .clientMutationId("x")
                        .repositoryId("x")
                        .userIds(List.of("x"))
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("repositoryId", "x"), entry("userIds", List.of("x")));
    }
}
