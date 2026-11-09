package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Query.marketplaceCategories}; an argument left {@code null} is not sent. */
@RecordBuilder
public record QueryMarketplaceCategoriesFilter(
        @Nullable Boolean excludeEmpty,
        @Nullable Boolean excludeSubcategories,
        @Nullable List<String> includeCategories) {

    public QueryMarketplaceCategoriesFilter {
        includeCategories = ListUtils.copyOrNull(includeCategories);
    }
}
