package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateIssueFieldInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateIssueFieldPayload(
        @Nullable String clientMutationId,
        IssueFieldDataType dataType,
        @Nullable String description,
        String name,
        @Nullable List<IssueFieldSingleSelectOptionInput> options,
        String ownerId,
        @Nullable IssueFieldVisibility visibility) {

    public CreateIssueFieldPayload {
        requireNonNull(dataType, "dataType");
        requireNonNull(name, "name");
        requireNonNull(ownerId, "ownerId");
        options = ListUtils.copyOrNull(options);
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
        variable.put("dataType", this.dataType.wireValue());
        if (this.description != null) {
            variable.put("description", this.description);
        }
        variable.put("name", this.name);
        if (this.options != null) {
            variable.put(
                    "options",
                    this.options.stream()
                            .map(IssueFieldSingleSelectOptionInput::toVariable)
                            .toList());
        }
        variable.put("ownerId", this.ownerId);
        if (this.visibility != null) {
            variable.put("visibility", this.visibility.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
