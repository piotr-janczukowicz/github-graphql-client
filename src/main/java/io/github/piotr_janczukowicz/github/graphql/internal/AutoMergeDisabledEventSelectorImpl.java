package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AutoMergeDisabledEventSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AutoMergeDisabledEvent}; used by the generated selection code only. */
final class AutoMergeDisabledEventSelectorImpl implements AutoMergeDisabledEventSelector {

    private final Cursor cursor;

    AutoMergeDisabledEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R disabler(final Function<UserSelector, R> selection) {
        return cursor.object("disabler", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public @Nullable String reason() {
        return cursor.get("reason", ScalarType.STRING);
    }

    @Override
    public @Nullable String reasonCode() {
        return cursor.get("reasonCode", ScalarType.STRING);
    }
}
