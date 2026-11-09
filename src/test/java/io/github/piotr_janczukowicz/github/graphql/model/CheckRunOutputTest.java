package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckRunOutputTest {

    @Test
    void constructor_shouldFail_whenSummaryIsNull() {
        final CheckRunOutputBuilder builder = CheckRunOutputBuilder.builder().title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("summary must not be null");
    }

    @Test
    void constructor_shouldFail_whenTitleIsNull() {
        final CheckRunOutputBuilder builder = CheckRunOutputBuilder.builder().summary("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("title must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CheckRunOutput input =
                CheckRunOutputBuilder.builder().summary("x").title("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("summary", "x"), entry("title", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CheckRunOutput input = CheckRunOutputBuilder.builder()
                .annotations(List.of(CheckAnnotationDataBuilder.builder()
                        .annotationLevel(CheckAnnotationLevel.FAILURE)
                        .location(CheckAnnotationRangeBuilder.builder()
                                .endLine(1)
                                .startLine(1)
                                .build())
                        .message("x")
                        .path("x")
                        .build()))
                .images(List.of(CheckRunOutputImageBuilder.builder()
                        .alt("x")
                        .imageUrl("x")
                        .build()))
                .summary("x")
                .text("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry(
                                "annotations",
                                List.of(Map.ofEntries(
                                        entry("annotationLevel", "FAILURE"),
                                        entry("location", Map.ofEntries(entry("endLine", 1), entry("startLine", 1))),
                                        entry("message", "x"),
                                        entry("path", "x")))),
                        entry("images", List.of(Map.ofEntries(entry("alt", "x"), entry("imageUrl", "x")))),
                        entry("summary", "x"),
                        entry("text", "x"),
                        entry("title", "x"));
    }
}
