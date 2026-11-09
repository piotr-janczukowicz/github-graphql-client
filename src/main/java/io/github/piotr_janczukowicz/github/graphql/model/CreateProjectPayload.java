package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateProjectInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateProjectPayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        String name,
        String ownerId,
        @Nullable List<String> repositoryIds,
        @Nullable ProjectTemplate template) {

    public CreateProjectPayload {
        requireNonNull(name, "name");
        requireNonNull(ownerId, "ownerId");
        repositoryIds = ListUtils.copyOrNull(repositoryIds);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.body != null) {
            variable.put("body", this.body);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("name", this.name);
        variable.put("ownerId", this.ownerId);
        if (this.repositoryIds != null) {
            variable.put("repositoryIds", this.repositoryIds);
        }
        if (this.template != null) {
            variable.put("template", this.template.name());
        }
        return Collections.unmodifiableMap(variable);
    }
}
