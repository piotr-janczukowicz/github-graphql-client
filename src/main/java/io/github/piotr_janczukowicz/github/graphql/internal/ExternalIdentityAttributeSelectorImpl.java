package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentityAttributeSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ExternalIdentityAttribute}; used by the generated selection code only. */
final class ExternalIdentityAttributeSelectorImpl implements ExternalIdentityAttributeSelector {

    private final Cursor cursor;

    ExternalIdentityAttributeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String metadata() {
        return cursor.get("metadata", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String value() {
        return cursor.getRequired("value", ScalarType.STRING);
    }
}
