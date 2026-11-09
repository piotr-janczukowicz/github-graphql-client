package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.FollowOrganizationPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code FollowOrganizationPayload}; used by the generated selection code only. */
final class FollowOrganizationPayloadSelectorImpl implements FollowOrganizationPayloadSelector {

    private final Cursor cursor;

    FollowOrganizationPayloadSelectorImpl(final Cursor cursor) {
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
