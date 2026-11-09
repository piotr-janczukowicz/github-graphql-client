package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersErrorSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryCodeownersError}; used by the generated selection code only. */
final class RepositoryCodeownersErrorSelectorImpl implements RepositoryCodeownersErrorSelector {

    private final Cursor cursor;

    RepositoryCodeownersErrorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int column() {
        return cursor.getRequired("column", ScalarType.INT);
    }

    @Override
    public String kind() {
        return cursor.getRequired("kind", ScalarType.STRING);
    }

    @Override
    public int line() {
        return cursor.getRequired("line", ScalarType.INT);
    }

    @Override
    public String message() {
        return cursor.getRequired("message", ScalarType.STRING);
    }

    @Override
    public String path() {
        return cursor.getRequired("path", ScalarType.STRING);
    }

    @Override
    public String source() {
        return cursor.getRequired("source", ScalarType.STRING);
    }

    @Override
    public @Nullable String suggestion() {
        return cursor.get("suggestion", ScalarType.STRING);
    }
}
