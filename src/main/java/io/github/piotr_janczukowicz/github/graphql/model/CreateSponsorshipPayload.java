package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateSponsorshipInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateSponsorshipPayload(
        @Nullable Integer amount,
        @Nullable String clientMutationId,
        @Nullable Boolean isRecurring,
        @Nullable SponsorshipPrivacy privacyLevel,
        @Nullable Boolean receiveEmails,
        @Nullable String sponsorId,
        @Nullable String sponsorLogin,
        @Nullable String sponsorableId,
        @Nullable String sponsorableLogin,
        @Nullable String tierId) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.amount != null) {
            variable.put("amount", this.amount);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.isRecurring != null) {
            variable.put("isRecurring", this.isRecurring);
        }
        if (this.privacyLevel != null) {
            variable.put("privacyLevel", this.privacyLevel.wireValue());
        }
        if (this.receiveEmails != null) {
            variable.put("receiveEmails", this.receiveEmails);
        }
        if (this.sponsorId != null) {
            variable.put("sponsorId", this.sponsorId);
        }
        if (this.sponsorLogin != null) {
            variable.put("sponsorLogin", this.sponsorLogin);
        }
        if (this.sponsorableId != null) {
            variable.put("sponsorableId", this.sponsorableId);
        }
        if (this.sponsorableLogin != null) {
            variable.put("sponsorableLogin", this.sponsorableLogin);
        }
        if (this.tierId != null) {
            variable.put("tierId", this.tierId);
        }
        return Collections.unmodifiableMap(variable);
    }
}
