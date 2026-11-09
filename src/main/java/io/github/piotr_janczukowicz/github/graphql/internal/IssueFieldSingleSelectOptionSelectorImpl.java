package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectOptionColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectOptionSelector;
import java.math.BigInteger;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldSingleSelectOption}; used by the generated selection code only. */
final class IssueFieldSingleSelectOptionSelectorImpl implements IssueFieldSingleSelectOptionSelector {

    private final Cursor cursor;

    IssueFieldSingleSelectOptionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public IssueFieldSingleSelectOptionColor color() {
        return cursor.getRequired(
                "color",
                ScalarType.enumeration(
                        IssueFieldSingleSelectOptionColor::fromWire, IssueFieldSingleSelectOptionColor.BLUE));
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer priority() {
        return cursor.get("priority", ScalarType.INT);
    }
}
