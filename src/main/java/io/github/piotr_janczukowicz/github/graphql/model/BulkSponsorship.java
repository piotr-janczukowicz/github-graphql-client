package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code BulkSponsorship}; a field left {@code null} is not sent. */
@RecordBuilder
public record BulkSponsorship(
        Integer amount,
        @Nullable String sponsorableId,
        @Nullable String sponsorableLogin) {

    public BulkSponsorship {
        requireNonNull(amount, "amount");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("amount", this.amount);
        if (this.sponsorableId != null) {
            variable.put("sponsorableId", this.sponsorableId);
        }
        if (this.sponsorableLogin != null) {
            variable.put("sponsorableLogin", this.sponsorableLogin);
        }
        return Collections.unmodifiableMap(variable);
    }
}
