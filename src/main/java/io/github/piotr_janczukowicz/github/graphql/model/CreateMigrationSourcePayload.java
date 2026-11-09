package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateMigrationSourceInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateMigrationSourcePayload(
        @Nullable String accessToken,
        @Nullable String clientMutationId,
        @Nullable String githubPat,
        String name,
        String ownerId,
        MigrationSourceType type,
        @Nullable String url) {

    public CreateMigrationSourcePayload {
        requireNonNull(name, "name");
        requireNonNull(ownerId, "ownerId");
        requireNonNull(type, "type");
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
        if (this.githubPat != null) {
            variable.put("githubPat", this.githubPat);
        }
        variable.put("name", this.name);
        variable.put("ownerId", this.ownerId);
        variable.put("type", this.type.wireValue());
        if (this.url != null) {
            variable.put("url", this.url);
        }
        return Collections.unmodifiableMap(variable);
    }
}
