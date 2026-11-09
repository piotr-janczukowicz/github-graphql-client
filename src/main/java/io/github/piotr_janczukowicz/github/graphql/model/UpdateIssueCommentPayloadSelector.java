package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateIssueCommentPayload}. */
public interface UpdateIssueCommentPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R issueComment(Function<IssueCommentSelector, R> selection);
}
