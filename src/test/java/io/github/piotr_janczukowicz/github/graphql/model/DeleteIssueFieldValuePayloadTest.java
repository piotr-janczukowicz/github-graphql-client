package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class DeleteIssueFieldValuePayloadTest {

    @Test
    void constructor_shouldFail_whenFieldIdIsNull() {
        final DeleteIssueFieldValuePayloadBuilder builder =
                DeleteIssueFieldValuePayloadBuilder.builder().issueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("fieldId must not be null");
    }

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final DeleteIssueFieldValuePayloadBuilder builder =
                DeleteIssueFieldValuePayloadBuilder.builder().fieldId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final DeleteIssueFieldValuePayload input = DeleteIssueFieldValuePayloadBuilder.builder()
                .fieldId("x")
                .issueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("fieldId", "x"), entry("issueId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final DeleteIssueFieldValuePayload input = DeleteIssueFieldValuePayloadBuilder.builder()
                .clientMutationId("x")
                .fieldId("x")
                .issueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("fieldId", "x"), entry("issueId", "x"));
    }
}
