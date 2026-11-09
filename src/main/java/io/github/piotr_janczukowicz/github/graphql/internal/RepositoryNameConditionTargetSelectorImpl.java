package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryNameConditionTargetSelector;
import java.util.List;

/** Reads and records the fields of {@code RepositoryNameConditionTarget}; used by the generated selection code only. */
final class RepositoryNameConditionTargetSelectorImpl implements RepositoryNameConditionTargetSelector {

    private final Cursor cursor;

    RepositoryNameConditionTargetSelectorImpl(final Cursor cursor) {
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

    @Override
    public boolean protectedValue() {
        return cursor.getRequired("protected", ScalarType.BOOLEAN);
    }
}
