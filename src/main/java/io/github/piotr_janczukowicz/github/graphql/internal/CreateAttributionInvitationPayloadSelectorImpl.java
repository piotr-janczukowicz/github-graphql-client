package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ClaimableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreateAttributionInvitationPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CreateAttributionInvitationPayload}; used by the generated selection code
 * only.
 */
final class CreateAttributionInvitationPayloadSelectorImpl implements CreateAttributionInvitationPayloadSelector {

    private final Cursor cursor;

    CreateAttributionInvitationPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R owner(final Function<OrganizationSelector, R> selection) {
        return cursor.object("owner", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R source(final Function<ClaimableSelector, R> selection) {
        return cursor.object("source", child -> selection.apply(new ClaimableSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R target(final Function<ClaimableSelector, R> selection) {
        return cursor.object("target", child -> selection.apply(new ClaimableSelectorImpl(child)));
    }
}
