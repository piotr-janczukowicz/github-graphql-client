package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissalAllowanceActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReviewDismissalAllowanceSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReviewDismissalAllowance}; used by the generated selection code only. */
final class ReviewDismissalAllowanceSelectorImpl implements ReviewDismissalAllowanceSelector {

    private final Cursor cursor;

    ReviewDismissalAllowanceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<ReviewDismissalAllowanceActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new ReviewDismissalAllowanceActorSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R branchProtectionRule(final Function<BranchProtectionRuleSelector, R> selection) {
        return cursor.object(
                "branchProtectionRule", child -> selection.apply(new BranchProtectionRuleSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }
}
