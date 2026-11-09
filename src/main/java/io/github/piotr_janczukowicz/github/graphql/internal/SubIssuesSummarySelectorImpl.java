package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SubIssuesSummarySelector;

/** Reads and records the fields of {@code SubIssuesSummary}; used by the generated selection code only. */
final class SubIssuesSummarySelectorImpl implements SubIssuesSummarySelector {

    private final Cursor cursor;

    SubIssuesSummarySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int completed() {
        return cursor.getRequired("completed", ScalarType.INT);
    }

    @Override
    public int percentCompleted() {
        return cursor.getRequired("percentCompleted", ScalarType.INT);
    }

    @Override
    public int total() {
        return cursor.getRequired("total", ScalarType.INT);
    }
}
