package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UserEdgeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UserEdge}; used by the generated selection code only. */
final class UserEdgeSelectorImpl implements UserEdgeSelector {

    private final Cursor cursor;

    UserEdgeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String cursor() {
        return cursor.getRequired("cursor", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R node(final Function<UserSelector, R> selection) {
        return cursor.object("node", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
