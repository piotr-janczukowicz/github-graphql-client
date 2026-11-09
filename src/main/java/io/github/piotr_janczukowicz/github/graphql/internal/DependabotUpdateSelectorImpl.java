package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DependabotUpdateErrorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DependabotUpdateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DependabotUpdate}; used by the generated selection code only. */
final class DependabotUpdateSelectorImpl implements DependabotUpdateSelector {

    private final Cursor cursor;

    DependabotUpdateSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R error(final Function<DependabotUpdateErrorSelector, R> selection) {
        return cursor.object("error", child -> selection.apply(new DependabotUpdateErrorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
