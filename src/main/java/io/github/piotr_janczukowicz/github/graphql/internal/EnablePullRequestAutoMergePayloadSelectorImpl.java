package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnablePullRequestAutoMergePayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code EnablePullRequestAutoMergePayload}; used by the generated selection code only.
 */
final class EnablePullRequestAutoMergePayloadSelectorImpl implements EnablePullRequestAutoMergePayloadSelector {

    private final Cursor cursor;

    EnablePullRequestAutoMergePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }
}
