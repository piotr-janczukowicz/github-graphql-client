package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ProjectV2ViewConfigurationInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record ProjectV2ViewConfigurationInput(@Nullable List<String> visibleFieldIds) {

    public ProjectV2ViewConfigurationInput {
        visibleFieldIds = ListUtils.copyOrNull(visibleFieldIds);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.visibleFieldIds != null) {
            variable.put("visibleFieldIds", this.visibleFieldIds);
        }
        return Collections.unmodifiableMap(variable);
    }
}
