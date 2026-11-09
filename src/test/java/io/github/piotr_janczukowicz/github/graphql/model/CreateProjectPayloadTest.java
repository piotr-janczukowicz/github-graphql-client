package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateProjectPayloadTest {

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateProjectPayloadBuilder builder =
                CreateProjectPayloadBuilder.builder().ownerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final CreateProjectPayloadBuilder builder =
                CreateProjectPayloadBuilder.builder().name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateProjectPayload input =
                CreateProjectPayloadBuilder.builder().name("x").ownerId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("name", "x"), entry("ownerId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateProjectPayload input = CreateProjectPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .name("x")
                .ownerId("x")
                .repositoryIds(List.of("x"))
                .template(ProjectTemplate.AUTOMATED_KANBAN_V2)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("name", "x"),
                        entry("ownerId", "x"),
                        entry("repositoryIds", List.of("x")),
                        entry("template", "AUTOMATED_KANBAN_V2"));
    }
}
