package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueOrPullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnmarkIssueAsDuplicatePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UnmarkIssueAsDuplicatePayload}; used by the generated selection code only. */
final class UnmarkIssueAsDuplicatePayloadSelectorImpl implements UnmarkIssueAsDuplicatePayloadSelector {

    private final Cursor cursor;

    UnmarkIssueAsDuplicatePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R duplicate(final Function<IssueOrPullRequestSelector, R> selection) {
        return cursor.object("duplicate", child -> selection.apply(new IssueOrPullRequestSelectorImpl(child)));
    }
}
