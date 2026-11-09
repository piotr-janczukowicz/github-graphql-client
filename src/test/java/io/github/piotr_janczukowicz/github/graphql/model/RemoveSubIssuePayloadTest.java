package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RemoveSubIssuePayloadTest {

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final RemoveSubIssuePayloadBuilder builder =
                RemoveSubIssuePayloadBuilder.builder().subIssueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void constructor_shouldFail_whenSubIssueIdIsNull() {
        final RemoveSubIssuePayloadBuilder builder =
                RemoveSubIssuePayloadBuilder.builder().issueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("subIssueId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RemoveSubIssuePayload input = RemoveSubIssuePayloadBuilder.builder()
                .issueId("x")
                .subIssueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("issueId", "x"), entry("subIssueId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RemoveSubIssuePayload input = RemoveSubIssuePayloadBuilder.builder()
                .clientMutationId("x")
                .issueId("x")
                .subIssueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("clientMutationId", "x"), entry("issueId", "x"), entry("subIssueId", "x"));
    }
}
