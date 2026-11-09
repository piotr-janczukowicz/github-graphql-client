package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedIssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.math.BigInteger;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PinnedIssue}; used by the generated selection code only. */
final class PinnedIssueSelectorImpl implements PinnedIssueSelector {

    private final Cursor cursor;

    PinnedIssueSelectorImpl(final Cursor cursor) {
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
    public <R> R pinnedBy(final Function<ActorSelector, R> selection) {
        return cursor.objectRequired("pinnedBy", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
