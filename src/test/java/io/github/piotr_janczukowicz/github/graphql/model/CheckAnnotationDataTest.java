package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckAnnotationDataTest {

    @Test
    void constructor_shouldFail_whenAnnotationLevelIsNull() {
        final CheckAnnotationDataBuilder builder = CheckAnnotationDataBuilder.builder()
                .location(CheckAnnotationRangeBuilder.builder()
                        .endLine(1)
                        .startLine(1)
                        .build())
                .message("x")
                .path("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("annotationLevel must not be null");
    }

    @Test
    void constructor_shouldFail_whenLocationIsNull() {
        final CheckAnnotationDataBuilder builder = CheckAnnotationDataBuilder.builder()
                .annotationLevel(CheckAnnotationLevel.FAILURE)
                .message("x")
                .path("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("location must not be null");
    }

    @Test
    void constructor_shouldFail_whenMessageIsNull() {
        final CheckAnnotationDataBuilder builder = CheckAnnotationDataBuilder.builder()
                .annotationLevel(CheckAnnotationLevel.FAILURE)
                .location(CheckAnnotationRangeBuilder.builder()
                        .endLine(1)
                        .startLine(1)
                        .build())
                .path("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("message must not be null");
    }

    @Test
    void constructor_shouldFail_whenPathIsNull() {
        final CheckAnnotationDataBuilder builder = CheckAnnotationDataBuilder.builder()
                .annotationLevel(CheckAnnotationLevel.FAILURE)
                .location(CheckAnnotationRangeBuilder.builder()
                        .endLine(1)
                        .startLine(1)
                        .build())
                .message("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("path must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CheckAnnotationData input = CheckAnnotationDataBuilder.builder()
                .annotationLevel(CheckAnnotationLevel.FAILURE)
                .location(CheckAnnotationRangeBuilder.builder()
                        .endLine(1)
                        .startLine(1)
                        .build())
                .message("x")
                .path("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("annotationLevel", "FAILURE"),
                        entry("location", Map.ofEntries(entry("endLine", 1), entry("startLine", 1))),
                        entry("message", "x"),
                        entry("path", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CheckAnnotationData input = CheckAnnotationDataBuilder.builder()
                .annotationLevel(CheckAnnotationLevel.FAILURE)
                .location(CheckAnnotationRangeBuilder.builder()
                        .endLine(1)
                        .startLine(1)
                        .build())
                .message("x")
                .path("x")
                .rawDetails("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("annotationLevel", "FAILURE"),
                        entry("location", Map.ofEntries(entry("endLine", 1), entry("startLine", 1))),
                        entry("message", "x"),
                        entry("path", "x"),
                        entry("rawDetails", "x"),
                        entry("title", "x"));
    }
}
