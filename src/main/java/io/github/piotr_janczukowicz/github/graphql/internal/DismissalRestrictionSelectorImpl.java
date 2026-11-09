package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DismissalRestrictionSelector;
import java.util.List;

/** Reads and records the fields of {@code DismissalRestriction}; used by the generated selection code only. */
final class DismissalRestrictionSelectorImpl implements DismissalRestrictionSelector {

    private final Cursor cursor;

    DismissalRestrictionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> allowedActors() {
        return cursor.scalarList("allowedActors", ScalarType.STRING);
    }

    @Override
    public boolean enabled() {
        return cursor.getRequired("enabled", ScalarType.BOOLEAN);
    }
}
