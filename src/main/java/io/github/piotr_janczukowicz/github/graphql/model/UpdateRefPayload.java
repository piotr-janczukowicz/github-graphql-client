package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateRefInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateRefPayload(
        @Nullable String clientMutationId, @Nullable Boolean force, String oid, String refId) {

    public UpdateRefPayload {
        requireNonNull(oid, "oid");
        requireNonNull(refId, "refId");
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
        if (this.force != null) {
            variable.put("force", this.force);
        }
        variable.put("oid", this.oid);
        variable.put("refId", this.refId);
        return Collections.unmodifiableMap(variable);
    }
}
