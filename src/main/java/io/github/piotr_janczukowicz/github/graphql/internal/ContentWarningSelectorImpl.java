package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ContentWarningSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ContentWarning}; used by the generated selection code only. */
final class ContentWarningSelectorImpl implements ContentWarningSelector {

    private final Cursor cursor;

    ContentWarningSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String category() {
        return cursor.getRequired("category", ScalarType.STRING);
    }

    @Override
    public @Nullable String customSubCategory() {
        return cursor.get("customSubCategory", ScalarType.STRING);
    }

    @Override
    public @Nullable String subCategory() {
        return cursor.get("subCategory", ScalarType.STRING);
    }

    @Override
    public @Nullable String subTitle() {
        return cursor.get("subTitle", ScalarType.STRING);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public String type() {
        return cursor.getRequired("type", ScalarType.STRING);
    }
}
