package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderExternalIdentitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderExternalIdentitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseIdentityProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SamlDigestAlgorithm;
import io.github.piotr_janczukowicz.github.graphql.model.SamlSignatureAlgorithm;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code EnterpriseIdentityProvider}; used by the generated selection code only. */
final class EnterpriseIdentityProviderSelectorImpl implements EnterpriseIdentityProviderSelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    EnterpriseIdentityProviderSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable SamlDigestAlgorithm digestMethod() {
        return cursor.get(
                "digestMethod", ScalarType.enumeration(SamlDigestAlgorithm::fromWire, SamlDigestAlgorithm.SHA1));
    }

    @Override
    public <R> @Nullable R enterprise(final Function<EnterpriseSelector, R> selection) {
        return cursor.object("enterprise", child -> selection.apply(new EnterpriseSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> externalIdentities(
            final Paging paging,
            final EnterpriseIdentityProviderExternalIdentitiesFilter arguments,
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
                EnterpriseIdentityProviderExternalIdentitiesFilterBuilder.builder()
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
    public List<String> recoveryCodes() {
        return cursor.scalarList("recoveryCodes", ScalarType.STRING);
    }

    @Override
    public @Nullable SamlSignatureAlgorithm signatureMethod() {
        return cursor.get(
                "signatureMethod",
                ScalarType.enumeration(SamlSignatureAlgorithm::fromWire, SamlSignatureAlgorithm.RSA_SHA1));
    }

    @Override
    public @Nullable String ssoUrl() {
        return cursor.get("ssoUrl", ScalarType.STRING);
    }
}
