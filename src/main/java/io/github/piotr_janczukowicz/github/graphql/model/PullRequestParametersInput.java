package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code PullRequestParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record PullRequestParametersInput(
        @Nullable List<PullRequestAllowedMergeMethods> allowedMergeMethods,
        Boolean dismissStaleReviewsOnPush,
        @Nullable DismissalRestrictionInput dismissalRestriction,
        Boolean requireCodeOwnerReview,
        @Nullable Boolean requireExtraApprovalForUnattributedChanges,
        Boolean requireLastPushApproval,
        Integer requiredApprovingReviewCount,
        Boolean requiredReviewThreadResolution,
        @Nullable List<RequiredReviewerConfigurationInput> requiredReviewers) {

    public PullRequestParametersInput {
        requireNonNull(dismissStaleReviewsOnPush, "dismissStaleReviewsOnPush");
        requireNonNull(requireCodeOwnerReview, "requireCodeOwnerReview");
        requireNonNull(requireLastPushApproval, "requireLastPushApproval");
        requireNonNull(requiredApprovingReviewCount, "requiredApprovingReviewCount");
        requireNonNull(requiredReviewThreadResolution, "requiredReviewThreadResolution");
        allowedMergeMethods = ListUtils.copyOrNull(allowedMergeMethods);
        requiredReviewers = ListUtils.copyOrNull(requiredReviewers);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.allowedMergeMethods != null) {
            variable.put(
                    "allowedMergeMethods",
                    this.allowedMergeMethods.stream()
                            .map(PullRequestAllowedMergeMethods::wireValue)
                            .toList());
        }
        variable.put("dismissStaleReviewsOnPush", this.dismissStaleReviewsOnPush);
        if (this.dismissalRestriction != null) {
            variable.put("dismissalRestriction", this.dismissalRestriction.toVariable());
        }
        variable.put("requireCodeOwnerReview", this.requireCodeOwnerReview);
        if (this.requireExtraApprovalForUnattributedChanges != null) {
            variable.put("requireExtraApprovalForUnattributedChanges", this.requireExtraApprovalForUnattributedChanges);
        }
        variable.put("requireLastPushApproval", this.requireLastPushApproval);
        variable.put("requiredApprovingReviewCount", this.requiredApprovingReviewCount);
        variable.put("requiredReviewThreadResolution", this.requiredReviewThreadResolution);
        if (this.requiredReviewers != null) {
            variable.put(
                    "requiredReviewers",
                    this.requiredReviewers.stream()
                            .map(RequiredReviewerConfigurationInput::toVariable)
                            .toList());
        }
        return Collections.unmodifiableMap(variable);
    }
}
