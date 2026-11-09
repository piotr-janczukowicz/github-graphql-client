package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.json.OptionalNull;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code MoveProjectCardInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record MoveProjectCardPayload(
        @Nullable OptionalNull<String> afterCardId,
        String cardId,
        @Nullable String clientMutationId,
        String columnId) {

    public MoveProjectCardPayload {
        requireNonNull(cardId, "cardId");
        requireNonNull(columnId, "columnId");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, @Nullable Object> toVariable() {
        final Map<String, @Nullable Object> variable = new LinkedHashMap<>();
        if (this.afterCardId != null) {
            variable.put("afterCardId", this.afterCardId.value());
        }
        variable.put("cardId", this.cardId);
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("columnId", this.columnId);
        return Collections.unmodifiableMap(variable);
    }
}
