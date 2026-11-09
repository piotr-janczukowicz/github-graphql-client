package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateIpAllowListEntryInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateIpAllowListEntryPayload(
        String allowListValue,
        @Nullable String clientMutationId,
        Boolean isActive,
        @Nullable String name,
        String ownerId) {

    public CreateIpAllowListEntryPayload {
        requireNonNull(allowListValue, "allowListValue");
        requireNonNull(isActive, "isActive");
        requireNonNull(ownerId, "ownerId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("allowListValue", this.allowListValue);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("isActive", this.isActive);
        if (this.name != null) {
            variable.put("name", this.name);
        }
        variable.put("ownerId", this.ownerId);
        return Collections.unmodifiableMap(variable);
    }
}
