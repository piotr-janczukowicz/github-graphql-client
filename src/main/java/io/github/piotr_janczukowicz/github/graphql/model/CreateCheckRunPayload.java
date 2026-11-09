package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateCheckRunInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateCheckRunPayload(
        @Nullable List<CheckRunAction> actions,
        @Nullable String clientMutationId,
        @Nullable Instant completedAt,
        @Nullable CheckConclusionState conclusion,
        @Nullable String detailsUrl,
        @Nullable String externalId,
        String headSha,
        String name,
        @Nullable CheckRunOutput output,
        String repositoryId,
        @Nullable Instant startedAt,
        @Nullable RequestableCheckStatusState status) {

    public CreateCheckRunPayload {
        requireNonNull(headSha, "headSha");
        requireNonNull(name, "name");
        requireNonNull(repositoryId, "repositoryId");
        actions = ListUtils.copyOrNull(actions);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.actions != null) {
            variable.put(
                    "actions",
                    this.actions.stream().map(CheckRunAction::toVariable).toList());
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.completedAt != null) {
            variable.put("completedAt", this.completedAt.toString());
        }
        if (this.conclusion != null) {
            variable.put("conclusion", this.conclusion.wireValue());
        }
        if (this.detailsUrl != null) {
            variable.put("detailsUrl", this.detailsUrl);
        }
        if (this.externalId != null) {
            variable.put("externalId", this.externalId);
        }
        variable.put("headSha", this.headSha);
        variable.put("name", this.name);
        if (this.output != null) {
            variable.put("output", this.output.toVariable());
        }
        variable.put("repositoryId", this.repositoryId);
        if (this.startedAt != null) {
            variable.put("startedAt", this.startedAt.toString());
        }
        if (this.status != null) {
            variable.put("status", this.status.name());
        }
        return Collections.unmodifiableMap(variable);
    }
}
