package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestReviewContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewContributionsByRepositoryContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewContributionsByRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code PullRequestReviewContributionsByRepository}; used by the generated selection
 * code only.
 */
final class PullRequestReviewContributionsByRepositorySelectorImpl
        implements PullRequestReviewContributionsByRepositorySelector {

    private final Cursor cursor;

    PullRequestReviewContributionsByRepositorySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> contributions(
            final Paging paging,
            final PullRequestReviewContributionsByRepositoryContributionsFilter arguments,
            final Function<CreatedPullRequestReviewContributionSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "contributions",
                child -> selection.apply(new CreatedPullRequestReviewContributionSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "ContributionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> contributions(
            final Paging paging, final Function<CreatedPullRequestReviewContributionSelector, R> selection) {
        return contributions(
                paging,
                PullRequestReviewContributionsByRepositoryContributionsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
