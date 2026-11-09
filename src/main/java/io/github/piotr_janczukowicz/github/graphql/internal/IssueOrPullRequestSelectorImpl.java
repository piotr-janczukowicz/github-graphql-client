package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueOrPullRequestSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueOrPullRequest}; used by the generated selection code only. */
final class IssueOrPullRequestSelectorImpl implements IssueOrPullRequestSelector {

    private final Cursor cursor;

    IssueOrPullRequestSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, IssueOrPullRequestSelector.class, type, selection);
    }
}
