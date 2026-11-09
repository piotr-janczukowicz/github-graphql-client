package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutomaticBaseChangeFailedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code AutomaticBaseChangeFailedEvent}; used by the generated selection code only.
 */
final class AutomaticBaseChangeFailedEventSelectorImpl implements AutomaticBaseChangeFailedEventSelector {

    private final Cursor cursor;

    AutomaticBaseChangeFailedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String newBase() {
        return cursor.getRequired("newBase", ScalarType.STRING);
    }

    @Override
    public String oldBase() {
        return cursor.getRequired("oldBase", ScalarType.STRING);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }
}
