package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateIssueIssueTypePayload}. */
public interface UpdateIssueIssueTypePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R issue(Function<IssueSelector, R> selection);
}
