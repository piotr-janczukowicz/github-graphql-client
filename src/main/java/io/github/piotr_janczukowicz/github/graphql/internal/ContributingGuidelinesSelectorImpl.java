package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ContributingGuidelinesSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ContributingGuidelines}; used by the generated selection code only. */
final class ContributingGuidelinesSelectorImpl implements ContributingGuidelinesSelector {

    private final Cursor cursor;

    ContributingGuidelinesSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String body() {
        return cursor.get("body", ScalarType.STRING);
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
