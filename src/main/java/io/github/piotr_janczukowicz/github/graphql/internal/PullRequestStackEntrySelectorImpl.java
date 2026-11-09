package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestStackEntry}; used by the generated selection code only. */
final class PullRequestStackEntrySelectorImpl implements PullRequestStackEntrySelector {

    private final Cursor cursor;

    PullRequestStackEntrySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public int position() {
        return cursor.getRequired("position", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.object("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R stack(final Function<PullRequestStackSelector, R> selection) {
        return cursor.object("stack", child -> selection.apply(new PullRequestStackSelectorImpl(child)));
    }
}
