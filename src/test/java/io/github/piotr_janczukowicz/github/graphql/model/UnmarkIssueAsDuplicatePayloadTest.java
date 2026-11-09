package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UnmarkIssueAsDuplicatePayloadTest {

    @Test
    void constructor_shouldFail_whenCanonicalIdIsNull() {
        final UnmarkIssueAsDuplicatePayloadBuilder builder =
                UnmarkIssueAsDuplicatePayloadBuilder.builder().duplicateId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("canonicalId must not be null");
    }

    @Test
    void constructor_shouldFail_whenDuplicateIdIsNull() {
        final UnmarkIssueAsDuplicatePayloadBuilder builder =
                UnmarkIssueAsDuplicatePayloadBuilder.builder().canonicalId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("duplicateId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UnmarkIssueAsDuplicatePayload input = UnmarkIssueAsDuplicatePayloadBuilder.builder()
                .canonicalId("x")
                .duplicateId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("canonicalId", "x"), entry("duplicateId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UnmarkIssueAsDuplicatePayload input = UnmarkIssueAsDuplicatePayloadBuilder.builder()
                .canonicalId("x")
                .clientMutationId("x")
                .duplicateId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("canonicalId", "x"), entry("clientMutationId", "x"), entry("duplicateId", "x"));
    }
}
