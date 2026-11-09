package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIdConditionTargetSelector;
import java.util.List;

/** Reads and records the fields of {@code RepositoryIdConditionTarget}; used by the generated selection code only. */
final class RepositoryIdConditionTargetSelectorImpl implements RepositoryIdConditionTargetSelector {

    private final Cursor cursor;

    RepositoryIdConditionTargetSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> repositoryIds() {
        return cursor.scalarListRequired("repositoryIds", ScalarType.STRING);
    }
}
