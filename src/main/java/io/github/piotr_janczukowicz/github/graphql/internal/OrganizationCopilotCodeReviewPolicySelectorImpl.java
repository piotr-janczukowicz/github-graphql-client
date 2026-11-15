package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicyManager;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicyState;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code OrganizationCopilotCodeReviewPolicy}; used by the generated selection code
 * only.
 */
final class OrganizationCopilotCodeReviewPolicySelectorImpl implements OrganizationCopilotCodeReviewPolicySelector {

    private final Cursor cursor;

    OrganizationCopilotCodeReviewPolicySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable OrganizationCopilotCodeReviewPolicyState configuredState() {
        return cursor.get(
                "configuredState",
                ScalarType.enumeration(
                        OrganizationCopilotCodeReviewPolicyState::fromWire,
                        OrganizationCopilotCodeReviewPolicyState.DISABLED));
    }

    @Override
    public boolean editable() {
        return cursor.getRequired("editable", ScalarType.BOOLEAN);
    }

    @Override
    public OrganizationCopilotCodeReviewPolicyState effectiveState() {
        return cursor.getRequired(
                "effectiveState",
                ScalarType.enumeration(
                        OrganizationCopilotCodeReviewPolicyState::fromWire,
                        OrganizationCopilotCodeReviewPolicyState.DISABLED));
    }

    @Override
    public OrganizationCopilotCodeReviewPolicyManager managedBy() {
        return cursor.getRequired(
                "managedBy",
                ScalarType.enumeration(
                        OrganizationCopilotCodeReviewPolicyManager::fromWire,
                        OrganizationCopilotCodeReviewPolicyManager.ENTERPRISE));
    }
}
