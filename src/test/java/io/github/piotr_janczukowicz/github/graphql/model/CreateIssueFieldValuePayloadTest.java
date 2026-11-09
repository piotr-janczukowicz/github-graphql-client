package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class CreateIssueFieldValuePayloadTest {

    @Test
    void constructor_shouldFail_whenIssueFieldIsNull() {
        final CreateIssueFieldValuePayloadBuilder builder =
                CreateIssueFieldValuePayloadBuilder.builder().issueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueField must not be null");
    }

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final CreateIssueFieldValuePayloadBuilder builder = CreateIssueFieldValuePayloadBuilder.builder()
                .issueField(IssueFieldCreateOrUpdateInputBuilder.builder()
                        .fieldId("x")
                        .build());

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final CreateIssueFieldValuePayload input = CreateIssueFieldValuePayloadBuilder.builder()
                .issueField(IssueFieldCreateOrUpdateInputBuilder.builder()
                        .fieldId("x")
                        .build())
                .issueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("issueField", Map.ofEntries(entry("fieldId", "x"))), entry("issueId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final CreateIssueFieldValuePayload input = CreateIssueFieldValuePayloadBuilder.builder()
                .clientMutationId("x")
                .issueField(IssueFieldCreateOrUpdateInputBuilder.builder()
                        .fieldId("x")
                        .build())
                .issueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("issueField", Map.ofEntries(entry("fieldId", "x"))),
                        entry("issueId", "x"));
    }
}
