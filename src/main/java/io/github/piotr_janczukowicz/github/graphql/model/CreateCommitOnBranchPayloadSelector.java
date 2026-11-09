package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateCommitOnBranchPayload}. */
public interface CreateCommitOnBranchPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R commit(Function<CommitSelector, R> selection);

    <R> @Nullable R ref(Function<RefSelector, R> selection);
}
