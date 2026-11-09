package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddBlockedByPayloadTest {

    @Test
    void constructor_shouldFail_whenBlockingIssueIdIsNull() {
        final AddBlockedByPayloadBuilder builder =
                AddBlockedByPayloadBuilder.builder().issueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("blockingIssueId must not be null");
    }

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final AddBlockedByPayloadBuilder builder =
                AddBlockedByPayloadBuilder.builder().blockingIssueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddBlockedByPayload input = AddBlockedByPayloadBuilder.builder()
                .blockingIssueId("x")
                .issueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("blockingIssueId", "x"), entry("issueId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddBlockedByPayload input = AddBlockedByPayloadBuilder.builder()
                .blockingIssueId("x")
                .clientMutationId("x")
                .issueId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(entry("blockingIssueId", "x"), entry("clientMutationId", "x"), entry("issueId", "x"));
    }
}
