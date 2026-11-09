package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ApplyPendingIssueSuggestionsInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record ApplyPendingIssueSuggestionsPayload(
        String actorId,
        @Nullable String clientMutationId,
        String issueId,
        List<PendingIssueSuggestionRef> suggestions) {

    public ApplyPendingIssueSuggestionsPayload {
        requireNonNull(actorId, "actorId");
        requireNonNull(issueId, "issueId");
        suggestions = ListUtils.copyOf(suggestions, "suggestions");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("actorId", this.actorId);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("issueId", this.issueId);
        variable.put(
                "suggestions",
                this.suggestions.stream()
                        .map(PendingIssueSuggestionRef::toVariable)
                        .toList());
        return Collections.unmodifiableMap(variable);
    }
}
