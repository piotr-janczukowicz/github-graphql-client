package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseBillingInfoSelector;

/** Reads and records the fields of {@code EnterpriseBillingInfo}; used by the generated selection code only. */
final class EnterpriseBillingInfoSelectorImpl implements EnterpriseBillingInfoSelector {

    private final Cursor cursor;

    EnterpriseBillingInfoSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int allLicensableUsersCount() {
        return cursor.getRequired("allLicensableUsersCount", ScalarType.INT);
    }

    /** @deprecated LFS data packs have been removed. Always returns 0. */
    @Override
    @Deprecated(forRemoval = false)
    public int assetPacks() {
        return cursor.getRequired("assetPacks", ScalarType.INT);
    }

    @Override
    public double bandwidthQuota() {
        return cursor.getRequired("bandwidthQuota", ScalarType.FLOAT);
    }

    @Override
    public double bandwidthUsage() {
        return cursor.getRequired("bandwidthUsage", ScalarType.FLOAT);
    }

    @Override
    public int bandwidthUsagePercentage() {
        return cursor.getRequired("bandwidthUsagePercentage", ScalarType.INT);
    }

    @Override
    public double storageQuota() {
        return cursor.getRequired("storageQuota", ScalarType.FLOAT);
    }

    @Override
    public double storageUsage() {
        return cursor.getRequired("storageUsage", ScalarType.FLOAT);
    }

    @Override
    public int storageUsagePercentage() {
        return cursor.getRequired("storageUsagePercentage", ScalarType.INT);
    }

    @Override
    public int totalAvailableLicenses() {
        return cursor.getRequired("totalAvailableLicenses", ScalarType.INT);
    }

    @Override
    public int totalLicenses() {
        return cursor.getRequired("totalLicenses", ScalarType.INT);
    }
}
