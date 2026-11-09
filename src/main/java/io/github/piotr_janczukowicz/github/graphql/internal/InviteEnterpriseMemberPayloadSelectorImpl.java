package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseMemberInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.InviteEnterpriseMemberPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code InviteEnterpriseMemberPayload}; used by the generated selection code only. */
final class InviteEnterpriseMemberPayloadSelectorImpl implements InviteEnterpriseMemberPayloadSelector {

    private final Cursor cursor;

    InviteEnterpriseMemberPayloadSelectorImpl(final Cursor cursor) {
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
}
