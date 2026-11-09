package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrPullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnmarkedAsDuplicateEventSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UnmarkedAsDuplicateEvent}; used by the generated selection code only. */
final class UnmarkedAsDuplicateEventSelectorImpl implements UnmarkedAsDuplicateEventSelector {

    private final Cursor cursor;

    UnmarkedAsDuplicateEventSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R canonical(final Function<IssueOrPullRequestSelector, R> selection) {
        return cursor.object("canonical", child -> selection.apply(new IssueOrPullRequestSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R duplicate(final Function<IssueOrPullRequestSelector, R> selection) {
        return cursor.object("duplicate", child -> selection.apply(new IssueOrPullRequestSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isCrossRepository() {
        return cursor.getRequired("isCrossRepository", ScalarType.BOOLEAN);
    }
}
