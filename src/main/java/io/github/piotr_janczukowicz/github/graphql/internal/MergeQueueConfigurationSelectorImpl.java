package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueConfigurationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeQueueMergingStrategy;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestMergeMethod;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MergeQueueConfiguration}; used by the generated selection code only. */
final class MergeQueueConfigurationSelectorImpl implements MergeQueueConfigurationSelector {

    private final Cursor cursor;

    MergeQueueConfigurationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Integer checkResponseTimeout() {
        return cursor.get("checkResponseTimeout", ScalarType.INT);
    }

    @Override
    public @Nullable Integer maximumEntriesToBuild() {
        return cursor.get("maximumEntriesToBuild", ScalarType.INT);
    }

    @Override
    public @Nullable Integer maximumEntriesToMerge() {
        return cursor.get("maximumEntriesToMerge", ScalarType.INT);
    }

    @Override
    public @Nullable PullRequestMergeMethod mergeMethod() {
        return cursor.get(
                "mergeMethod", ScalarType.enumeration(PullRequestMergeMethod::fromWire, PullRequestMergeMethod.MERGE));
    }

    @Override
    public @Nullable MergeQueueMergingStrategy mergingStrategy() {
        return cursor.get(
                "mergingStrategy",
                ScalarType.enumeration(MergeQueueMergingStrategy::fromWire, MergeQueueMergingStrategy.ALLGREEN));
    }

    @Override
    public @Nullable Integer minimumEntriesToMerge() {
        return cursor.get("minimumEntriesToMerge", ScalarType.INT);
    }

    @Override
    public @Nullable Integer minimumEntriesToMergeWaitTime() {
        return cursor.get("minimumEntriesToMergeWaitTime", ScalarType.INT);
    }
}
