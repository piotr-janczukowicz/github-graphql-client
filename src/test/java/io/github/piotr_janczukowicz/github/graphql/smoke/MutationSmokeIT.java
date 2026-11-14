package io.github.piotr_janczukowicz.github.graphql.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.graphql.GitHubGraphQL;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AddCommentPayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.AddReactionPayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.AddStarPayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CloseIssuePayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CreateIssuePayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DeleteIssuePayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemoveStarPayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.StarrableSelector;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("smoke")
class MutationSmokeIT {

    private static SmokeSupport smoke;

    record Created(String id, int number) {}

    record Fetched(String title, IssueState state, List<String> comments, List<ReactionContent> reactions) {}

    @BeforeAll
    static void connect() {
        smoke = SmokeSupport.connect();
    }

    @AfterAll
    static void disconnect() {
        if (smoke != null) {
            smoke.close();
        }
    }

    @Test
    void issue_shouldRoundTrip_whenCreatedCommentedReactedClosedAndDeleted() throws IOException {
        final GitHubGraphQL graphql = smoke.graphql();
        final String repositoryId = smoke.repositoryId();
        final String title = smoke.name("issue");
        final Created created = graphql.mutate(mutation -> mutation.createIssue(
                CreateIssuePayloadBuilder.builder()
                        .repositoryId(repositoryId)
                        .title(title)
                        .body("created by a graphql smoke test")
                        .build(),
                payload -> payload.issue(issue -> new Created(issue.id(), issue.number()))));
        try {
            graphql.mutate(mutation -> mutation.addComment(
                    AddCommentPayloadBuilder.builder()
                            .subjectId(created.id())
                            .body("smoke comment")
                            .build(),
                    payload -> payload.commentEdge(edge -> edge.node(IssueCommentSelector::id))));
            graphql.mutate(mutation -> mutation.addReaction(
                    AddReactionPayloadBuilder.builder()
                            .subjectId(created.id())
                            .content(ReactionContent.HEART)
                            .build(),
                    payload -> payload.subject(ReactableSelector::id)));
            graphql.mutate(mutation -> mutation.closeIssue(
                    CloseIssuePayloadBuilder.builder().issueId(created.id()).build(),
                    payload -> payload.issue(IssueSelector::id)));

            final Fetched fetched = graphql.query(query -> query.repository(
                    smoke.repo(),
                    smoke.owner(),
                    repository -> repository.issue(
                            created.number(),
                            issue -> new Fetched(
                                    issue.title(),
                                    issue.state(),
                                    issue.comments(Paging.first(10), IssueCommentSelector::body)
                                            .items(),
                                    issue.reactions(Paging.first(10), ReactionSelector::content)
                                            .items()))));

            assertSoftly(softly -> {
                softly.assertThat(fetched.title()).isEqualTo(title);
                softly.assertThat(fetched.state()).isEqualTo(IssueState.CLOSED);
                softly.assertThat(fetched.comments()).containsExactly("smoke comment");
                softly.assertThat(fetched.reactions()).containsExactly(ReactionContent.HEART);
            });
        } finally {
            graphql.mutate(mutation -> mutation.deleteIssue(
                    DeleteIssuePayloadBuilder.builder().issueId(created.id()).build(),
                    payload -> payload.repository(RepositorySelector::id)));
        }
    }

    @Test
    void star_shouldRoundTrip_whenTheSandboxIsStarredAndUnstarred() throws IOException {
        final GitHubGraphQL graphql = smoke.graphql();
        final String repositoryId = smoke.repositoryId();
        final boolean wasStarred = graphql.query(
                query -> query.repository(smoke.repo(), smoke.owner(), RepositorySelector::viewerHasStarred));
        try {
            final boolean starred = graphql.mutate(mutation -> mutation.addStar(
                    AddStarPayloadBuilder.builder().starrableId(repositoryId).build(),
                    payload -> payload.starrable(StarrableSelector::viewerHasStarred)));
            final boolean unstarred = graphql.mutate(mutation -> mutation.removeStar(
                    RemoveStarPayloadBuilder.builder().starrableId(repositoryId).build(),
                    payload -> payload.starrable(StarrableSelector::viewerHasStarred)));

            assertThat(starred).isTrue();
            assertThat(unstarred).isFalse();
        } finally {
            if (wasStarred) {
                graphql.mutate(mutation -> mutation.addStar(
                        AddStarPayloadBuilder.builder()
                                .starrableId(repositoryId)
                                .build(),
                        payload -> payload.starrable(StarrableSelector::id)));
            }
        }
    }
}
