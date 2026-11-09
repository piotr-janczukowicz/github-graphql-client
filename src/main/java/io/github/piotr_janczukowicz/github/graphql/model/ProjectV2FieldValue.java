package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ProjectV2FieldValue}; a field left {@code null} is not sent. */
@RecordBuilder
public record ProjectV2FieldValue(
        @Nullable LocalDate date,
        @Nullable String iterationId,
        @Nullable List<String> multiSelectOptionIds,
        @Nullable Double number,
        @Nullable String singleSelectOptionId,
        @Nullable String text) {

    public ProjectV2FieldValue {
        multiSelectOptionIds = ListUtils.copyOrNull(multiSelectOptionIds);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.date != null) {
            variable.put("date", this.date.toString());
        }
        if (this.iterationId != null) {
            variable.put("iterationId", this.iterationId);
        }
        if (this.multiSelectOptionIds != null) {
            variable.put("multiSelectOptionIds", this.multiSelectOptionIds);
        }
        if (this.number != null) {
            variable.put("number", this.number);
        }
        if (this.singleSelectOptionId != null) {
            variable.put("singleSelectOptionId", this.singleSelectOptionId);
        }
        if (this.text != null) {
            variable.put("text", this.text);
        }
        return Collections.unmodifiableMap(variable);
    }
}
