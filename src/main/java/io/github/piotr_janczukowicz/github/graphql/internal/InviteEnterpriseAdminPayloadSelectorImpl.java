package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.InviteEnterpriseAdminPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code InviteEnterpriseAdminPayload}; used by the generated selection code only. */
final class InviteEnterpriseAdminPayloadSelectorImpl implements InviteEnterpriseAdminPayloadSelector {

    private final Cursor cursor;

    InviteEnterpriseAdminPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R invitation(final Function<EnterpriseAdministratorInvitationSelector, R> selection) {
        return cursor.object(
                "invitation", child -> selection.apply(new EnterpriseAdministratorInvitationSelectorImpl(child)));
    }
}
