package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDataType;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldVisibility;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldSingleSelect}; used by the generated selection code only. */
final class IssueFieldSingleSelectSelectorImpl implements IssueFieldSingleSelectSelector {

    private final Cursor cursor;

    IssueFieldSingleSelectSelectorImpl(final Cursor cursor) {
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
    public <R> List<R> options(final Function<IssueFieldSingleSelectOptionSelector, R> selection) {
        return cursor.listRequired(
                "options", child -> selection.apply(new IssueFieldSingleSelectOptionSelectorImpl(child)));
    }

    @Override
    public IssueFieldVisibility visibility() {
        return cursor.getRequired(
                "visibility", ScalarType.enumeration(IssueFieldVisibility::fromWire, IssueFieldVisibility.ALL));
    }
}
