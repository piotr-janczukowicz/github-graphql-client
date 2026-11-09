package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.model.IssueCreationPolicy;
import io.github.piotr_janczukowicz.github.graphql.model.LicenseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCreationPolicy;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInfoShortDescriptionHTMLFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInfoShortDescriptionHTMLFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLockReason;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryInfo}; used by the generated selection code only. */
final class RepositoryInfoSelectorImpl implements RepositoryInfoSelector {

    private final Cursor cursor;

    RepositoryInfoSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Instant archivedAt() {
        return cursor.get("archivedAt", ScalarType.INSTANT);
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
    public String descriptionHTML() {
        return cursor.getRequired("descriptionHTML", ScalarType.STRING);
    }

    @Override
    public int forkCount() {
        return cursor.getRequired("forkCount", ScalarType.INT);
    }

    @Override
    public boolean hasDiscussionsEnabled() {
        return cursor.getRequired("hasDiscussionsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasIssuesEnabled() {
        return cursor.getRequired("hasIssuesEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasProjectsEnabled() {
        return cursor.getRequired("hasProjectsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasPullRequestsEnabled() {
        return cursor.getRequired("hasPullRequestsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasSponsorshipsEnabled() {
        return cursor.getRequired("hasSponsorshipsEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasWikiEnabled() {
        return cursor.getRequired("hasWikiEnabled", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String homepageUrl() {
        return cursor.get("homepageUrl", ScalarType.STRING);
    }

    @Override
    public boolean isArchived() {
        return cursor.getRequired("isArchived", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isFork() {
        return cursor.getRequired("isFork", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isInOrganization() {
        return cursor.getRequired("isInOrganization", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isLocked() {
        return cursor.getRequired("isLocked", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isMirror() {
        return cursor.getRequired("isMirror", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isPrivate() {
        return cursor.getRequired("isPrivate", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isTemplate() {
        return cursor.getRequired("isTemplate", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable IssueCreationPolicy issueCreationPolicy() {
        return cursor.get(
                "issueCreationPolicy", ScalarType.enumeration(IssueCreationPolicy::fromWire, IssueCreationPolicy.ALL));
    }

    @Override
    public <R> @Nullable R licenseInfo(final Function<LicenseSelector, R> selection) {
        return cursor.object("licenseInfo", child -> selection.apply(new LicenseSelectorImpl(child)));
    }

    @Override
    public @Nullable RepositoryLockReason lockReason() {
        return cursor.get(
                "lockReason", ScalarType.enumeration(RepositoryLockReason::fromWire, RepositoryLockReason.BILLING));
    }

    @Override
    public @Nullable String mirrorUrl() {
        return cursor.get("mirrorUrl", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String nameWithOwner() {
        return cursor.getRequired("nameWithOwner", ScalarType.STRING);
    }

    @Override
    public String openGraphImageUrl() {
        return cursor.getRequired("openGraphImageUrl", ScalarType.STRING);
    }

    @Override
    public <R> R owner(final Function<RepositoryOwnerSelector, R> selection) {
        return cursor.objectRequired("owner", child -> selection.apply(new RepositoryOwnerSelectorImpl(child)));
    }

    @Override
    public @Nullable PullRequestCreationPolicy pullRequestCreationPolicy() {
        return cursor.get(
                "pullRequestCreationPolicy",
                ScalarType.enumeration(PullRequestCreationPolicy::fromWire, PullRequestCreationPolicy.ALL));
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
    public String shortDescriptionHTML(final RepositoryInfoShortDescriptionHTMLFilter arguments) {
        requireNonNull(arguments, "arguments");
        return cursor.getRequired(
                "shortDescriptionHTML", ScalarType.STRING, Argument.of("limit", "Int", arguments.limit()));
    }

    @Override
    public String shortDescriptionHTML() {
        return shortDescriptionHTML(
                RepositoryInfoShortDescriptionHTMLFilterBuilder.builder().build());
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
    public boolean usesCustomOpenGraphImage() {
        return cursor.getRequired("usesCustomOpenGraphImage", ScalarType.BOOLEAN);
    }

    @Override
    public RepositoryVisibility visibility() {
        return cursor.getRequired(
                "visibility", ScalarType.enumeration(RepositoryVisibility::fromWire, RepositoryVisibility.INTERNAL));
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, RepositoryInfoSelector.class, type, selection);
    }
}
