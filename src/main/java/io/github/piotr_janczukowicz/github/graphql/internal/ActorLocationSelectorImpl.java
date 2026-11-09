package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorLocationSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ActorLocation}; used by the generated selection code only. */
final class ActorLocationSelectorImpl implements ActorLocationSelector {

    private final Cursor cursor;

    ActorLocationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String city() {
        return cursor.get("city", ScalarType.STRING);
    }

    @Override
    public @Nullable String country() {
        return cursor.get("country", ScalarType.STRING);
    }

    @Override
    public @Nullable String countryCode() {
        return cursor.get("countryCode", ScalarType.STRING);
    }

    @Override
    public @Nullable String region() {
        return cursor.get("region", ScalarType.STRING);
    }

    @Override
    public @Nullable String regionCode() {
        return cursor.get("regionCode", ScalarType.STRING);
    }
}
