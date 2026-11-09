package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.LanguageSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Language}; used by the generated selection code only. */
final class LanguageSelectorImpl implements LanguageSelector {

    private final Cursor cursor;

    LanguageSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String color() {
        return cursor.get("color", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }
}
