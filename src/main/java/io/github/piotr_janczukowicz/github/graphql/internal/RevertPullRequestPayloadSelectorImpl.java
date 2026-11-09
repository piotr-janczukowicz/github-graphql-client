package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RevertPullRequestPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RevertPullRequestPayload}; used by the generated selection code only. */
final class RevertPullRequestPayloadSelectorImpl implements RevertPullRequestPayloadSelector {

    private final Cursor cursor;

    RevertPullRequestPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R revertPullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("revertPullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }
}
