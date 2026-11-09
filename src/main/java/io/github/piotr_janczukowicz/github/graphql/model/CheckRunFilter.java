package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CheckRunFilter}; a field left {@code null} is not sent. */
@RecordBuilder
public record CheckRunFilter(
        @Nullable Integer appId,
        @Nullable String checkName,
        @Nullable CheckRunType checkType,
        @Nullable List<CheckConclusionState> conclusions,
        @Nullable CheckStatusState status,
        @Nullable List<CheckStatusState> statuses) {

    public CheckRunFilter {
        conclusions = ListUtils.copyOrNull(conclusions);
        statuses = ListUtils.copyOrNull(statuses);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.appId != null) {
            variable.put("appId", this.appId);
        }
        if (this.checkName != null) {
            variable.put("checkName", this.checkName);
        }
        if (this.checkType != null) {
            variable.put("checkType", this.checkType.name());
        }
        if (this.conclusions != null) {
            variable.put(
                    "conclusions",
                    this.conclusions.stream()
                            .map(CheckConclusionState::wireValue)
                            .toList());
        }
        if (this.status != null) {
            variable.put("status", this.status.wireValue());
        }
        if (this.statuses != null) {
            variable.put(
                    "statuses",
                    this.statuses.stream().map(CheckStatusState::wireValue).toList());
        }
        return Collections.unmodifiableMap(variable);
    }
}
