package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SetIssueFieldValuePayload}. */
public interface SetIssueFieldValuePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R issue(Function<IssueSelector, R> selection);

    <R> List<R> issueFieldValues(Function<IssueFieldValueSelector, R> selection);
}
