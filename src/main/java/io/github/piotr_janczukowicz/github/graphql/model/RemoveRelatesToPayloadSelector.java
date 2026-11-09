package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RemoveRelatesToPayload}. */
public interface RemoveRelatesToPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R issue(Function<IssueSelector, R> selection);

    <R> @Nullable R relatedIssue(Function<IssueSelector, R> selection);
}
