package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Query.marketplaceListings}; an argument left {@code null} is not sent. */
@RecordBuilder
public record QueryMarketplaceListingsFilter(
        @Nullable String adminId,
        @Nullable Boolean allStates,
        @Nullable String categorySlug,
        @Nullable String organizationId,
        @Nullable Boolean primaryCategoryOnly,
        @Nullable List<String> slugs,
        @Nullable Boolean useTopicAliases,
        @Nullable Boolean viewerCanAdmin,
        @Nullable Boolean withFreeTrialsOnly) {

    public QueryMarketplaceListingsFilter {
        slugs = ListUtils.copyOrNull(slugs);
    }
}
