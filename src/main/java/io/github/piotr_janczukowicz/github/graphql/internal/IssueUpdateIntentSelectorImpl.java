package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueEventConfidenceLevel;
import io.github.piotr_janczukowicz.github.graphql.model.IssueUpdateIntentSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueUpdateIntent}; used by the generated selection code only. */
final class IssueUpdateIntentSelectorImpl implements IssueUpdateIntentSelector {

    private final Cursor cursor;

    IssueUpdateIntentSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable IssueEventConfidenceLevel confidence() {
        return cursor.get(
                "confidence",
                ScalarType.enumeration(IssueEventConfidenceLevel::fromWire, IssueEventConfidenceLevel.HIGH));
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable String intentId() {
        return cursor.get("intentId", ScalarType.STRING);
    }

    @Override
    public @Nullable String rationale() {
        return cursor.get("rationale", ScalarType.STRING);
    }
}
