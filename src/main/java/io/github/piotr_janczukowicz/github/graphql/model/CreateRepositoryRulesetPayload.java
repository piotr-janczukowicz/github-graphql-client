package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateRepositoryRulesetInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateRepositoryRulesetPayload(
        @Nullable List<RepositoryRulesetBypassActorInput> bypassActors,
        @Nullable String clientMutationId,
        RepositoryRuleConditionsInput conditions,
        RuleEnforcement enforcement,
        String name,
        @Nullable List<RepositoryRuleInput> rules,
        String sourceId,
        @Nullable RepositoryRulesetTarget target) {

    public CreateRepositoryRulesetPayload {
        requireNonNull(conditions, "conditions");
        requireNonNull(enforcement, "enforcement");
        requireNonNull(name, "name");
        requireNonNull(sourceId, "sourceId");
        bypassActors = ListUtils.copyOrNull(bypassActors);
        rules = ListUtils.copyOrNull(rules);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.bypassActors != null) {
            variable.put(
                    "bypassActors",
                    this.bypassActors.stream()
                            .map(RepositoryRulesetBypassActorInput::toVariable)
                            .toList());
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("conditions", this.conditions.toVariable());
        variable.put("enforcement", this.enforcement.wireValue());
        variable.put("name", this.name);
        if (this.rules != null) {
            variable.put(
                    "rules",
                    this.rules.stream().map(RepositoryRuleInput::toVariable).toList());
        }
        variable.put("sourceId", this.sourceId);
        if (this.target != null) {
            variable.put("target", this.target.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
