package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentUnpinnedEventSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueCommentUnpinnedEvent}; used by the generated selection code only. */
final class IssueCommentUnpinnedEventSelectorImpl implements IssueCommentUnpinnedEventSelector {

    private final Cursor cursor;

    IssueCommentUnpinnedEventSelectorImpl(final Cursor cursor) {
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
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R issueComment(final Function<IssueCommentSelector, R> selection) {
        return cursor.object("issueComment", child -> selection.apply(new IssueCommentSelectorImpl(child)));
    }
}
