package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RefNameConditionTargetSelector;
import java.util.List;

/** Reads and records the fields of {@code RefNameConditionTarget}; used by the generated selection code only. */
final class RefNameConditionTargetSelectorImpl implements RefNameConditionTargetSelector {

    private final Cursor cursor;

    RefNameConditionTargetSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> exclude() {
        return cursor.scalarListRequired("exclude", ScalarType.STRING);
    }

    @Override
    public List<String> include() {
        return cursor.scalarListRequired("include", ScalarType.STRING);
    }
}
