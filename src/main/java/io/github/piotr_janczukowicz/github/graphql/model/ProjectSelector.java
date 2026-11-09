package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Project}. */
public interface ProjectSelector {

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable String body();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    String bodyHTML();

    boolean closed();

    @Nullable Instant closedAt();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> columns(Paging paging, Function<ProjectColumnSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    Instant createdAt();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> @Nullable R creator(Function<ActorSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    String id();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    String name();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    int number();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> R owner(Function<ProjectOwnerSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> pendingCards(
            Paging paging, ProjectPendingCardsFilter arguments, Function<ProjectCardSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> Page<R> pendingCards(Paging paging, Function<ProjectCardSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> R progress(Function<ProjectProgressSelector, R> selection);

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    String resourcePath();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    ProjectState state();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    Instant updatedAt();

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    String url();

    boolean viewerCanClose();

    boolean viewerCanReopen();

    boolean viewerCanUpdate();
}
