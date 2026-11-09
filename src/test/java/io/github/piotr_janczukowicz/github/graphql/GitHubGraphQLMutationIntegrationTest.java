package io.github.piotr_janczukowicz.github.graphql;

import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpStatus.OK;
import static io.github.piotr_janczukowicz.test.http.StubHttpServer.status;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.client.GitHubClient;
import io.github.piotr_janczukowicz.github.client.GitHubClients;
import io.github.piotr_janczukowicz.github.graphql.model.AddCommentPayload;
import io.github.piotr_janczukowicz.github.graphql.model.AddCommentPayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CustomPropertyValueInputBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SetRepositoryCustomPropertyValuesPayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SetRepositoryCustomPropertyValuesPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectV2ItemPositionPayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateProjectV2ItemPositionPayloadSelector;
import io.github.piotr_janczukowicz.http.client.HttpClientConfiguration;
import io.github.piotr_janczukowicz.http.client.authentication.AuthenticationProviders;
import io.github.piotr_janczukowicz.json.OptionalNull;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitHubGraphQLMutationIntegrationTest {

    private static final String PATH = "/graphql";

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    record Comment(String id, String body) {}

    private static GitHubClient client() {
        final HttpClientConfiguration configuration = HttpClientConfiguration.builder(URI.create(HTTP.baseUri() + "/"))
                .build();
        return GitHubClients.create(AuthenticationProviders.bearer("gh-token"), "test-agent/1.0", configuration);
    }

    private static StubHttpServer.StubResponse jsonOk(final String json) {
        return status(OK).header("Content-Type", "application/json").body(json.getBytes(StandardCharsets.UTF_8));
    }

    private static AddCommentPayload input() {
        return AddCommentPayloadBuilder.builder().body("x").subjectId("I_1").build();
    }

    @Test
    void mutate_shouldPostTheMutationAndReturnTheMappedResult_whenTheResponseHasData() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"addComment":{"commentEdge":{"node":{"id":"IC_9","body":"x"}}}}}
                """));
        final AddCommentPayload input = input();

        final Comment comment;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            comment = graphql.mutate(mutation -> mutation.addComment(
                    input,
                    payload -> payload.commentEdge(edge -> edge.node(node -> new Comment(node.id(), node.body())))));
        }

        assertSoftly(softly -> {
            softly.assertThat(comment).isEqualTo(new Comment("IC_9", "x"));
            HTTP.verifyBody(
                    POST,
                    PATH,
                    "{\"query\":\"mutation($input:AddCommentInput!){addComment(input:$input)"
                            + "{commentEdge{node{id body}}}}\","
                            + "\"variables\":{\"input\":{\"body\":\"x\",\"subjectId\":\"I_1\"}}}");
            HTTP.verifyRequested(POST, PATH, 1);
        });
    }

    @Test
    void mutate_shouldThrowWithTheErrorList_whenTheResponseHasErrors() {
        HTTP.stub(POST, PATH, jsonOk("""
                {"data":{"addComment":null},"errors":[{"message":"Could not resolve to a node","path":["addComment"]}]}
                """));
        final AddCommentPayload input = input();

        final Throwable thrown;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            thrown = catchThrowable(() -> graphql.mutate(mutation -> mutation.addComment(
                    input, payload -> payload.commentEdge(edge -> edge.node(IssueCommentSelector::id)))));
        }

        assertThat(thrown)
                .isInstanceOfSatisfying(
                        GitHubGraphQLException.class,
                        exception -> assertThat(exception.errors())
                                .containsExactly(
                                        new GraphQLError("Could not resolve to a node", List.of("addComment"))));
    }

    @Test
    void mutate_shouldReturnNull_whenThePayloadIsNull() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("{\"data\":{\"addComment\":null}}"));
        final AddCommentPayload input = input();

        final String result;
        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            result = graphql.mutate(mutation -> mutation.addComment(
                    input, payload -> payload.commentEdge(edge -> edge.node(IssueCommentSelector::id))));
        }

        assertThat(result).isNull();
    }

    @Test
    void mutate_shouldSendAnExplicitNull_whenTheFieldIsCleared() throws Exception {
        HTTP.stub(POST, PATH, jsonOk("{\"data\":{\"updateProjectV2ItemPosition\":{\"clientMutationId\":\"m\"}}}"));

        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            graphql.mutate(mutation -> mutation.updateProjectV2ItemPosition(
                    UpdateProjectV2ItemPositionPayloadBuilder.builder()
                            .projectId("P_1")
                            .itemId("I_1")
                            .afterId(OptionalNull.ofNull())
                            .build(),
                    UpdateProjectV2ItemPositionPayloadSelector::clientMutationId));
        }

        HTTP.verifyBody(
                POST,
                PATH,
                "{\"query\":\"mutation($input:UpdateProjectV2ItemPositionInput!){updateProjectV2ItemPosition(input:$input){clientMutationId}}\","
                        + "\"variables\":{\"input\":{\"afterId\":null,\"itemId\":\"I_1\",\"projectId\":\"P_1\"}}}");
    }

    @Test
    void mutate_shouldSendTextOptionsAndNull_whenPropertiesAreSet() throws Exception {
        HTTP.stub(
                POST, PATH, jsonOk("{\"data\":{\"setRepositoryCustomPropertyValues\":{\"clientMutationId\":\"m\"}}}"));
        final var payload = SetRepositoryCustomPropertyValuesPayloadBuilder.builder()
                .repositoryId("R_1")
                .properties(List.of(
                        CustomPropertyValueInputBuilder.builder()
                                .propertyName("team")
                                .value(OptionalNull.of(CustomPropertyValue.ofText("core")))
                                .build(),
                        CustomPropertyValueInputBuilder.builder()
                                .propertyName("tags")
                                .value(OptionalNull.of(CustomPropertyValue.ofOptions(List.of("a"))))
                                .build(),
                        CustomPropertyValueInputBuilder.builder()
                                .propertyName("old")
                                .value(OptionalNull.ofNull())
                                .build()))
                .build();

        try (final GitHubClient client = client()) {
            final GitHubGraphQL graphql = GitHubGraphQL.of(client);

            graphql.mutate(mutation -> mutation.setRepositoryCustomPropertyValues(
                    payload, SetRepositoryCustomPropertyValuesPayloadSelector::clientMutationId));
        }

        HTTP.verifyBody(
                POST,
                PATH,
                "{\"query\":\"mutation($input:SetRepositoryCustomPropertyValuesInput!){setRepositoryCustomPropertyValues(input:$input)"
                        + "{clientMutationId}}\",\"variables\":{\"input\":{\"properties\":["
                        + "{\"propertyName\":\"team\",\"value\":\"core\"},"
                        + "{\"propertyName\":\"tags\",\"value\":[\"a\"]},"
                        + "{\"propertyName\":\"old\",\"value\":null}],\"repositoryId\":\"R_1\"}}}");
    }
}
