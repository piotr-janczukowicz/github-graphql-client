package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreatedIssueOrRestrictedContributionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CreatedIssueOrRestrictedContribution}; used by the generated selection code
 * only.
 */
final class CreatedIssueOrRestrictedContributionSelectorImpl implements CreatedIssueOrRestrictedContributionSelector {

    private final Cursor cursor;

    CreatedIssueOrRestrictedContributionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, CreatedIssueOrRestrictedContributionSelector.class, type, selection);
    }
}
