package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueDependenciesSummarySelector;

/** Reads and records the fields of {@code IssueDependenciesSummary}; used by the generated selection code only. */
final class IssueDependenciesSummarySelectorImpl implements IssueDependenciesSummarySelector {

    private final Cursor cursor;

    IssueDependenciesSummarySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int blockedBy() {
        return cursor.getRequired("blockedBy", ScalarType.INT);
    }

    @Override
    public int blocking() {
        return cursor.getRequired("blocking", ScalarType.INT);
    }

    @Override
    public int totalBlockedBy() {
        return cursor.getRequired("totalBlockedBy", ScalarType.INT);
    }

    @Override
    public int totalBlocking() {
        return cursor.getRequired("totalBlocking", ScalarType.INT);
    }
}
