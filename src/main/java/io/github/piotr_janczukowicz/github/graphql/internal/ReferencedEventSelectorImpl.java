package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReferencedEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReferencedSubjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReferencedEvent}; used by the generated selection code only. */
final class ReferencedEventSelectorImpl implements ReferencedEventSelector {

    private final Cursor cursor;

    ReferencedEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R commit(final Function<CommitSelector, R> selection) {
        return cursor.object("commit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public <R> R commitRepository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("commitRepository", child -> selection.apply(new RepositorySelectorImpl(child)));
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
    public boolean isDirectReference() {
        return cursor.getRequired("isDirectReference", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R subject(final Function<ReferencedSubjectSelector, R> selection) {
        return cursor.objectRequired("subject", child -> selection.apply(new ReferencedSubjectSelectorImpl(child)));
    }
}
