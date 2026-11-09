package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateSponsorsListingInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateSponsorsListingPayload(
        @Nullable SponsorsCountryOrRegionCode billingCountryOrRegionCode,
        @Nullable String clientMutationId,
        @Nullable String contactEmail,
        @Nullable String fiscalHostLogin,
        @Nullable String fiscallyHostedProjectProfileUrl,
        @Nullable String fullDescription,
        @Nullable SponsorsCountryOrRegionCode residenceCountryOrRegionCode,
        @Nullable String sponsorableLogin) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.billingCountryOrRegionCode != null) {
            variable.put("billingCountryOrRegionCode", this.billingCountryOrRegionCode.name());
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.contactEmail != null) {
            variable.put("contactEmail", this.contactEmail);
        }
        if (this.fiscalHostLogin != null) {
            variable.put("fiscalHostLogin", this.fiscalHostLogin);
        }
        if (this.fiscallyHostedProjectProfileUrl != null) {
            variable.put("fiscallyHostedProjectProfileUrl", this.fiscallyHostedProjectProfileUrl);
        }
        if (this.fullDescription != null) {
            variable.put("fullDescription", this.fullDescription);
        }
        if (this.residenceCountryOrRegionCode != null) {
            variable.put("residenceCountryOrRegionCode", this.residenceCountryOrRegionCode.name());
        }
        if (this.sponsorableLogin != null) {
            variable.put("sponsorableLogin", this.sponsorableLogin);
        }
        return Collections.unmodifiableMap(variable);
    }
}
