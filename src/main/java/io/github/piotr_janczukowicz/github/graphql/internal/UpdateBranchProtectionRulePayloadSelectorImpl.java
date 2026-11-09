package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BranchProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateBranchProtectionRulePayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateBranchProtectionRulePayload}; used by the generated selection code only.
 */
final class UpdateBranchProtectionRulePayloadSelectorImpl implements UpdateBranchProtectionRulePayloadSelector {

    private final Cursor cursor;

    UpdateBranchProtectionRulePayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R branchProtectionRule(final Function<BranchProtectionRuleSelector, R> selection) {
        return cursor.object(
                "branchProtectionRule", child -> selection.apply(new BranchProtectionRuleSelectorImpl(child)));
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }
}
