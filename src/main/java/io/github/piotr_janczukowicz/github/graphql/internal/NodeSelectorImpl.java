package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.NodeSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Node}; used by the generated selection code only. */
final class NodeSelectorImpl implements NodeSelector {

    private final Cursor cursor;

    NodeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, NodeSelector.class, type, selection);
    }
}
