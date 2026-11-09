package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestOrRestrictedContributionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CreatedPullRequestOrRestrictedContribution}; used by the generated selection
 * code only.
 */
final class CreatedPullRequestOrRestrictedContributionSelectorImpl
        implements CreatedPullRequestOrRestrictedContributionSelector {

    private final Cursor cursor;

    CreatedPullRequestOrRestrictedContributionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, CreatedPullRequestOrRestrictedContributionSelector.class, type, selection);
    }
}
