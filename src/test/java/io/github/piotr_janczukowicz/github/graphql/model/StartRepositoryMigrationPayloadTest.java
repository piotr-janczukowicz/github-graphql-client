package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class StartRepositoryMigrationPayloadTest {

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final StartRepositoryMigrationPayloadBuilder builder = StartRepositoryMigrationPayloadBuilder.builder()
                .repositoryName("x")
                .sourceId("x")
                .sourceRepositoryUrl("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryNameIsNull() {
        final StartRepositoryMigrationPayloadBuilder builder = StartRepositoryMigrationPayloadBuilder.builder()
                .ownerId("x")
                .sourceId("x")
                .sourceRepositoryUrl("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryName must not be null");
    }

    @Test
    void constructor_shouldFail_whenSourceIdIsNull() {
        final StartRepositoryMigrationPayloadBuilder builder = StartRepositoryMigrationPayloadBuilder.builder()
                .ownerId("x")
                .repositoryName("x")
                .sourceRepositoryUrl("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sourceId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSourceRepositoryUrlIsNull() {
        final StartRepositoryMigrationPayloadBuilder builder = StartRepositoryMigrationPayloadBuilder.builder()
                .ownerId("x")
                .repositoryName("x")
                .sourceId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sourceRepositoryUrl must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final StartRepositoryMigrationPayload input = StartRepositoryMigrationPayloadBuilder.builder()
                .ownerId("x")
                .repositoryName("x")
                .sourceId("x")
                .sourceRepositoryUrl("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("ownerId", "x"),
                        entry("repositoryName", "x"),
                        entry("sourceId", "x"),
                        entry("sourceRepositoryUrl", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final StartRepositoryMigrationPayload input = StartRepositoryMigrationPayloadBuilder.builder()
                .accessToken("x")
                .clientMutationId("x")
                .continueOnError(true)
                .gitArchiveUrl("x")
                .githubPat("x")
                .lockSource(true)
                .metadataArchiveUrl("x")
                .ownerId("x")
                .repositoryName("x")
                .skipReleases(true)
                .sourceId("x")
                .sourceRepositoryUrl("x")
                .targetRepoVisibility("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("accessToken", "x"),
                        entry("clientMutationId", "x"),
                        entry("continueOnError", true),
                        entry("gitArchiveUrl", "x"),
                        entry("githubPat", "x"),
                        entry("lockSource", true),
                        entry("metadataArchiveUrl", "x"),
                        entry("ownerId", "x"),
                        entry("repositoryName", "x"),
                        entry("skipReleases", true),
                        entry("sourceId", "x"),
                        entry("sourceRepositoryUrl", "x"),
                        entry("targetRepoVisibility", "x"));
    }
}
