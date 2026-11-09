package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code EnterpriseBillingInfo}. */
public interface EnterpriseBillingInfoSelector {

    int allLicensableUsersCount();

    /** @deprecated LFS data packs have been removed. Always returns 0. */
    @Deprecated(forRemoval = false)
    int assetPacks();

    double bandwidthQuota();

    double bandwidthUsage();

    int bandwidthUsagePercentage();

    double storageQuota();

    double storageUsage();

    int storageUsagePercentage();

    int totalAvailableLicenses();

    int totalLicenses();
}
