package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SavedReplySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SavedReply}; used by the generated selection code only. */
final class SavedReplySelectorImpl implements SavedReplySelector {

    private final Cursor cursor;

    SavedReplySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public String bodyHTML() {
        return cursor.getRequired("bodyHTML", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R user(final Function<ActorSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new ActorSelectorImpl(child)));
    }
}
