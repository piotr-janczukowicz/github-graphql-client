package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseAdministratorRole;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code EnterpriseAdministratorInvitation}; used by the generated selection code only.
 */
final class EnterpriseAdministratorInvitationSelectorImpl implements EnterpriseAdministratorInvitationSelector {

    private final Cursor cursor;

    EnterpriseAdministratorInvitationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String email() {
        return cursor.get("email", ScalarType.STRING);
    }

    @Override
    public <R> R enterprise(final Function<EnterpriseSelector, R> selection) {
        return cursor.objectRequired("enterprise", child -> selection.apply(new EnterpriseSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R invitee(final Function<UserSelector, R> selection) {
        return cursor.object("invitee", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R inviter(final Function<UserSelector, R> selection) {
        return cursor.object("inviter", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public EnterpriseAdministratorRole role() {
        return cursor.getRequired(
                "role",
                ScalarType.enumeration(
                        EnterpriseAdministratorRole::fromWire, EnterpriseAdministratorRole.BILLING_MANAGER));
    }
}
