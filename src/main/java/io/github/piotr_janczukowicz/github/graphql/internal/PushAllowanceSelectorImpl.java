package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushAllowanceActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PushAllowanceSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PushAllowance}; used by the generated selection code only. */
final class PushAllowanceSelectorImpl implements PushAllowanceSelector {

    private final Cursor cursor;

    PushAllowanceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<PushAllowanceActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new PushAllowanceActorSelectorImpl(child)));
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
