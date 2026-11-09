package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class ImportProjectPayloadTest {

    @Test
    void constructor_shouldFail_whenColumnImportsIsNull() {
        final ImportProjectPayloadBuilder builder =
                ImportProjectPayloadBuilder.builder().name("x").ownerName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("columnImports must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final ImportProjectPayloadBuilder builder = ImportProjectPayloadBuilder.builder()
                .columnImports(List.of(ProjectColumnImportBuilder.builder()
                        .columnName("x")
                        .position(1)
                        .build()))
                .ownerName("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenOwnerNameIsNull() {
        final ImportProjectPayloadBuilder builder = ImportProjectPayloadBuilder.builder()
                .columnImports(List.of(ProjectColumnImportBuilder.builder()
                        .columnName("x")
                        .position(1)
                        .build()))
                .name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerName must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final ImportProjectPayload input = ImportProjectPayloadBuilder.builder()
                .columnImports(List.of(ProjectColumnImportBuilder.builder()
                        .columnName("x")
                        .position(1)
                        .build()))
                .name("x")
                .ownerName("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("columnImports", List.of(Map.ofEntries(entry("columnName", "x"), entry("position", 1)))),
                        entry("name", "x"),
                        entry("ownerName", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final ImportProjectPayload input = ImportProjectPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .columnImports(List.of(ProjectColumnImportBuilder.builder()
                        .columnName("x")
                        .position(1)
                        .build()))
                .name("x")
                .ownerName("x")
                .publicValue(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("columnImports", List.of(Map.ofEntries(entry("columnName", "x"), entry("position", 1)))),
                        entry("name", "x"),
                        entry("ownerName", "x"),
                        entry("public", true));
    }
}
