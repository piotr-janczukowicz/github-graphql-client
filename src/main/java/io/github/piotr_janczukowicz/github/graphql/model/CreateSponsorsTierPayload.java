package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateSponsorsTierInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateSponsorsTierPayload(
        Integer amount,
        @Nullable String clientMutationId,
        String description,
        @Nullable Boolean isRecurring,
        @Nullable Boolean publish,
        @Nullable String repositoryId,
        @Nullable String repositoryName,
        @Nullable String repositoryOwnerLogin,
        @Nullable String sponsorableId,
        @Nullable String sponsorableLogin,
        @Nullable String welcomeMessage) {

    public CreateSponsorsTierPayload {
        requireNonNull(amount, "amount");
        requireNonNull(description, "description");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("amount", this.amount);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("description", this.description);
        if (this.isRecurring != null) {
            variable.put("isRecurring", this.isRecurring);
        }
        if (this.publish != null) {
            variable.put("publish", this.publish);
        }
        if (this.repositoryId != null) {
            variable.put("repositoryId", this.repositoryId);
        }
        if (this.repositoryName != null) {
            variable.put("repositoryName", this.repositoryName);
        }
        if (this.repositoryOwnerLogin != null) {
            variable.put("repositoryOwnerLogin", this.repositoryOwnerLogin);
        }
        if (this.sponsorableId != null) {
            variable.put("sponsorableId", this.sponsorableId);
        }
        if (this.sponsorableLogin != null) {
            variable.put("sponsorableLogin", this.sponsorableLogin);
        }
        if (this.welcomeMessage != null) {
            variable.put("welcomeMessage", this.welcomeMessage);
        }
        return Collections.unmodifiableMap(variable);
    }
}
