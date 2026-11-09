package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code IssueFieldValueFilter}; a field left {@code null} is not sent. */
@RecordBuilder
public record IssueFieldValueFilter(
        @Nullable String dateValue,
        @Nullable String fieldId,
        @Nullable String fieldName,
        @Nullable List<String> multiSelectOptionIds,
        @Nullable List<String> multiSelectOptionValues,
        @Nullable Double numberValue,
        @Nullable String singleSelectOptionId,
        @Nullable String singleSelectOptionValue,
        @Nullable String textValue) {

    public IssueFieldValueFilter {
        multiSelectOptionIds = ListUtils.copyOrNull(multiSelectOptionIds);
        multiSelectOptionValues = ListUtils.copyOrNull(multiSelectOptionValues);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.dateValue != null) {
            variable.put("dateValue", this.dateValue);
        }
        if (this.fieldId != null) {
            variable.put("fieldId", this.fieldId);
        }
        if (this.fieldName != null) {
            variable.put("fieldName", this.fieldName);
        }
        if (this.multiSelectOptionIds != null) {
            variable.put("multiSelectOptionIds", this.multiSelectOptionIds);
        }
        if (this.multiSelectOptionValues != null) {
            variable.put("multiSelectOptionValues", this.multiSelectOptionValues);
        }
        if (this.numberValue != null) {
            variable.put("numberValue", this.numberValue);
        }
        if (this.singleSelectOptionId != null) {
            variable.put("singleSelectOptionId", this.singleSelectOptionId);
        }
        if (this.singleSelectOptionValue != null) {
            variable.put("singleSelectOptionValue", this.singleSelectOptionValue);
        }
        if (this.textValue != null) {
            variable.put("textValue", this.textValue);
        }
        return Collections.unmodifiableMap(variable);
    }
}
