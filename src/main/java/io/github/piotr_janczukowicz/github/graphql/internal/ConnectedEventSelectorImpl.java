package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ConnectedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReferencedSubjectSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ConnectedEvent}; used by the generated selection code only. */
final class ConnectedEventSelectorImpl implements ConnectedEventSelector {

    private final Cursor cursor;

    ConnectedEventSelectorImpl(final Cursor cursor) {
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
    public boolean isCrossRepository() {
        return cursor.getRequired("isCrossRepository", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R source(final Function<ReferencedSubjectSelector, R> selection) {
        return cursor.objectRequired("source", child -> selection.apply(new ReferencedSubjectSelectorImpl(child)));
    }

    @Override
    public <R> R subject(final Function<ReferencedSubjectSelector, R> selection) {
        return cursor.objectRequired("subject", child -> selection.apply(new ReferencedSubjectSelectorImpl(child)));
    }
}
