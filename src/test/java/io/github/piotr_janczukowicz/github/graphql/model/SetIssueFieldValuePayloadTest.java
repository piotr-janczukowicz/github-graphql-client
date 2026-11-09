package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class SetIssueFieldValuePayloadTest {

    @Test
    void constructor_shouldFail_whenIssueFieldsIsNull() {
        final SetIssueFieldValuePayloadBuilder builder =
                SetIssueFieldValuePayloadBuilder.builder().issueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueFields must not be null");
    }

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final SetIssueFieldValuePayloadBuilder builder = SetIssueFieldValuePayloadBuilder.builder()
                .issueFields(List.of(IssueFieldCreateOrUpdateInputBuilder.builder()
                        .fieldId("x")
                        .build()));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final SetIssueFieldValuePayload input = SetIssueFieldValuePayloadBuilder.builder()
                .issueFields(List.of(IssueFieldCreateOrUpdateInputBuilder.builder()
                        .fieldId("x")
                        .build()))
                .issueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("issueFields", List.of(Map.ofEntries(entry("fieldId", "x")))), entry("issueId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final SetIssueFieldValuePayload input = SetIssueFieldValuePayloadBuilder.builder()
                .clientMutationId("x")
                .issueFields(List.of(IssueFieldCreateOrUpdateInputBuilder.builder()
                        .fieldId("x")
                        .build()))
                .issueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("issueFields", List.of(Map.ofEntries(entry("fieldId", "x")))),
                        entry("issueId", "x"));
    }
}
