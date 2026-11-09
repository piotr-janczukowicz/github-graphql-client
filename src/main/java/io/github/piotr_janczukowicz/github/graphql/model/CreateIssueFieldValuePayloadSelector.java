package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateIssueFieldValuePayload}. */
public interface CreateIssueFieldValuePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R issue(Function<IssueSelector, R> selection);

    <R> @Nullable R issueFieldValue(Function<IssueFieldValueSelector, R> selection);
}
