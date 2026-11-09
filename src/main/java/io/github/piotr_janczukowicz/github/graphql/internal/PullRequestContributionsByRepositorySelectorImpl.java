package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestContributionsByRepositoryContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestContributionsByRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code PullRequestContributionsByRepository}; used by the generated selection code
 * only.
 */
final class PullRequestContributionsByRepositorySelectorImpl implements PullRequestContributionsByRepositorySelector {

    private final Cursor cursor;

    PullRequestContributionsByRepositorySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> contributions(
            final Paging paging,
            final PullRequestContributionsByRepositoryContributionsFilter arguments,
            final Function<CreatedPullRequestContributionSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "contributions",
                child -> selection.apply(new CreatedPullRequestContributionSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "ContributionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> contributions(
            final Paging paging, final Function<CreatedPullRequestContributionSelector, R> selection) {
        return contributions(
                paging,
                PullRequestContributionsByRepositoryContributionsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
