package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UnpinIssuePayload}. */
public interface UnpinIssuePayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String id();

    <R> @Nullable R issue(Function<IssueSelector, R> selection);
}
