package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitContributionsByRepositoryContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CommitContributionsByRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedCommitContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code CommitContributionsByRepository}; used by the generated selection code only.
 */
final class CommitContributionsByRepositorySelectorImpl implements CommitContributionsByRepositorySelector {

    private final Cursor cursor;

    CommitContributionsByRepositorySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> contributions(
            final Paging paging,
            final CommitContributionsByRepositoryContributionsFilter arguments,
            final Function<CreatedCommitContributionSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "contributions",
                child -> selection.apply(new CreatedCommitContributionSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "CommitContributionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> contributions(
            final Paging paging, final Function<CreatedCommitContributionSelector, R> selection) {
        return contributions(
                paging,
                CommitContributionsByRepositoryContributionsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
