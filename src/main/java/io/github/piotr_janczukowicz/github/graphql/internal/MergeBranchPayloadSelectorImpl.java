package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.MergeBranchPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code MergeBranchPayload}; used by the generated selection code only. */
final class MergeBranchPayloadSelectorImpl implements MergeBranchPayloadSelector {

    private final Cursor cursor;

    MergeBranchPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R mergeCommit(final Function<CommitSelector, R> selection) {
        return cursor.object("mergeCommit", child -> selection.apply(new CommitSelectorImpl(child)));
    }
}
