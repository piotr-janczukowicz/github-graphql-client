package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.DismissalRestrictionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestAllowedMergeMethods;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestParametersSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RequiredReviewerConfigurationSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PullRequestParameters}; used by the generated selection code only. */
final class PullRequestParametersSelectorImpl implements PullRequestParametersSelector {

    private final Cursor cursor;

    PullRequestParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<PullRequestAllowedMergeMethods> allowedMergeMethods() {
        return cursor.scalarList(
                "allowedMergeMethods",
                ScalarType.enumeration(PullRequestAllowedMergeMethods::fromWire, PullRequestAllowedMergeMethods.MERGE));
    }

    @Override
    public boolean dismissStaleReviewsOnPush() {
        return cursor.getRequired("dismissStaleReviewsOnPush", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R dismissalRestriction(final Function<DismissalRestrictionSelector, R> selection) {
        return cursor.object(
                "dismissalRestriction", child -> selection.apply(new DismissalRestrictionSelectorImpl(child)));
    }

    @Override
    public boolean requireCodeOwnerReview() {
        return cursor.getRequired("requireCodeOwnerReview", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requireExtraApprovalForUnattributedChanges() {
        return cursor.getRequired("requireExtraApprovalForUnattributedChanges", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requireLastPushApproval() {
        return cursor.getRequired("requireLastPushApproval", ScalarType.BOOLEAN);
    }

    @Override
    public int requiredApprovingReviewCount() {
        return cursor.getRequired("requiredApprovingReviewCount", ScalarType.INT);
    }

    @Override
    public boolean requiredReviewThreadResolution() {
        return cursor.getRequired("requiredReviewThreadResolution", ScalarType.BOOLEAN);
    }

    @Override
    public <R> List<R> requiredReviewers(final Function<RequiredReviewerConfigurationSelector, R> selection) {
        return cursor.list(
                "requiredReviewers", child -> selection.apply(new RequiredReviewerConfigurationSelectorImpl(child)));
    }
}
