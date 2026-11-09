package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueGroupingStrategy;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueMergeMethod;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueParametersSelector;

/** Reads and records the fields of {@code MergeQueueParameters}; used by the generated selection code only. */
final class MergeQueueParametersSelectorImpl implements MergeQueueParametersSelector {

    private final Cursor cursor;

    MergeQueueParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int checkResponseTimeoutMinutes() {
        return cursor.getRequired("checkResponseTimeoutMinutes", ScalarType.INT);
    }

    @Override
    public MergeQueueGroupingStrategy groupingStrategy() {
        return cursor.getRequired(
                "groupingStrategy",
                ScalarType.enumeration(MergeQueueGroupingStrategy::fromWire, MergeQueueGroupingStrategy.ALLGREEN));
    }

    @Override
    public int maxEntriesToBuild() {
        return cursor.getRequired("maxEntriesToBuild", ScalarType.INT);
    }

    @Override
    public int maxEntriesToMerge() {
        return cursor.getRequired("maxEntriesToMerge", ScalarType.INT);
    }

    @Override
    public MergeQueueMergeMethod mergeMethod() {
        return cursor.getRequired(
                "mergeMethod", ScalarType.enumeration(MergeQueueMergeMethod::fromWire, MergeQueueMergeMethod.MERGE));
    }

    @Override
    public int minEntriesToMerge() {
        return cursor.getRequired("minEntriesToMerge", ScalarType.INT);
    }

    @Override
    public int minEntriesToMergeWaitMinutes() {
        return cursor.getRequired("minEntriesToMergeWaitMinutes", ScalarType.INT);
    }
}
