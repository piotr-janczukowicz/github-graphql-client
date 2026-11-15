package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicyConflict;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationCopilotCodeReviewPolicySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateOrganizationCopilotCodeReviewPolicyPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateOrganizationCopilotCodeReviewPolicyPayload}; used by the generated
 * selection code only.
 */
final class UpdateOrganizationCopilotCodeReviewPolicyPayloadSelectorImpl
        implements UpdateOrganizationCopilotCodeReviewPolicyPayloadSelector {

    private final Cursor cursor;

    UpdateOrganizationCopilotCodeReviewPolicyPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable OrganizationCopilotCodeReviewPolicyConflict conflict() {
        return cursor.get(
                "conflict",
                ScalarType.enumeration(
                        OrganizationCopilotCodeReviewPolicyConflict::fromWire,
                        OrganizationCopilotCodeReviewPolicyConflict.POLICY_MANAGED_BY_ENTERPRISE));
    }

    @Override
    public <R> @Nullable R policy(final Function<OrganizationCopilotCodeReviewPolicySelector, R> selection) {
        return cursor.object(
                "policy", child -> selection.apply(new OrganizationCopilotCodeReviewPolicySelectorImpl(child)));
    }
}
