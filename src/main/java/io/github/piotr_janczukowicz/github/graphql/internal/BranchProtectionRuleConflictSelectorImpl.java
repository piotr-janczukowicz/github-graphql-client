package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleConflictSelector;
import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code BranchProtectionRuleConflict}; used by the generated selection code only. */
final class BranchProtectionRuleConflictSelectorImpl implements BranchProtectionRuleConflictSelector {

    private final Cursor cursor;

    BranchProtectionRuleConflictSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R branchProtectionRule(final Function<BranchProtectionRuleSelector, R> selection) {
        return cursor.object(
                "branchProtectionRule", child -> selection.apply(new BranchProtectionRuleSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R conflictingBranchProtectionRule(final Function<BranchProtectionRuleSelector, R> selection) {
        return cursor.object(
                "conflictingBranchProtectionRule",
                child -> selection.apply(new BranchProtectionRuleSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R ref(final Function<RefSelector, R> selection) {
        return cursor.object("ref", child -> selection.apply(new RefSelectorImpl(child)));
    }
}
