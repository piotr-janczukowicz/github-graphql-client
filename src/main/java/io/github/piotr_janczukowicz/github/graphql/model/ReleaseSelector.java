package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Release}. */
public interface ReleaseSelector {

    <R> @Nullable R author(Function<UserSelector, R> selection);

    Instant createdAt();

    @Nullable Integer databaseId();

    @Nullable String description();

    @Nullable String descriptionHTML();

    String id();

    boolean immutable();

    boolean isDraft();

    boolean isLatest();

    boolean isPrerelease();

    <R> Page<R> mentions(Paging paging, Function<UserSelector, R> selection);

    @Nullable String name();

    @Nullable Instant publishedAt();

    <R> List<R> reactionGroups(Function<ReactionGroupSelector, R> selection);

    <R> Page<R> reactions(Paging paging, ReleaseReactionsFilter arguments, Function<ReactionSelector, R> selection);

    <R> Page<R> reactions(Paging paging, Function<ReactionSelector, R> selection);

    <R> Page<R> releaseAssets(
            Paging paging, ReleaseReleaseAssetsFilter arguments, Function<ReleaseAssetSelector, R> selection);

    <R> Page<R> releaseAssets(Paging paging, Function<ReleaseAssetSelector, R> selection);

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    @Nullable String shortDescriptionHTML(ReleaseShortDescriptionHTMLFilter arguments);

    @Nullable String shortDescriptionHTML();

    <R> @Nullable R tag(Function<RefSelector, R> selection);

    <R> @Nullable R tagCommit(Function<CommitSelector, R> selection);

    String tagName();

    Instant updatedAt();

    String url();

    boolean viewerCanReact();
}
