package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPlanFeaturesSelector;

/** Reads and records the fields of {@code RepositoryPlanFeatures}; used by the generated selection code only. */
final class RepositoryPlanFeaturesSelectorImpl implements RepositoryPlanFeaturesSelector {

    private final Cursor cursor;

    RepositoryPlanFeaturesSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean codeowners() {
        return cursor.getRequired("codeowners", ScalarType.BOOLEAN);
    }

    @Override
    public boolean draftPullRequests() {
        return cursor.getRequired("draftPullRequests", ScalarType.BOOLEAN);
    }

    @Override
    public int maximumAssignees() {
        return cursor.getRequired("maximumAssignees", ScalarType.INT);
    }

    @Override
    public int maximumManualReviewRequests() {
        return cursor.getRequired("maximumManualReviewRequests", ScalarType.INT);
    }

    @Override
    public boolean teamReviewRequests() {
        return cursor.getRequired("teamReviewRequests", ScalarType.BOOLEAN);
    }
}
