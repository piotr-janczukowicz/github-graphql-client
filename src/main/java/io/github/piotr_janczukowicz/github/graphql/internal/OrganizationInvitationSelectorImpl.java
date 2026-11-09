package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationRole;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSource;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationType;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code OrganizationInvitation}; used by the generated selection code only. */
final class OrganizationInvitationSelectorImpl implements OrganizationInvitationSelector {

    private final Cursor cursor;

    OrganizationInvitationSelectorImpl(final Cursor cursor) {
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
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public OrganizationInvitationSource invitationSource() {
        return cursor.getRequired(
                "invitationSource",
                ScalarType.enumeration(
                        OrganizationInvitationSource::fromWire,
                        OrganizationInvitationSource.ENTERPRISE_ORGANIZATION_CREATION));
    }

    @Override
    public OrganizationInvitationType invitationType() {
        return cursor.getRequired(
                "invitationType",
                ScalarType.enumeration(OrganizationInvitationType::fromWire, OrganizationInvitationType.EMAIL));
    }

    @Override
    public <R> @Nullable R invitee(final Function<UserSelector, R> selection) {
        return cursor.object("invitee", child -> selection.apply(new UserSelectorImpl(child)));
    }

    /**
     * @deprecated `inviter` will be removed. `inviter` will be replaced by `inviterActor`. Removal on 2024-07-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> R inviter(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("inviter", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R inviterActor(final Function<UserSelector, R> selection) {
        return cursor.object("inviterActor", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public <R> R organization(final Function<OrganizationSelector, R> selection) {
        return cursor.objectRequired("organization", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }

    @Override
    public OrganizationInvitationRole role() {
        return cursor.getRequired(
                "role", ScalarType.enumeration(OrganizationInvitationRole::fromWire, OrganizationInvitationRole.ADMIN));
    }
}
