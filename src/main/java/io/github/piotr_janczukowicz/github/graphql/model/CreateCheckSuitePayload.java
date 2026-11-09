package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateCheckSuiteInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateCheckSuitePayload(@Nullable String clientMutationId, String headSha, String repositoryId) {

    public CreateCheckSuitePayload {
        requireNonNull(headSha, "headSha");
        requireNonNull(repositoryId, "repositoryId");
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
        variable.put("headSha", this.headSha);
        variable.put("repositoryId", this.repositoryId);
        return Collections.unmodifiableMap(variable);
    }
}
