package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateRepositoryInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateRepositoryPayload(
        @Nullable String clientMutationId,
        @Nullable String description,
        @Nullable Boolean hasDiscussionsEnabled,
        @Nullable Boolean hasIssuesEnabled,
        @Nullable Boolean hasProjectsEnabled,
        @Nullable Boolean hasPullRequestsEnabled,
        @Nullable Boolean hasSponsorshipsEnabled,
        @Nullable Boolean hasWikiEnabled,
        @Nullable String homepageUrl,
        @Nullable IssueCreationPolicy issueCreationPolicy,
        @Nullable String name,
        @Nullable PullRequestCreationPolicy pullRequestCreationPolicy,
        String repositoryId,
        @Nullable Boolean template) {

    public UpdateRepositoryPayload {
        requireNonNull(repositoryId, "repositoryId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.description != null) {
            variable.put("description", this.description);
        }
        if (this.hasDiscussionsEnabled != null) {
            variable.put("hasDiscussionsEnabled", this.hasDiscussionsEnabled);
        }
        if (this.hasIssuesEnabled != null) {
            variable.put("hasIssuesEnabled", this.hasIssuesEnabled);
        }
        if (this.hasProjectsEnabled != null) {
            variable.put("hasProjectsEnabled", this.hasProjectsEnabled);
        }
        if (this.hasPullRequestsEnabled != null) {
            variable.put("hasPullRequestsEnabled", this.hasPullRequestsEnabled);
        }
        if (this.hasSponsorshipsEnabled != null) {
            variable.put("hasSponsorshipsEnabled", this.hasSponsorshipsEnabled);
        }
        if (this.hasWikiEnabled != null) {
            variable.put("hasWikiEnabled", this.hasWikiEnabled);
        }
        if (this.homepageUrl != null) {
            variable.put("homepageUrl", this.homepageUrl);
        }
        if (this.issueCreationPolicy != null) {
            variable.put("issueCreationPolicy", this.issueCreationPolicy.wireValue());
        }
        if (this.name != null) {
            variable.put("name", this.name);
        }
        if (this.pullRequestCreationPolicy != null) {
            variable.put("pullRequestCreationPolicy", this.pullRequestCreationPolicy.wireValue());
        }
        variable.put("repositoryId", this.repositoryId);
        if (this.template != null) {
            variable.put("template", this.template);
        }
        return Collections.unmodifiableMap(variable);
    }
}
