package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateIpAllowListEntryInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateIpAllowListEntryPayload(
        String allowListValue,
        @Nullable String clientMutationId,
        String ipAllowListEntryId,
        Boolean isActive,
        @Nullable String name) {

    public UpdateIpAllowListEntryPayload {
        requireNonNull(allowListValue, "allowListValue");
        requireNonNull(ipAllowListEntryId, "ipAllowListEntryId");
        requireNonNull(isActive, "isActive");
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
        variable.put("ipAllowListEntryId", this.ipAllowListEntryId);
        variable.put("isActive", this.isActive);
        if (this.name != null) {
            variable.put("name", this.name);
        }
        return Collections.unmodifiableMap(variable);
    }
}
