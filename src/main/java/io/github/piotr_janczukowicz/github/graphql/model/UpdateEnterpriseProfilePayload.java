package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateEnterpriseProfileInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateEnterpriseProfilePayload(
        @Nullable String clientMutationId,
        @Nullable String description,
        String enterpriseId,
        @Nullable String location,
        @Nullable String name,
        @Nullable String securityContactEmail,
        @Nullable String websiteUrl) {

    public UpdateEnterpriseProfilePayload {
        requireNonNull(enterpriseId, "enterpriseId");
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
        variable.put("enterpriseId", this.enterpriseId);
        if (this.location != null) {
            variable.put("location", this.location);
        }
        if (this.name != null) {
            variable.put("name", this.name);
        }
        if (this.securityContactEmail != null) {
            variable.put("securityContactEmail", this.securityContactEmail);
        }
        if (this.websiteUrl != null) {
            variable.put("websiteUrl", this.websiteUrl);
        }
        return Collections.unmodifiableMap(variable);
    }
}
