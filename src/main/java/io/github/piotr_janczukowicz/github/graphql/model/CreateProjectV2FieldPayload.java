package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateProjectV2FieldInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateProjectV2FieldPayload(
        @Nullable String clientMutationId,
        ProjectV2CustomFieldType dataType,
        @Nullable ProjectV2IterationFieldConfigurationInput iterationConfiguration,
        @Nullable List<ProjectV2MultiSelectFieldOptionInput> multiSelectOptions,
        String name,
        String projectId,
        @Nullable List<ProjectV2SingleSelectFieldOptionInput> singleSelectOptions) {

    public CreateProjectV2FieldPayload {
        requireNonNull(dataType, "dataType");
        requireNonNull(name, "name");
        requireNonNull(projectId, "projectId");
        multiSelectOptions = ListUtils.copyOrNull(multiSelectOptions);
        singleSelectOptions = ListUtils.copyOrNull(singleSelectOptions);
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
        variable.put("dataType", this.dataType.name());
        if (this.iterationConfiguration != null) {
            variable.put("iterationConfiguration", this.iterationConfiguration.toVariable());
        }
        if (this.multiSelectOptions != null) {
            variable.put(
                    "multiSelectOptions",
                    this.multiSelectOptions.stream()
                            .map(ProjectV2MultiSelectFieldOptionInput::toVariable)
                            .toList());
        }
        variable.put("name", this.name);
        variable.put("projectId", this.projectId);
        if (this.singleSelectOptions != null) {
            variable.put(
                    "singleSelectOptions",
                    this.singleSelectOptions.stream()
                            .map(ProjectV2SingleSelectFieldOptionInput::toVariable)
                            .toList());
        }
        return Collections.unmodifiableMap(variable);
    }
}
