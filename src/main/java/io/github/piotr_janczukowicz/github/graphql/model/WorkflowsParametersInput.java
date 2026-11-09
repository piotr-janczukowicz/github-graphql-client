package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code WorkflowsParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record WorkflowsParametersInput(
        @Nullable Boolean doNotEnforceOnCreate, List<WorkflowFileReferenceInput> workflows) {

    public WorkflowsParametersInput {
        workflows = ListUtils.copyOf(workflows, "workflows");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.doNotEnforceOnCreate != null) {
            variable.put("doNotEnforceOnCreate", this.doNotEnforceOnCreate);
        }
        variable.put(
                "workflows",
                this.workflows.stream()
                        .map(WorkflowFileReferenceInput::toVariable)
                        .toList());
        return Collections.unmodifiableMap(variable);
    }
}
