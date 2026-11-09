package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreatedRepositoryOrRestrictedContributionSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CreatedRepositoryOrRestrictedContribution}; used by the generated selection
 * code only.
 */
final class CreatedRepositoryOrRestrictedContributionSelectorImpl
        implements CreatedRepositoryOrRestrictedContributionSelector {

    private final Cursor cursor;

    CreatedRepositoryOrRestrictedContributionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, CreatedRepositoryOrRestrictedContributionSelector.class, type, selection);
    }
}
