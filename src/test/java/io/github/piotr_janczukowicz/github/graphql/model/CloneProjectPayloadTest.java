package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CloneProjectPayloadTest {

    @Test
    void constructor_shouldFail_whenIncludeWorkflowsIsNull() {
        final CloneProjectPayloadBuilder builder =
                CloneProjectPayloadBuilder.builder().name("x").sourceId("x").targetOwnerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("includeWorkflows must not be null");
    }

    @Test
    void constructor_shouldFail_whenNameIsNull() {
        final CloneProjectPayloadBuilder builder = CloneProjectPayloadBuilder.builder()
                .includeWorkflows(true)
                .sourceId("x")
                .targetOwnerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("name must not be null");
    }

    @Test
    void constructor_shouldFail_whenSourceIdIsNull() {
        final CloneProjectPayloadBuilder builder = CloneProjectPayloadBuilder.builder()
                .includeWorkflows(true)
                .name("x")
                .targetOwnerId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("sourceId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTargetOwnerIdIsNull() {
        final CloneProjectPayloadBuilder builder = CloneProjectPayloadBuilder.builder()
                .includeWorkflows(true)
                .name("x")
                .sourceId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("targetOwnerId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CloneProjectPayload input = CloneProjectPayloadBuilder.builder()
                .includeWorkflows(true)
                .name("x")
                .sourceId("x")
                .targetOwnerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("includeWorkflows", true),
                        entry("name", "x"),
                        entry("sourceId", "x"),
                        entry("targetOwnerId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CloneProjectPayload input = CloneProjectPayloadBuilder.builder()
                .body("x")
                .clientMutationId("x")
                .includeWorkflows(true)
                .name("x")
                .publicValue(true)
                .sourceId("x")
                .targetOwnerId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("includeWorkflows", true),
                        entry("name", "x"),
                        entry("public", true),
                        entry("sourceId", "x"),
                        entry("targetOwnerId", "x"));
    }
}
