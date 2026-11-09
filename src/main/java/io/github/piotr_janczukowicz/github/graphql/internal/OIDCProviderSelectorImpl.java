package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderExternalIdentitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderExternalIdentitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OIDCProviderType;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code OIDCProvider}; used by the generated selection code only. */
final class OIDCProviderSelectorImpl implements OIDCProviderSelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    OIDCProviderSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R enterprise(final Function<EnterpriseSelector, R> selection) {
        return cursor.object("enterprise", child -> selection.apply(new EnterpriseSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> externalIdentities(
            final Paging paging,
            final OIDCProviderExternalIdentitiesFilter arguments,
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
                paging, OIDCProviderExternalIdentitiesFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public OIDCProviderType providerType() {
        return cursor.getRequired(
                "providerType", ScalarType.enumeration(OIDCProviderType::fromWire, OIDCProviderType.AAD));
    }

    @Override
    public String tenantId() {
        return cursor.getRequired("tenantId", ScalarType.STRING);
    }
}
