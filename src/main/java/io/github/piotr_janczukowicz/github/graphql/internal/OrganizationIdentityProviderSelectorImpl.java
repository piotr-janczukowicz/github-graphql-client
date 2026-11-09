package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIdentityProviderExternalIdentitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIdentityProviderExternalIdentitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code OrganizationIdentityProvider}; used by the generated selection code only. */
final class OrganizationIdentityProviderSelectorImpl implements OrganizationIdentityProviderSelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    OrganizationIdentityProviderSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String digestMethod() {
        return cursor.get("digestMethod", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> externalIdentities(
            final Paging paging,
            final OrganizationIdentityProviderExternalIdentitiesFilter arguments,
            final Function<ExternalIdentitySelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "externalIdentities",
                child -> selection.apply(new ExternalIdentitySelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of("login", STRING, arguments.login()),
                Argument.of("membersOnly", "Boolean", arguments.membersOnly()),
                Argument.of("userName", STRING, arguments.userName()));
    }

    @Override
    public <R> Page<R> externalIdentities(final Paging paging, final Function<ExternalIdentitySelector, R> selection) {
        return externalIdentities(
                paging,
                OrganizationIdentityProviderExternalIdentitiesFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable String idpCertificate() {
        return cursor.get("idpCertificate", ScalarType.STRING);
    }

    @Override
    public @Nullable String issuer() {
        return cursor.get("issuer", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R organization(final Function<OrganizationSelector, R> selection) {
        return cursor.object("organization", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }

    @Override
    public @Nullable String signatureMethod() {
        return cursor.get("signatureMethod", ScalarType.STRING);
    }

    @Override
    public @Nullable String ssoUrl() {
        return cursor.get("ssoUrl", ScalarType.STRING);
    }
}
