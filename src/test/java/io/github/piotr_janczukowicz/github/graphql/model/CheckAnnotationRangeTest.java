package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CheckAnnotationRangeTest {

    @Test
    void constructor_shouldFail_whenEndLineIsNull() {
        final CheckAnnotationRangeBuilder builder =
                CheckAnnotationRangeBuilder.builder().startLine(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("endLine must not be null");
    }

    @Test
    void constructor_shouldFail_whenStartLineIsNull() {
        final CheckAnnotationRangeBuilder builder =
                CheckAnnotationRangeBuilder.builder().endLine(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("startLine must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CheckAnnotationRange input =
                CheckAnnotationRangeBuilder.builder().endLine(1).startLine(1).build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("endLine", 1), entry("startLine", 1));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CheckAnnotationRange input = CheckAnnotationRangeBuilder.builder()
                .endColumn(1)
                .endLine(1)
                .startColumn(1)
                .startLine(1)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("endColumn", 1), entry("endLine", 1), entry("startColumn", 1), entry("startLine", 1));
    }
}
