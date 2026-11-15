package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewEffortLevel;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewDefaultEffortSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicyManager;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code OrganizationCopilotCodeReviewDefaultEffort}; used by the generated selection
 * code only.
 */
final class OrganizationCopilotCodeReviewDefaultEffortSelectorImpl
        implements OrganizationCopilotCodeReviewDefaultEffortSelector {

    private final Cursor cursor;

    OrganizationCopilotCodeReviewDefaultEffortSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable CopilotCodeReviewEffortLevel configured() {
        return cursor.get(
                "configured",
                ScalarType.enumeration(CopilotCodeReviewEffortLevel::fromWire, CopilotCodeReviewEffortLevel.AUTO));
    }

    @Override
    public boolean editable() {
        return cursor.getRequired("editable", ScalarType.BOOLEAN);
    }

    @Override
    public CopilotCodeReviewEffortLevel effective() {
        return cursor.getRequired(
                "effective",
                ScalarType.enumeration(CopilotCodeReviewEffortLevel::fromWire, CopilotCodeReviewEffortLevel.AUTO));
    }

    @Override
    public CopilotCodeReviewEffortLevel githubDefault() {
        return cursor.getRequired(
                "githubDefault",
                ScalarType.enumeration(CopilotCodeReviewEffortLevel::fromWire, CopilotCodeReviewEffortLevel.AUTO));
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
