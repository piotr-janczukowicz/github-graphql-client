package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateProjectV2IssueFieldPayloadTest {

    @Test
    void constructor_shouldFail_whenIssueFieldIdIsNull() {
        final CreateProjectV2IssueFieldPayloadBuilder builder =
                CreateProjectV2IssueFieldPayloadBuilder.builder().projectId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueFieldId must not be null");
    }

    @Test
    void constructor_shouldFail_whenProjectIdIsNull() {
        final CreateProjectV2IssueFieldPayloadBuilder builder =
                CreateProjectV2IssueFieldPayloadBuilder.builder().issueFieldId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("projectId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateProjectV2IssueFieldPayload input = CreateProjectV2IssueFieldPayloadBuilder.builder()
                .issueFieldId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("issueFieldId", "x"), entry("projectId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateProjectV2IssueFieldPayload input = CreateProjectV2IssueFieldPayloadBuilder.builder()
                .clientMutationId("x")
                .issueFieldId("x")
                .projectId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("issueFieldId", "x"), entry("projectId", "x"));
    }
}
