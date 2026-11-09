package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UnfollowOrganizationPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UnfollowOrganizationPayload}; used by the generated selection code only. */
final class UnfollowOrganizationPayloadSelectorImpl implements UnfollowOrganizationPayloadSelector {

    private final Cursor cursor;

    UnfollowOrganizationPayloadSelectorImpl(final Cursor cursor) {
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
