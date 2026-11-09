package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TopicRelatedTopicsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.TopicRelatedTopicsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TopicRepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.TopicRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TopicStargazersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.TopicStargazersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code Topic}; used by the generated selection code only. */
final class TopicSelectorImpl implements TopicSelector {

    private static final String ARGUMENTS = "arguments";

    private static final String FIRST = "first";

    private static final String BOOLEAN = "Boolean";

    private final Cursor cursor;

    TopicSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> List<R> relatedTopics(
            final TopicRelatedTopicsFilter arguments, final Function<TopicSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.listRequired(
                "relatedTopics",
                child -> selection.apply(new TopicSelectorImpl(child)),
                Argument.of(FIRST, "Int", arguments.first()));
    }

    @Override
    public <R> List<R> relatedTopics(final Function<TopicSelector, R> selection) {
        return relatedTopics(TopicRelatedTopicsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> repositories(
            final Paging paging,
            final TopicRepositoriesFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositories",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of(FIRST, "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("affiliations", "[RepositoryAffiliation]", arguments.affiliations()),
                Argument.of("hasIssuesEnabled", BOOLEAN, arguments.hasIssuesEnabled()),
                Argument.of("isLocked", BOOLEAN, arguments.isLocked()),
                Argument.of(
                        "orderBy",
                        "RepositoryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("ownerAffiliations", "[RepositoryAffiliation]", arguments.ownerAffiliations()),
                Argument.of("privacy", "RepositoryPrivacy", arguments.privacy()),
                Argument.of("sponsorableOnly", BOOLEAN, arguments.sponsorableOnly()),
                Argument.of("visibility", "RepositoryVisibility", arguments.visibility()));
    }

    @Override
    public <R> Page<R> repositories(final Paging paging, final Function<RepositorySelector, R> selection) {
        return repositories(paging, TopicRepositoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public int stargazerCount() {
        return cursor.getRequired("stargazerCount", ScalarType.INT);
    }

    @Override
    public <R> Page<R> stargazers(
            final Paging paging, final TopicStargazersFilter arguments, final Function<UserSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "stargazers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "StarOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> stargazers(final Paging paging, final Function<UserSelector, R> selection) {
        return stargazers(paging, TopicStargazersFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean viewerHasStarred() {
        return cursor.getRequired("viewerHasStarred", ScalarType.BOOLEAN);
    }
}
