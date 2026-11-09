package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CrossReferencedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReferencedSubjectSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CrossReferencedEvent}; used by the generated selection code only. */
final class CrossReferencedEventSelectorImpl implements CrossReferencedEventSelector {

    private final Cursor cursor;

    CrossReferencedEventSelectorImpl(final Cursor cursor) {
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
    public Instant referencedAt() {
        return cursor.getRequired("referencedAt", ScalarType.INSTANT);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> R source(final Function<ReferencedSubjectSelector, R> selection) {
        return cursor.objectRequired("source", child -> selection.apply(new ReferencedSubjectSelectorImpl(child)));
    }

    @Override
    public <R> R target(final Function<ReferencedSubjectSelector, R> selection) {
        return cursor.objectRequired("target", child -> selection.apply(new ReferencedSubjectSelectorImpl(child)));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public boolean willCloseTarget() {
        return cursor.getRequired("willCloseTarget", ScalarType.BOOLEAN);
    }
}
