package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerRepositoriesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerRepositoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryOwner}; used by the generated selection code only. */
final class RepositoryOwnerSelectorImpl implements RepositoryOwnerSelector {

    private static final String ARGUMENTS = "arguments";

    private static final String BOOLEAN = "Boolean";

    private final Cursor cursor;

    RepositoryOwnerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String avatarUrl(final RepositoryOwnerAvatarUrlFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(RepositoryOwnerAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String login() {
        return cursor.getRequired("login", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> repositories(
            final Paging paging,
            final RepositoryOwnerRepositoriesFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositories",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("affiliations", "[RepositoryAffiliation]", arguments.affiliations()),
                Argument.of("hasIssuesEnabled", BOOLEAN, arguments.hasIssuesEnabled()),
                Argument.of("isArchived", BOOLEAN, arguments.isArchived()),
                Argument.of("isFork", BOOLEAN, arguments.isFork()),
                Argument.of("isLocked", BOOLEAN, arguments.isLocked()),
                Argument.of(
                        "orderBy",
                        "RepositoryOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("ownerAffiliations", "[RepositoryAffiliation]", arguments.ownerAffiliations()),
                Argument.of("privacy", "RepositoryPrivacy", arguments.privacy()),
                Argument.of("visibility", "RepositoryVisibility", arguments.visibility()));
    }

    @Override
    public <R> Page<R> repositories(final Paging paging, final Function<RepositorySelector, R> selection) {
        return repositories(
                paging, RepositoryOwnerRepositoriesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R repository(
            final String name,
            final RepositoryOwnerRepositoryFilter arguments,
            final Function<RepositorySelector, R> selection) {
        requireNonNull(name, "name");
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "repository",
                child -> selection.apply(new RepositorySelectorImpl(child)),
                Argument.of("followRenames", BOOLEAN, arguments.followRenames()),
                Argument.of("name", "String!", name));
    }

    @Override
    public <R> @Nullable R repository(final String name, final Function<RepositorySelector, R> selection) {
        return repository(name, RepositoryOwnerRepositoryFilterBuilder.builder().build(), selection);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, RepositoryOwnerSelector.class, type, selection);
    }
}
