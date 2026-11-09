package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UserContentEdit}; used by the generated selection code only. */
final class UserContentEditSelectorImpl implements UserContentEditSelector {

    private final Cursor cursor;

    UserContentEditSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Instant deletedAt() {
        return cursor.get("deletedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R deletedBy(final Function<ActorSelector, R> selection) {
        return cursor.object("deletedBy", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable String diff() {
        return cursor.get("diff", ScalarType.STRING);
    }

    @Override
    public Instant editedAt() {
        return cursor.getRequired("editedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R editor(final Function<ActorSelector, R> selection) {
        return cursor.object("editor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
