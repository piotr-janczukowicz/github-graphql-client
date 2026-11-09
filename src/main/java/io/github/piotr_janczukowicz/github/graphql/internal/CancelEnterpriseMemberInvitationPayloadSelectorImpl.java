package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CancelEnterpriseMemberInvitationPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CancelEnterpriseMemberInvitationPayload}; used by the generated selection code
 * only.
 */
final class CancelEnterpriseMemberInvitationPayloadSelectorImpl
        implements CancelEnterpriseMemberInvitationPayloadSelector {

    private final Cursor cursor;

    CancelEnterpriseMemberInvitationPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R invitation(final Function<EnterpriseMemberInvitationSelector, R> selection) {
        return cursor.object("invitation", child -> selection.apply(new EnterpriseMemberInvitationSelectorImpl(child)));
    }

    @Override
    public @Nullable String message() {
        return cursor.get("message", ScalarType.STRING);
    }
}
