package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code StartRepositoryMigrationInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record StartRepositoryMigrationPayload(
        @Nullable String accessToken,
        @Nullable String clientMutationId,
        @Nullable Boolean continueOnError,
        @Nullable String gitArchiveUrl,
        @Nullable String githubPat,
        @Nullable Boolean lockSource,
        @Nullable String metadataArchiveUrl,
        String ownerId,
        String repositoryName,
        @Nullable Boolean skipReleases,
        String sourceId,
        String sourceRepositoryUrl,
        @Nullable String targetRepoVisibility) {

    public StartRepositoryMigrationPayload {
        requireNonNull(ownerId, "ownerId");
        requireNonNull(repositoryName, "repositoryName");
        requireNonNull(sourceId, "sourceId");
        requireNonNull(sourceRepositoryUrl, "sourceRepositoryUrl");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.accessToken != null) {
            variable.put("accessToken", this.accessToken);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.continueOnError != null) {
            variable.put("continueOnError", this.continueOnError);
        }
        if (this.gitArchiveUrl != null) {
            variable.put("gitArchiveUrl", this.gitArchiveUrl);
        }
        if (this.githubPat != null) {
            variable.put("githubPat", this.githubPat);
        }
        if (this.lockSource != null) {
            variable.put("lockSource", this.lockSource);
        }
        if (this.metadataArchiveUrl != null) {
            variable.put("metadataArchiveUrl", this.metadataArchiveUrl);
        }
        variable.put("ownerId", this.ownerId);
        variable.put("repositoryName", this.repositoryName);
        if (this.skipReleases != null) {
            variable.put("skipReleases", this.skipReleases);
        }
        variable.put("sourceId", this.sourceId);
        variable.put("sourceRepositoryUrl", this.sourceRepositoryUrl);
        if (this.targetRepoVisibility != null) {
            variable.put("targetRepoVisibility", this.targetRepoVisibility);
        }
        return Collections.unmodifiableMap(variable);
    }
}
