package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateLabelPayloadTest {

    @Test
    void constructor_shouldFail_whenColorIsNull() {
        final CreateLabelPayloadBuilder builder =
                CreateLabelPayloadBuilder.builder().name("x").repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("color must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateLabelPayloadBuilder builder =
                CreateLabelPayloadBuilder.builder().color("x").repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final CreateLabelPayloadBuilder builder =
                CreateLabelPayloadBuilder.builder().color("x").name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateLabelPayload input = CreateLabelPayloadBuilder.builder()
                .color("x")
                .name("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("color", "x"), entry("name", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateLabelPayload input = CreateLabelPayloadBuilder.builder()
                .clientMutationId("x")
                .color("x")
                .description("x")
                .name("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("color", "x"),
                        entry("description", "x"),
                        entry("name", "x"),
                        entry("repositoryId", "x"));
    }
}
