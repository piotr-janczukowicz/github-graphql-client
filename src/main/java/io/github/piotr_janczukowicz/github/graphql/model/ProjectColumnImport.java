package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ProjectColumnImport}; a field left {@code null} is not sent. */
@RecordBuilder
public record ProjectColumnImport(
        String columnName, @Nullable List<ProjectCardImport> issues, Integer position) {

    public ProjectColumnImport {
        requireNonNull(columnName, "columnName");
        requireNonNull(position, "position");
        issues = ListUtils.copyOrNull(issues);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("columnName", this.columnName);
        if (this.issues != null) {
            variable.put(
                    "issues",
                    this.issues.stream().map(ProjectCardImport::toVariable).toList());
        }
        variable.put("position", this.position);
        return Collections.unmodifiableMap(variable);
    }
}
