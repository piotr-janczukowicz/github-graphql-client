package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestRevisionMarkerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import java.time.Instant;
import java.util.function.Function;

/** Reads and records the fields of {@code PullRequestRevisionMarker}; used by the generated selection code only. */
final class PullRequestRevisionMarkerSelectorImpl implements PullRequestRevisionMarkerSelector {

    private final Cursor cursor;

    PullRequestRevisionMarkerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R lastSeenCommit(final Function<CommitSelector, R> selection) {
        return cursor.objectRequired("lastSeenCommit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }
}
