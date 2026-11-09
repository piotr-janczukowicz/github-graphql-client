package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateRepositoryPayloadTest {

    @Test
    void constructor_shouldFail_whenRepositoryIdIsNull() {
        final UpdateRepositoryPayloadBuilder builder = UpdateRepositoryPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("repositoryId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateRepositoryPayload input =
                UpdateRepositoryPayloadBuilder.builder().repositoryId("x").build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("repositoryId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateRepositoryPayload input = UpdateRepositoryPayloadBuilder.builder()
                .clientMutationId("x")
                .description("x")
                .hasDiscussionsEnabled(true)
                .hasIssuesEnabled(true)
                .hasProjectsEnabled(true)
                .hasPullRequestsEnabled(true)
                .hasSponsorshipsEnabled(true)
                .hasWikiEnabled(true)
                .homepageUrl("x")
                .issueCreationPolicy(IssueCreationPolicy.ALL)
                .name("x")
                .pullRequestCreationPolicy(PullRequestCreationPolicy.ALL)
                .repositoryId("x")
                .template(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("description", "x"),
                        entry("hasDiscussionsEnabled", true),
                        entry("hasIssuesEnabled", true),
                        entry("hasProjectsEnabled", true),
                        entry("hasPullRequestsEnabled", true),
                        entry("hasSponsorshipsEnabled", true),
                        entry("hasWikiEnabled", true),
                        entry("homepageUrl", "x"),
                        entry("issueCreationPolicy", "ALL"),
                        entry("name", "x"),
                        entry("pullRequestCreationPolicy", "ALL"),
                        entry("repositoryId", "x"),
                        entry("template", true));
    }
}
