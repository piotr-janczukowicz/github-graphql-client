package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DeclineTopicSuggestionPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TopicSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeclineTopicSuggestionPayload}; used by the generated selection code only. */
final class DeclineTopicSuggestionPayloadSelectorImpl implements DeclineTopicSuggestionPayloadSelector {

    private final Cursor cursor;

    DeclineTopicSuggestionPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    /** @deprecated Suggested topics are no longer supported Removal on 2024-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> @Nullable R topic(final Function<TopicSelector, R> selection) {
        return cursor.object("topic", child -> selection.apply(new TopicSelectorImpl(child)));
    }
}
