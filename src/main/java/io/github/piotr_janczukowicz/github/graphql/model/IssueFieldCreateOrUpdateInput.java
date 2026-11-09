package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code IssueFieldCreateOrUpdateInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record IssueFieldCreateOrUpdateInput(
        @Nullable IssueEventConfidenceLevel confidence,
        @Nullable String dateValue,
        @Nullable Boolean delete,
        String fieldId,
        @Nullable List<String> multiSelectOptionIds,
        @Nullable Double numberValue,
        @Nullable String rationale,
        @Nullable String singleSelectOptionId,
        @Nullable Boolean suggest,
        @Nullable String textValue) {

    public IssueFieldCreateOrUpdateInput {
        requireNonNull(fieldId, "fieldId");
        multiSelectOptionIds = ListUtils.copyOrNull(multiSelectOptionIds);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.confidence != null) {
            variable.put("confidence", this.confidence.wireValue());
        }
        if (this.dateValue != null) {
            variable.put("dateValue", this.dateValue);
        }
        if (this.delete != null) {
            variable.put("delete", this.delete);
        }
        variable.put("fieldId", this.fieldId);
        if (this.multiSelectOptionIds != null) {
            variable.put("multiSelectOptionIds", this.multiSelectOptionIds);
        }
        if (this.numberValue != null) {
            variable.put("numberValue", this.numberValue);
        }
        if (this.rationale != null) {
            variable.put("rationale", this.rationale);
        }
        if (this.singleSelectOptionId != null) {
            variable.put("singleSelectOptionId", this.singleSelectOptionId);
        }
        if (this.suggest != null) {
            variable.put("suggest", this.suggest);
        }
        if (this.textValue != null) {
            variable.put("textValue", this.textValue);
        }
        return Collections.unmodifiableMap(variable);
    }
}
