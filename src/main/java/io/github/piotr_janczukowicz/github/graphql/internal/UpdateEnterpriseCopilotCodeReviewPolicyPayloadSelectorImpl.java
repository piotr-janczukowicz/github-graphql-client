package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseCopilotCodeReviewPolicySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateEnterpriseCopilotCodeReviewPolicyPayload}; used by the generated
 * selection code only.
 */
final class UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelectorImpl
        implements UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelector {

    private final Cursor cursor;

    UpdateEnterpriseCopilotCodeReviewPolicyPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R policy(final Function<EnterpriseCopilotCodeReviewPolicySelector, R> selection) {
        return cursor.object(
                "policy", child -> selection.apply(new EnterpriseCopilotCodeReviewPolicySelectorImpl(child)));
    }
}
