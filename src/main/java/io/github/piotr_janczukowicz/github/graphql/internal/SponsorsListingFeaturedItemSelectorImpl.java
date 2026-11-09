package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeatureableItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingFeaturedItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SponsorsListingFeaturedItem}; used by the generated selection code only. */
final class SponsorsListingFeaturedItemSelectorImpl implements SponsorsListingFeaturedItemSelector {

    private final Cursor cursor;

    SponsorsListingFeaturedItemSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public <R> R featureable(final Function<SponsorsListingFeatureableItemSelector, R> selection) {
        return cursor.objectRequired(
                "featureable", child -> selection.apply(new SponsorsListingFeatureableItemSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public int position() {
        return cursor.getRequired("position", ScalarType.INT);
    }

    @Override
    public <R> R sponsorsListing(final Function<SponsorsListingSelector, R> selection) {
        return cursor.objectRequired(
                "sponsorsListing", child -> selection.apply(new SponsorsListingSelectorImpl(child)));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
