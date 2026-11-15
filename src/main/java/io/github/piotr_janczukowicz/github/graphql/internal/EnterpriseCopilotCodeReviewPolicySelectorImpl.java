package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseCopilotCodeReviewPolicySelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseCopilotCodeReviewPolicyState;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code EnterpriseCopilotCodeReviewPolicy}; used by the generated selection code only.
 */
final class EnterpriseCopilotCodeReviewPolicySelectorImpl implements EnterpriseCopilotCodeReviewPolicySelector {

    private final Cursor cursor;

    EnterpriseCopilotCodeReviewPolicySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable EnterpriseCopilotCodeReviewPolicyState policyState() {
        return cursor.get(
                "policyState",
                ScalarType.enumeration(
                        EnterpriseCopilotCodeReviewPolicyState::fromWire,
                        EnterpriseCopilotCodeReviewPolicyState.CONFIGURED_BY_ORGANIZATION_ADMINS));
    }
}
