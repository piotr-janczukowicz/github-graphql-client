package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreatePullRequestPayloadTest {

    @Test
    void constructor_shouldFail_whenBaseRefNameIsNull() {
        final CreatePullRequestPayloadBuilder builder = CreatePullRequestPayloadBuilder.builder()
                .headRefName("x")
                .repositoryId("x")
                .title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("baseRefName must not be null");
    }

    @Test
    void constructor_shouldFail_whenHeadRefNameIsNull() {
        final CreatePullRequestPayloadBuilder builder = CreatePullRequestPayloadBuilder.builder()
                .baseRefName("x")
                .repositoryId("x")
                .title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("headRefName must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final CreatePullRequestPayloadBuilder builder = CreatePullRequestPayloadBuilder.builder()
                .baseRefName("x")
                .headRefName("x")
                .title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTitleIsNull() {
        final CreatePullRequestPayloadBuilder builder = CreatePullRequestPayloadBuilder.builder()
                .baseRefName("x")
                .headRefName("x")
                .repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("title must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreatePullRequestPayload input = CreatePullRequestPayloadBuilder.builder()
                .baseRefName("x")
                .headRefName("x")
                .repositoryId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("baseRefName", "x"),
                        entry("headRefName", "x"),
                        entry("repositoryId", "x"),
                        entry("title", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreatePullRequestPayload input = CreatePullRequestPayloadBuilder.builder()
                .baseRefName("x")
                .body("x")
                .clientMutationId("x")
                .draft(true)
                .headRefName("x")
                .headRepositoryId("x")
                .maintainerCanModify(true)
                .repositoryId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("baseRefName", "x"),
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("draft", true),
                        entry("headRefName", "x"),
                        entry("headRepositoryId", "x"),
                        entry("maintainerCanModify", true),
                        entry("repositoryId", "x"),
                        entry("title", "x"));
    }
}
