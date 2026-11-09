package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code MergeBranchPayload}. */
public interface MergeBranchPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R mergeCommit(Function<CommitSelector, R> selection);
}
