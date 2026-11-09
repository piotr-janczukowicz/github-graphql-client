package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryInfo}. */
public interface RepositoryInfoSelector {

    @Nullable Instant archivedAt();

    Instant createdAt();

    @Nullable String description();

    String descriptionHTML();

    int forkCount();

    boolean hasDiscussionsEnabled();

    boolean hasIssuesEnabled();

    boolean hasProjectsEnabled();

    boolean hasPullRequestsEnabled();

    boolean hasSponsorshipsEnabled();

    boolean hasWikiEnabled();

    @Nullable String homepageUrl();

    boolean isArchived();

    boolean isFork();

    boolean isInOrganization();

    boolean isLocked();

    boolean isMirror();

    boolean isPrivate();

    boolean isTemplate();

    @Nullable IssueCreationPolicy issueCreationPolicy();

    <R> @Nullable R licenseInfo(Function<LicenseSelector, R> selection);

    @Nullable RepositoryLockReason lockReason();

    @Nullable String mirrorUrl();

    String name();

    String nameWithOwner();

    String openGraphImageUrl();

    <R> R owner(Function<RepositoryOwnerSelector, R> selection);

    @Nullable PullRequestCreationPolicy pullRequestCreationPolicy();

    @Nullable Instant pushedAt();

    String resourcePath();

    String shortDescriptionHTML(RepositoryInfoShortDescriptionHTMLFilter arguments);

    String shortDescriptionHTML();

    Instant updatedAt();

    String url();

    boolean usesCustomOpenGraphImage();

    RepositoryVisibility visibility();

    <S, R> @Nullable R on(Class<S> type, Function<S, R> selection);
}
