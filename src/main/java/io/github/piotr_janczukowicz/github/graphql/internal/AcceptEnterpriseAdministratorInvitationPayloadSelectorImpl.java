package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AcceptEnterpriseAdministratorInvitationPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code AcceptEnterpriseAdministratorInvitationPayload}; used by the generated
 * selection code only.
 */
final class AcceptEnterpriseAdministratorInvitationPayloadSelectorImpl
        implements AcceptEnterpriseAdministratorInvitationPayloadSelector {

    private final Cursor cursor;

    AcceptEnterpriseAdministratorInvitationPayloadSelectorImpl(final Cursor cursor) {
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

    @Override
    public @Nullable String message() {
        return cursor.get("message", ScalarType.STRING);
    }
}
