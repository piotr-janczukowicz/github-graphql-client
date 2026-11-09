package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RenamedTitleEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RenamedTitleSubjectSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RenamedTitleEvent}; used by the generated selection code only. */
final class RenamedTitleEventSelectorImpl implements RenamedTitleEventSelector {

    private final Cursor cursor;

    RenamedTitleEventSelectorImpl(final Cursor cursor) {
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
    public String currentTitle() {
        return cursor.getRequired("currentTitle", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String previousTitle() {
        return cursor.getRequired("previousTitle", ScalarType.STRING);
    }

    @Override
    public <R> R subject(final Function<RenamedTitleSubjectSelector, R> selection) {
        return cursor.objectRequired("subject", child -> selection.apply(new RenamedTitleSubjectSelectorImpl(child)));
    }
}
