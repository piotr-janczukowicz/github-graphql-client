package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code PullRequestParameters}. */
public interface PullRequestParametersSelector {

    List<PullRequestAllowedMergeMethods> allowedMergeMethods();

    boolean dismissStaleReviewsOnPush();

    <R> @Nullable R dismissalRestriction(Function<DismissalRestrictionSelector, R> selection);

    boolean requireCodeOwnerReview();

    boolean requireExtraApprovalForUnattributedChanges();

    boolean requireLastPushApproval();

    int requiredApprovingReviewCount();

    boolean requiredReviewThreadResolution();

    <R> List<R> requiredReviewers(Function<RequiredReviewerConfigurationSelector, R> selection);
}
