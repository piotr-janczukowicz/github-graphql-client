package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PackageVersionStatisticsSelector;

/** Reads and records the fields of {@code PackageVersionStatistics}; used by the generated selection code only. */
final class PackageVersionStatisticsSelectorImpl implements PackageVersionStatisticsSelector {

    private final Cursor cursor;

    PackageVersionStatisticsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int downloadsTotalCount() {
        return cursor.getRequired("downloadsTotalCount", ScalarType.INT);
    }
}
