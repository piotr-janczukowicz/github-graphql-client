package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySamlAttributesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentityScimAttributesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ExternalIdentity}; used by the generated selection code only. */
final class ExternalIdentitySelectorImpl implements ExternalIdentitySelector {

    private final Cursor cursor;

    ExternalIdentitySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String guid() {
        return cursor.getRequired("guid", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R organizationInvitation(final Function<OrganizationInvitationSelector, R> selection) {
        return cursor.object(
                "organizationInvitation", child -> selection.apply(new OrganizationInvitationSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R samlIdentity(final Function<ExternalIdentitySamlAttributesSelector, R> selection) {
        return cursor.object(
                "samlIdentity", child -> selection.apply(new ExternalIdentitySamlAttributesSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R scimIdentity(final Function<ExternalIdentityScimAttributesSelector, R> selection) {
        return cursor.object(
                "scimIdentity", child -> selection.apply(new ExternalIdentityScimAttributesSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R user(final Function<UserSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
