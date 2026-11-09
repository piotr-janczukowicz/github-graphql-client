package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CloneTemplateRepositoryPayloadTest {

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CloneTemplateRepositoryPayloadBuilder builder = CloneTemplateRepositoryPayloadBuilder.builder()
                .ownerId("x")
                .repositoryId("x")
                .visibility(RepositoryVisibility.INTERNAL);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final CloneTemplateRepositoryPayloadBuilder builder = CloneTemplateRepositoryPayloadBuilder.builder()
                .name("x")
                .repositoryId("x")
                .visibility(RepositoryVisibility.INTERNAL);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final CloneTemplateRepositoryPayloadBuilder builder = CloneTemplateRepositoryPayloadBuilder.builder()
                .name("x")
                .ownerId("x")
                .visibility(RepositoryVisibility.INTERNAL);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void constructor_shouldFail_whenVisibilityIsNull() {
        final CloneTemplateRepositoryPayloadBuilder builder = CloneTemplateRepositoryPayloadBuilder.builder()
                .name("x")
                .ownerId("x")
                .repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("visibility must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CloneTemplateRepositoryPayload input = CloneTemplateRepositoryPayloadBuilder.builder()
                .name("x")
                .ownerId("x")
                .repositoryId("x")
                .visibility(RepositoryVisibility.INTERNAL)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("name", "x"),
                        entry("ownerId", "x"),
                        entry("repositoryId", "x"),
                        entry("visibility", "INTERNAL"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CloneTemplateRepositoryPayload input = CloneTemplateRepositoryPayloadBuilder.builder()
                .clientMutationId("x")
                .description("x")
                .includeAllBranches(true)
                .name("x")
                .ownerId("x")
                .repositoryId("x")
                .visibility(RepositoryVisibility.INTERNAL)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("description", "x"),
                        entry("includeAllBranches", true),
                        entry("name", "x"),
                        entry("ownerId", "x"),
                        entry("repositoryId", "x"),
                        entry("visibility", "INTERNAL"));
    }
}
