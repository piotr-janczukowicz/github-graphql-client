package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateEnvironmentPayloadTest {

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CreateEnvironmentPayloadBuilder builder =
                CreateEnvironmentPayloadBuilder.builder().repositoryId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final CreateEnvironmentPayloadBuilder builder =
                CreateEnvironmentPayloadBuilder.builder().name("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateEnvironmentPayload input = CreateEnvironmentPayloadBuilder.builder()
                .name("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("name", "x"), entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateEnvironmentPayload input = CreateEnvironmentPayloadBuilder.builder()
                .clientMutationId("x")
                .name("x")
                .repositoryId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("name", "x"), entry("repositoryId", "x"));
    }
}
