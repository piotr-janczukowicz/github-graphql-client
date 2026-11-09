package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ImportProjectInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record ImportProjectPayload(
        @Nullable String body,
        @Nullable String clientMutationId,
        List<ProjectColumnImport> columnImports,
        String name,
        String ownerName,
        @Nullable Boolean publicValue) {

    public ImportProjectPayload {
        requireNonNull(name, "name");
        requireNonNull(ownerName, "ownerName");
        columnImports = ListUtils.copyOf(columnImports, "columnImports");
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
        variable.put(
                "columnImports",
                this.columnImports.stream().map(ProjectColumnImport::toVariable).toList());
        variable.put("name", this.name);
        variable.put("ownerName", this.ownerName);
        if (this.publicValue != null) {
            variable.put("public", this.publicValue);
        }
        return Collections.unmodifiableMap(variable);
    }
}
