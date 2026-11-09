package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateRepositoryInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateRepositoryPayload(
        @Nullable String clientMutationId,
        @Nullable String description,
        @Nullable Boolean hasIssuesEnabled,
        @Nullable Boolean hasWikiEnabled,
        @Nullable String homepageUrl,
        String name,
        @Nullable String ownerId,
        @Nullable String teamId,
        @Nullable Boolean template,
        RepositoryVisibility visibility) {

    public CreateRepositoryPayload {
        requireNonNull(name, "name");
        requireNonNull(visibility, "visibility");
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
        if (this.hasIssuesEnabled != null) {
            variable.put("hasIssuesEnabled", this.hasIssuesEnabled);
        }
        if (this.hasWikiEnabled != null) {
            variable.put("hasWikiEnabled", this.hasWikiEnabled);
        }
        if (this.homepageUrl != null) {
            variable.put("homepageUrl", this.homepageUrl);
        }
        variable.put("name", this.name);
        if (this.ownerId != null) {
            variable.put("ownerId", this.ownerId);
        }
        if (this.teamId != null) {
            variable.put("teamId", this.teamId);
        }
        if (this.template != null) {
            variable.put("template", this.template);
        }
        variable.put("visibility", this.visibility.wireValue());
        return Collections.unmodifiableMap(variable);
    }
}
