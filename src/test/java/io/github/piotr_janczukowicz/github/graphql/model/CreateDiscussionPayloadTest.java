package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateDiscussionPayloadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final CreateDiscussionPayloadBuilder builder = CreateDiscussionPayloadBuilder.builder()
                .categoryId("x")
                .repositoryId("x")
                .title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void constructor_shouldFail_whenCategoryIdIsNull() {
        final CreateDiscussionPayloadBuilder builder = CreateDiscussionPayloadBuilder.builder()
                .body("x")
                .repositoryId("x")
                .title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("categoryId must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final CreateDiscussionPayloadBuilder builder = CreateDiscussionPayloadBuilder.builder()
                .body("x")
                .categoryId("x")
                .title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTitleIsNull() {
        final CreateDiscussionPayloadBuilder builder = CreateDiscussionPayloadBuilder.builder()
                .body("x")
                .categoryId("x")
                .repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("title must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateDiscussionPayload input = CreateDiscussionPayloadBuilder.builder()
                .body("x")
                .categoryId("x")
                .repositoryId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"), entry("categoryId", "x"), entry("repositoryId", "x"), entry("title", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateDiscussionPayload input = CreateDiscussionPayloadBuilder.builder()
                .body("x")
                .categoryId("x")
                .clientMutationId("x")
                .repositoryId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("categoryId", "x"),
                        entry("clientMutationId", "x"),
                        entry("repositoryId", "x"),
                        entry("title", "x"));
    }
}
