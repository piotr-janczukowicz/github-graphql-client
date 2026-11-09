package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MarketplaceCategorySelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MarketplaceCategory}; used by the generated selection code only. */
final class MarketplaceCategorySelectorImpl implements MarketplaceCategorySelector {

    private final Cursor cursor;

    MarketplaceCategorySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public @Nullable String howItWorks() {
        return cursor.get("howItWorks", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public int primaryListingCount() {
        return cursor.getRequired("primaryListingCount", ScalarType.INT);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public int secondaryListingCount() {
        return cursor.getRequired("secondaryListingCount", ScalarType.INT);
    }

    @Override
    public String slug() {
        return cursor.getRequired("slug", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
