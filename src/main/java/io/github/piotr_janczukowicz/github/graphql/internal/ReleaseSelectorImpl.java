package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseAssetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseReactionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseReleaseAssetsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseReleaseAssetsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseShortDescriptionHTMLFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseShortDescriptionHTMLFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Release}; used by the generated selection code only. */
final class ReleaseSelectorImpl implements ReleaseSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ARGUMENTS = "arguments";

    private final Cursor cursor;

    ReleaseSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R author(final Function<UserSelector, R> selection) {
        return cursor.object("author", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public @Nullable String descriptionHTML() {
        return cursor.get("descriptionHTML", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean immutable() {
        return cursor.getRequired("immutable", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isDraft() {
        return cursor.getRequired("isDraft", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isLatest() {
        return cursor.getRequired("isLatest", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isPrerelease() {
        return cursor.getRequired("isPrerelease", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> mentions(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "mentions",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant publishedAt() {
        return cursor.get("publishedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> List<R> reactionGroups(final Function<ReactionGroupSelector, R> selection) {
        return cursor.list("reactionGroups", child -> selection.apply(new ReactionGroupSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> reactions(
            final Paging paging,
            final ReleaseReactionsFilter arguments,
            final Function<ReactionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "reactions",
                child -> selection.apply(new ReactionSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("content", "ReactionContent", arguments.content()),
                Argument.of(
                        "orderBy",
                        "ReactionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> reactions(final Paging paging, final Function<ReactionSelector, R> selection) {
        return reactions(paging, ReleaseReactionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> releaseAssets(
            final Paging paging,
            final ReleaseReleaseAssetsFilter arguments,
            final Function<ReleaseAssetSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "releaseAssets",
                child -> selection.apply(new ReleaseAssetSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("name", STRING, arguments.name()));
    }

    @Override
    public <R> Page<R> releaseAssets(final Paging paging, final Function<ReleaseAssetSelector, R> selection) {
        return releaseAssets(paging, ReleaseReleaseAssetsFilterBuilder.builder().build(), selection);
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
    public @Nullable String shortDescriptionHTML(final ReleaseShortDescriptionHTMLFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.get("shortDescriptionHTML", ScalarType.STRING, Argument.of("limit", "Int", arguments.limit()));
    }

    @Override
    public @Nullable String shortDescriptionHTML() {
        return shortDescriptionHTML(
                ReleaseShortDescriptionHTMLFilterBuilder.builder().build());
    }

    @Override
    public <R> @Nullable R tag(final Function<RefSelector, R> selection) {
        return cursor.object("tag", child -> selection.apply(new RefSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R tagCommit(final Function<CommitSelector, R> selection) {
        return cursor.object("tagCommit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public String tagName() {
        return cursor.getRequired("tagName", ScalarType.STRING);
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
    public boolean viewerCanReact() {
        return cursor.getRequired("viewerCanReact", ScalarType.BOOLEAN);
    }
}
