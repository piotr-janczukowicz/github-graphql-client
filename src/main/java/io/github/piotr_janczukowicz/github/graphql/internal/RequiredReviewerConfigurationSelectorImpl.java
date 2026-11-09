package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RequiredReviewerConfigurationSelector;
import java.util.List;

/** Reads and records the fields of {@code RequiredReviewerConfiguration}; used by the generated selection code only. */
final class RequiredReviewerConfigurationSelectorImpl implements RequiredReviewerConfigurationSelector {

    private final Cursor cursor;

    RequiredReviewerConfigurationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> filePatterns() {
        return cursor.scalarListRequired("filePatterns", ScalarType.STRING);
    }

    @Override
    public int minimumApprovals() {
        return cursor.getRequired("minimumApprovals", ScalarType.INT);
    }

    @Override
    public String reviewerId() {
        return cursor.getRequired("reviewerId", ScalarType.STRING);
    }
}
