package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedIssueContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueContributionsByRepositoryContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueContributionsByRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code IssueContributionsByRepository}; used by the generated selection code only.
 */
final class IssueContributionsByRepositorySelectorImpl implements IssueContributionsByRepositorySelector {

    private final Cursor cursor;

    IssueContributionsByRepositorySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> contributions(
            final Paging paging,
            final IssueContributionsByRepositoryContributionsFilter arguments,
            final Function<CreatedIssueContributionSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "contributions",
                child -> selection.apply(new CreatedIssueContributionSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "ContributionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> contributions(
            final Paging paging, final Function<CreatedIssueContributionSelector, R> selection) {
        return contributions(
                paging,
                IssueContributionsByRepositoryContributionsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }
}
