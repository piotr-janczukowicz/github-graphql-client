package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code UpdateTeamReviewAssignmentInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record UpdateTeamReviewAssignmentPayload(
        @Nullable TeamReviewAssignmentAlgorithm algorithm,
        @Nullable String clientMutationId,
        @Nullable Boolean countMembersAlreadyRequested,
        Boolean enabled,
        @Nullable List<String> excludedTeamMemberIds,
        String id,
        @Nullable Boolean includeChildTeamMembers,
        @Nullable Boolean notifyTeam,
        @Nullable Boolean removeTeamRequest,
        @Nullable Integer teamMemberCount) {

    public UpdateTeamReviewAssignmentPayload {
        requireNonNull(enabled, "enabled");
        requireNonNull(id, "id");
        excludedTeamMemberIds = ListUtils.copyOrNull(excludedTeamMemberIds);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.algorithm != null) {
            variable.put("algorithm", this.algorithm.wireValue());
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        if (this.countMembersAlreadyRequested != null) {
            variable.put("countMembersAlreadyRequested", this.countMembersAlreadyRequested);
        }
        variable.put("enabled", this.enabled);
        if (this.excludedTeamMemberIds != null) {
            variable.put("excludedTeamMemberIds", this.excludedTeamMemberIds);
        }
        variable.put("id", this.id);
        if (this.includeChildTeamMembers != null) {
            variable.put("includeChildTeamMembers", this.includeChildTeamMembers);
        }
        if (this.notifyTeam != null) {
            variable.put("notifyTeam", this.notifyTeam);
        }
        if (this.removeTeamRequest != null) {
            variable.put("removeTeamRequest", this.removeTeamRequest);
        }
        if (this.teamMemberCount != null) {
            variable.put("teamMemberCount", this.teamMemberCount);
        }
        return Collections.unmodifiableMap(variable);
    }
}
