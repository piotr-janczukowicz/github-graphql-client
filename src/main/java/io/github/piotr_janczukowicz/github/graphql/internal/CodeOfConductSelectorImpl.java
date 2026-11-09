package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CodeOfConductSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CodeOfConduct}; used by the generated selection code only. */
final class CodeOfConductSelectorImpl implements CodeOfConductSelector {

    private final Cursor cursor;

    CodeOfConductSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String body() {
        return cursor.get("body", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String key() {
        return cursor.getRequired("key", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public @Nullable String resourcePath() {
        return cursor.get("resourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable String url() {
        return cursor.get("url", ScalarType.STRING);
    }
}
