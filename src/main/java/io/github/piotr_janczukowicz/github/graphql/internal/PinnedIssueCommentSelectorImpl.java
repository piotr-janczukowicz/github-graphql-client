package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedIssueCommentSelector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PinnedIssueComment}; used by the generated selection code only. */
final class PinnedIssueCommentSelectorImpl implements PinnedIssueCommentSelector {

    private final Cursor cursor;

    PinnedIssueCommentSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> R issue(final Function<IssueSelector, R> selection) {
        return cursor.objectRequired("issue", child -> selection.apply(new IssueSelectorImpl(child)));
    }

    @Override
    public <R> R issueComment(final Function<IssueCommentSelector, R> selection) {
        return cursor.objectRequired("issueComment", child -> selection.apply(new IssueCommentSelectorImpl(child)));
    }

    @Override
    public Instant pinnedAt() {
        return cursor.getRequired("pinnedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R pinnedBy(final Function<ActorSelector, R> selection) {
        return cursor.objectRequired("pinnedBy", child -> selection.apply(new ActorSelectorImpl(child)));
    }
}
