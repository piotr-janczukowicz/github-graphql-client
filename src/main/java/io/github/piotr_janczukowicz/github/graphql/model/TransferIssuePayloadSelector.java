package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code TransferIssuePayload}. */
public interface TransferIssuePayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R issue(Function<IssueSelector, R> selection);
}
