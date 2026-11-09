package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AcceptTopicSuggestionPayload}. */
public interface AcceptTopicSuggestionPayloadSelector {

    @Nullable String clientMutationId();

    /** @deprecated Suggested topics are no longer supported Removal on 2024-04-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> @Nullable R topic(Function<TopicSelector, R> selection);
}
