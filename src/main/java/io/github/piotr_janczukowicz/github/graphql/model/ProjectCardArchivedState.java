package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code ProjectCardArchivedState}; it is only sent to GitHub, never read. */
public enum ProjectCardArchivedState {
    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    ARCHIVED,
    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Deprecated(forRemoval = true)
    NOT_ARCHIVED
}
