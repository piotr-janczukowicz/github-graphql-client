package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RequestReviewsByLoginInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RequestReviewsByLoginPayload(
        @Nullable List<String> botLogins,
        @Nullable String clientMutationId,
        String pullRequestId,
        @Nullable List<String> teamSlugs,
        @Nullable Boolean union,
        @Nullable List<String> userLogins) {

    public RequestReviewsByLoginPayload {
        requireNonNull(pullRequestId, "pullRequestId");
        botLogins = ListUtils.copyOrNull(botLogins);
        teamSlugs = ListUtils.copyOrNull(teamSlugs);
        userLogins = ListUtils.copyOrNull(userLogins);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.botLogins != null) {
            variable.put("botLogins", this.botLogins);
        }
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("pullRequestId", this.pullRequestId);
        if (this.teamSlugs != null) {
            variable.put("teamSlugs", this.teamSlugs);
        }
        if (this.union != null) {
            variable.put("union", this.union);
        }
        if (this.userLogins != null) {
            variable.put("userLogins", this.userLogins);
        }
        return Collections.unmodifiableMap(variable);
    }
}
