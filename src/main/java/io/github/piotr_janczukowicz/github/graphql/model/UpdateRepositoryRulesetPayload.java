package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateRepositoryRulesetInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateRepositoryRulesetPayload(
        @Nullable List<RepositoryRulesetBypassActorInput> bypassActors,
        @Nullable String clientMutationId,
        @Nullable RepositoryRuleConditionsInput conditions,
        @Nullable RuleEnforcement enforcement,
        @Nullable String name,
        String repositoryRulesetId,
        @Nullable List<RepositoryRuleInput> rules,
        @Nullable RepositoryRulesetTarget target) {

    public UpdateRepositoryRulesetPayload {
        requireNonNull(repositoryRulesetId, "repositoryRulesetId");
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
        if (this.conditions != null) {
            variable.put("conditions", this.conditions.toVariable());
        }
        if (this.enforcement != null) {
            variable.put("enforcement", this.enforcement.wireValue());
        }
        if (this.name != null) {
            variable.put("name", this.name);
        }
        variable.put("repositoryRulesetId", this.repositoryRulesetId);
        if (this.rules != null) {
            variable.put(
                    "rules",
                    this.rules.stream().map(RepositoryRuleInput::toVariable).toList());
        }
        if (this.target != null) {
            variable.put("target", this.target.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
