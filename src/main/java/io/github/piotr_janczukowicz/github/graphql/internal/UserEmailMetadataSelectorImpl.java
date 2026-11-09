package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UserEmailMetadataSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UserEmailMetadata}; used by the generated selection code only. */
final class UserEmailMetadataSelectorImpl implements UserEmailMetadataSelector {

    private final Cursor cursor;

    UserEmailMetadataSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Boolean primary() {
        return cursor.get("primary", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String type() {
        return cursor.get("type", ScalarType.STRING);
    }

    @Override
    public String value() {
        return cursor.getRequired("value", ScalarType.STRING);
    }
}
