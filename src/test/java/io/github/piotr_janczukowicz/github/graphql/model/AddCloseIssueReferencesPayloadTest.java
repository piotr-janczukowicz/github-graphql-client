package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class AddCloseIssueReferencesPayloadTest {

    @Test
    void constructor_shouldFail_whenIssueIdIsNull() {
        final AddCloseIssueReferencesPayloadBuilder builder =
                AddCloseIssueReferencesPayloadBuilder.builder().pullRequestIds(List.of("x"));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("issueId must not be null");
    }

    @Test
    void constructor_shouldFail_whenPullRequestIdsIsNull() {
        final AddCloseIssueReferencesPayloadBuilder builder =
                AddCloseIssueReferencesPayloadBuilder.builder().issueId("x");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestIds must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final AddCloseIssueReferencesPayload input = AddCloseIssueReferencesPayloadBuilder.builder()
                .issueId("x")
                .pullRequestIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("issueId", "x"), entry("pullRequestIds", List.of("x")));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final AddCloseIssueReferencesPayload input = AddCloseIssueReferencesPayloadBuilder.builder()
                .clientMutationId("x")
                .issueId("x")
                .pullRequestIds(List.of("x"))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"), entry("issueId", "x"), entry("pullRequestIds", List.of("x")));
    }
}
