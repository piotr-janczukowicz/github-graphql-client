package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CopyProjectV2PayloadTest {

    @Test
    void constructor_shouldFail_whenOwnerIdIsNull() {
        final CopyProjectV2PayloadBuilder builder =
                CopyProjectV2PayloadBuilder.builder().projectId("x").title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("ownerId must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final CopyProjectV2PayloadBuilder builder =
                CopyProjectV2PayloadBuilder.builder().ownerId("x").title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTitleIsNull() {
        final CopyProjectV2PayloadBuilder builder =
                CopyProjectV2PayloadBuilder.builder().ownerId("x").projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("title must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CopyProjectV2Payload input = CopyProjectV2PayloadBuilder.builder()
                .ownerId("x")
                .projectId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("ownerId", "x"), entry("projectId", "x"), entry("title", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CopyProjectV2Payload input = CopyProjectV2PayloadBuilder.builder()
                .clientMutationId("x")
                .includeDraftIssues(true)
                .ownerId("x")
                .projectId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("includeDraftIssues", true),
                        entry("ownerId", "x"),
                        entry("projectId", "x"),
                        entry("title", "x"));
    }
}
