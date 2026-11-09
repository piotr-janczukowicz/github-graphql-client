package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code AddLabelsToLabelableInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record AddLabelsToLabelablePayload(
        @Nullable String clientMutationId,
        @Nullable List<String> labelIds,
        String labelableId,
        @Nullable List<LabelUpdateInput> labels) {

    public AddLabelsToLabelablePayload {
        requireNonNull(labelableId, "labelableId");
        labelIds = ListUtils.copyOrNull(labelIds);
        labels = ListUtils.copyOrNull(labels);
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
        if (this.labelIds != null) {
            variable.put("labelIds", this.labelIds);
        }
        variable.put("labelableId", this.labelableId);
        if (this.labels != null) {
            variable.put(
                    "labels",
                    this.labels.stream().map(LabelUpdateInput::toVariable).toList());
        }
        return Collections.unmodifiableMap(variable);
    }
}
