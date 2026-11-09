package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DraftPullRequestReviewThreadTest {

    @Test
    void constructor_shouldFail_whenBodyIsNull() {
        final DraftPullRequestReviewThreadBuilder builder = DraftPullRequestReviewThreadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("body must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DraftPullRequestReviewThread input =
                DraftPullRequestReviewThreadBuilder.builder().body("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("body", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DraftPullRequestReviewThread input = DraftPullRequestReviewThreadBuilder.builder()
                .body("x")
                .line(1)
                .path("x")
                .side(DiffSide.LEFT)
                .startLine(1)
                .startSide(DiffSide.LEFT)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("line", 1),
                        entry("path", "x"),
                        entry("side", "LEFT"),
                        entry("startLine", 1),
                        entry("startSide", "LEFT"));
    }
}
