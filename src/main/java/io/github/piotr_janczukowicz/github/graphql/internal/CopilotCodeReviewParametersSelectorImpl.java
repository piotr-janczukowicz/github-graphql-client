package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewParametersSelector;

/** Reads and records the fields of {@code CopilotCodeReviewParameters}; used by the generated selection code only. */
final class CopilotCodeReviewParametersSelectorImpl implements CopilotCodeReviewParametersSelector {

    private final Cursor cursor;

    CopilotCodeReviewParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean reviewDraftPullRequests() {
        return cursor.getRequired("reviewDraftPullRequests", ScalarType.BOOLEAN);
    }

    @Override
    public boolean reviewOnPush() {
        return cursor.getRequired("reviewOnPush", ScalarType.BOOLEAN);
    }
}
