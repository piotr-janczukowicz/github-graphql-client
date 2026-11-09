package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RequiredStatusChecksParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RequiredStatusChecksParametersInput(
        @Nullable Boolean doNotEnforceOnCreate,
        List<StatusCheckConfigurationInput> requiredStatusChecks,
        Boolean strictRequiredStatusChecksPolicy) {

    public RequiredStatusChecksParametersInput {
        requireNonNull(strictRequiredStatusChecksPolicy, "strictRequiredStatusChecksPolicy");
        requiredStatusChecks = ListUtils.copyOf(requiredStatusChecks, "requiredStatusChecks");
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
                "requiredStatusChecks",
                this.requiredStatusChecks.stream()
                        .map(StatusCheckConfigurationInput::toVariable)
                        .toList());
        variable.put("strictRequiredStatusChecksPolicy", this.strictRequiredStatusChecksPolicy);
        return Collections.unmodifiableMap(variable);
    }
}
