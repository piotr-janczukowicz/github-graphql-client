package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DraftPullRequestReviewCommentTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final DraftPullRequestReviewCommentBuilder builder =
                DraftPullRequestReviewCommentBuilder.builder().path("x").position(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void constructor_shouldFail_whenPathIsNull() {
        final DraftPullRequestReviewCommentBuilder builder =
                DraftPullRequestReviewCommentBuilder.builder().body("x").position(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("path must not be null");
    }

    @Test
    void constructor_shouldFail_whenPositionIsNull() {
        final DraftPullRequestReviewCommentBuilder builder =
                DraftPullRequestReviewCommentBuilder.builder().body("x").path("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("position must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DraftPullRequestReviewComment input = DraftPullRequestReviewCommentBuilder.builder()
                .body("x")
                .path("x")
                .position(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"), entry("path", "x"), entry("position", 1));
    }
}
