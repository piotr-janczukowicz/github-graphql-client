package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UnmarkIssueAsDuplicatePayload}. */
public interface UnmarkIssueAsDuplicatePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R duplicate(Function<IssueOrPullRequestSelector, R> selection);
}
