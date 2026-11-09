package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class FileChangesTest {

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final FileChanges input = FileChangesBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final FileChanges input = FileChangesBuilder.builder()
                .additions(List.of(
                        FileAdditionBuilder.builder().contents("x").path("x").build()))
                .deletions(List.of(FileDeletionBuilder.builder().path("x").build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("additions", List.of(Map.ofEntries(entry("contents", "x"), entry("path", "x")))),
                        entry("deletions", List.of(Map.ofEntries(entry("path", "x")))));
    }
}
