package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BranchActorAllowanceActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BypassPullRequestAllowanceSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code BypassPullRequestAllowance}; used by the generated selection code only. */
final class BypassPullRequestAllowanceSelectorImpl implements BypassPullRequestAllowanceSelector {

    private final Cursor cursor;

    BypassPullRequestAllowanceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<BranchActorAllowanceActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new BranchActorAllowanceActorSelectorImpl(child)));
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
