package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DequeuePullRequestPayload}. */
public interface DequeuePullRequestPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R mergeQueueEntry(Function<MergeQueueEntrySelector, R> selection);
}
