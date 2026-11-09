package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ViewerHovercardContextSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code ViewerHovercardContext}; used by the generated selection code only. */
final class ViewerHovercardContextSelectorImpl implements ViewerHovercardContextSelector {

    private final Cursor cursor;

    ViewerHovercardContextSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String message() {
        return cursor.getRequired("message", ScalarType.STRING);
    }

    @Override
    public String octicon() {
        return cursor.getRequired("octicon", ScalarType.STRING);
    }

    @Override
    public <R> R viewer(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("viewer", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
