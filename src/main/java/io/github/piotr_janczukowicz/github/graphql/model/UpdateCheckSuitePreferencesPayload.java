package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateCheckSuitePreferencesInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateCheckSuitePreferencesPayload(
        List<CheckSuiteAutoTriggerPreference> autoTriggerPreferences,
        @Nullable String clientMutationId,
        String repositoryId) {

    public UpdateCheckSuitePreferencesPayload {
        requireNonNull(repositoryId, "repositoryId");
        autoTriggerPreferences = ListUtils.copyOf(autoTriggerPreferences, "autoTriggerPreferences");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put(
                "autoTriggerPreferences",
                this.autoTriggerPreferences.stream()
                        .map(CheckSuiteAutoTriggerPreference::toVariable)
                        .toList());
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("repositoryId", this.repositoryId);
        return Collections.unmodifiableMap(variable);
    }
}
