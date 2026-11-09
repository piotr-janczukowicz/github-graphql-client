package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddProjectV2DraftIssuePayloadTest {

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final AddProjectV2DraftIssuePayloadBuilder builder =
                AddProjectV2DraftIssuePayloadBuilder.builder().title("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void constructor_shouldFail_whenTitleIsNull() {
        final AddProjectV2DraftIssuePayloadBuilder builder =
                AddProjectV2DraftIssuePayloadBuilder.builder().projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("title must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddProjectV2DraftIssuePayload input = AddProjectV2DraftIssuePayloadBuilder.builder()
                .projectId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("projectId", "x"), entry("title", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddProjectV2DraftIssuePayload input = AddProjectV2DraftIssuePayloadBuilder.builder()
                .assigneeIds(List.of("x"))
                .body("x")
                .clientMutationId("x")
                .projectId("x")
                .title("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("assigneeIds", List.of("x")),
                        entry("body", "x"),
                        entry("clientMutationId", "x"),
                        entry("projectId", "x"),
                        entry("title", "x"));
    }
}
