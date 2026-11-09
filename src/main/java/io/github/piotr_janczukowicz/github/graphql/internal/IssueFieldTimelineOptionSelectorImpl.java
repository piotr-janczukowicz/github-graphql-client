package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldTimelineOptionSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldTimelineOption}; used by the generated selection code only. */
final class IssueFieldTimelineOptionSelectorImpl implements IssueFieldTimelineOptionSelector {

    private final Cursor cursor;

    IssueFieldTimelineOptionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String color() {
        return cursor.get("color", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }
}
