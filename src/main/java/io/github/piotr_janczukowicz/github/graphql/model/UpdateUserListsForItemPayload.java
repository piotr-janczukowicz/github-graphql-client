package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateUserListsForItemInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateUserListsForItemPayload(
        @Nullable String clientMutationId,
        String itemId,
        List<String> listIds,
        @Nullable List<String> suggestedListIds) {

    public UpdateUserListsForItemPayload {
        requireNonNull(itemId, "itemId");
        listIds = ListUtils.copyOf(listIds, "listIds");
        suggestedListIds = ListUtils.copyOrNull(suggestedListIds);
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
        variable.put("itemId", this.itemId);
        variable.put("listIds", this.listIds);
        if (this.suggestedListIds != null) {
            variable.put("suggestedListIds", this.suggestedListIds);
        }
        return Collections.unmodifiableMap(variable);
    }
}
