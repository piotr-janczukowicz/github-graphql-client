package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SetOrganizationInteractionLimitPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code SetOrganizationInteractionLimitPayload}; used by the generated selection code
 * only.
 */
final class SetOrganizationInteractionLimitPayloadSelectorImpl
        implements SetOrganizationInteractionLimitPayloadSelector {

    private final Cursor cursor;

    SetOrganizationInteractionLimitPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R organization(final Function<OrganizationSelector, R> selection) {
        return cursor.object("organization", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }
}
