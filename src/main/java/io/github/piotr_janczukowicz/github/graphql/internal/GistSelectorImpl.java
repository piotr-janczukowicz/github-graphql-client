package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.GistCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistFilesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.GistFilesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.GistForksFilter;
import io.github.piotr_janczukowicz.github.graphql.model.GistForksFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistStargazersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.GistStargazersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Gist}; used by the generated selection code only. */
final class GistSelectorImpl implements GistSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ARGUMENTS = "arguments";

    private final Cursor cursor;

    GistSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> comments(final Paging paging, final Function<GistCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "comments",
                child -> selection.apply(new GistCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public <R> List<R> files(final GistFilesFilter arguments, final Function<GistFileSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.list(
                "files",
                child -> selection.apply(new GistFileSelectorImpl(child)),
                Argument.of("limit", "Int", arguments.limit()),
                Argument.of("oid", "GitObjectID", arguments.oid()));
    }

    @Override
    public <R> List<R> files(final Function<GistFileSelector, R> selection) {
        return files(GistFilesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> forks(
            final Paging paging, final GistForksFilter arguments, final Function<GistSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "forks",
                child -> selection.apply(new GistSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "GistOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> forks(final Paging paging, final Function<GistSelector, R> selection) {
        return forks(paging, GistForksFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isFork() {
        return cursor.getRequired("isFork", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isPublic() {
        return cursor.getRequired("isPublic", ScalarType.BOOLEAN);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R owner(final Function<RepositoryOwnerSelector, R> selection) {
        return cursor.object("owner", child -> selection.apply(new RepositoryOwnerSelectorImpl(child)));
    }

    @Override
    public @Nullable Instant pushedAt() {
        return cursor.get("pushedAt", ScalarType.INSTANT);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public int stargazerCount() {
        return cursor.getRequired("stargazerCount", ScalarType.INT);
    }

    @Override
    public <R> Page<R> stargazers(
            final Paging paging, final GistStargazersFilter arguments, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "stargazers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "StarOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> stargazers(final Paging paging, final Function<UserSelector, R> selection) {
        return stargazers(paging, GistStargazersFilterBuilder.builder().build(), selection);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public boolean viewerHasStarred() {
        return cursor.getRequired("viewerHasStarred", ScalarType.BOOLEAN);
    }
}
