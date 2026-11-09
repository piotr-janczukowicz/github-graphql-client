package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The GraphQL input object {@code ProjectV2IterationFieldConfigurationInput}; a field left {@code null} is not sent.
 */
@RecordBuilder
public record ProjectV2IterationFieldConfigurationInput(
        Integer duration, List<ProjectV2Iteration> iterations, LocalDate startDate) {

    public ProjectV2IterationFieldConfigurationInput {
        requireNonNull(duration, "duration");
        requireNonNull(startDate, "startDate");
        iterations = ListUtils.copyOf(iterations, "iterations");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("duration", this.duration);
        variable.put(
                "iterations",
                this.iterations.stream().map(ProjectV2Iteration::toVariable).toList());
        variable.put("startDate", this.startDate.toString());
        return Collections.unmodifiableMap(variable);
    }
}
