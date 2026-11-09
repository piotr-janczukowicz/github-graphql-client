package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDataType;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldVisibility;
import java.math.BigInteger;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldDate}; used by the generated selection code only. */
final class IssueFieldDateSelectorImpl implements IssueFieldDateSelector {

    private final Cursor cursor;

    IssueFieldDateSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public IssueFieldDataType dataType() {
        return cursor.getRequired(
                "dataType", ScalarType.enumeration(IssueFieldDataType::fromWire, IssueFieldDataType.DATE));
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
    public IssueFieldVisibility visibility() {
        return cursor.getRequired(
                "visibility", ScalarType.enumeration(IssueFieldVisibility::fromWire, IssueFieldVisibility.ALL));
    }
}
