package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RequestReviewsInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RequestReviewsPayload(
        @Nullable List<String> botIds,
        @Nullable String clientMutationId,
        String pullRequestId,
        @Nullable List<String> teamIds,
        @Nullable Boolean union,
        @Nullable List<String> userIds) {

    public RequestReviewsPayload {
        requireNonNull(pullRequestId, "pullRequestId");
        botIds = ListUtils.copyOrNull(botIds);
        teamIds = ListUtils.copyOrNull(teamIds);
        userIds = ListUtils.copyOrNull(userIds);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.botIds != null) {
            variable.put("botIds", this.botIds);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("pullRequestId", this.pullRequestId);
        if (this.teamIds != null) {
            variable.put("teamIds", this.teamIds);
        }
        if (this.union != null) {
            variable.put("union", this.union);
        }
        if (this.userIds != null) {
            variable.put("userIds", this.userIds);
        }
        return Collections.unmodifiableMap(variable);
    }
}
