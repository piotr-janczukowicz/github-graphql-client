package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code InviteEnterpriseMemberInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record InviteEnterpriseMemberPayload(
        @Nullable String clientMutationId,
        @Nullable String email,
        String enterpriseId,
        @Nullable String invitee) {

    public InviteEnterpriseMemberPayload {
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
        if (this.email != null) {
            variable.put("email", this.email);
        }
        variable.put("enterpriseId", this.enterpriseId);
        if (this.invitee != null) {
            variable.put("invitee", this.invitee);
        }
        return Collections.unmodifiableMap(variable);
    }
}
