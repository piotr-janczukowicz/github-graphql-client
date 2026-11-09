package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PackageStatisticsSelector;

/** Reads and records the fields of {@code PackageStatistics}; used by the generated selection code only. */
final class PackageStatisticsSelectorImpl implements PackageStatisticsSelector {

    private final Cursor cursor;

    PackageStatisticsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int downloadsTotalCount() {
        return cursor.getRequired("downloadsTotalCount", ScalarType.INT);
    }
}
