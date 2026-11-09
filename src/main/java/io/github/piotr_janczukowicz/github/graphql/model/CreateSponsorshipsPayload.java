package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateSponsorshipsInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateSponsorshipsPayload(
        @Nullable String clientMutationId,
        @Nullable SponsorshipPrivacy privacyLevel,
        @Nullable Boolean receiveEmails,
        @Nullable Boolean recurring,
        String sponsorLogin,
        List<BulkSponsorship> sponsorships) {

    public CreateSponsorshipsPayload {
        requireNonNull(sponsorLogin, "sponsorLogin");
        sponsorships = ListUtils.copyOf(sponsorships, "sponsorships");
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
        if (this.privacyLevel != null) {
            variable.put("privacyLevel", this.privacyLevel.wireValue());
        }
        if (this.receiveEmails != null) {
            variable.put("receiveEmails", this.receiveEmails);
        }
        if (this.recurring != null) {
            variable.put("recurring", this.recurring);
        }
        variable.put("sponsorLogin", this.sponsorLogin);
        variable.put(
                "sponsorships",
                this.sponsorships.stream().map(BulkSponsorship::toVariable).toList());
        return Collections.unmodifiableMap(variable);
    }
}
