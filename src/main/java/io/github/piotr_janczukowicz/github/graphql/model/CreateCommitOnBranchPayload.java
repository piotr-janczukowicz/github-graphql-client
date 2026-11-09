package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CreateCommitOnBranchInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CreateCommitOnBranchPayload(
        CommittableBranch branch,
        @Nullable String clientMutationId,
        String expectedHeadOid,
        @Nullable FileChanges fileChanges,
        CommitMessage message) {

    public CreateCommitOnBranchPayload {
        requireNonNull(branch, "branch");
        requireNonNull(expectedHeadOid, "expectedHeadOid");
        requireNonNull(message, "message");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("branch", this.branch.toVariable());
        if (this.clientMutationId != null) {
            variable.put("clientMutationId", this.clientMutationId);
        }
        variable.put("expectedHeadOid", this.expectedHeadOid);
        if (this.fileChanges != null) {
            variable.put("fileChanges", this.fileChanges.toVariable());
        }
        variable.put("message", this.message.toVariable());
        return Collections.unmodifiableMap(variable);
    }
}
