package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountAvatarUrlFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountEnterpriseInstallationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountEnterpriseInstallationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code EnterpriseUserAccount}; used by the generated selection code only. */
final class EnterpriseUserAccountSelectorImpl implements EnterpriseUserAccountSelector {

    private static final String ARGUMENTS = "arguments";

    private static final String STRING = "String";

    private final Cursor cursor;

    EnterpriseUserAccountSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String avatarUrl(final EnterpriseUserAccountAvatarUrlFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired("avatarUrl", ScalarType.STRING, Argument.of("size", "Int", arguments.size()));
    }

    @Override
    public String avatarUrl() {
        return avatarUrl(EnterpriseUserAccountAvatarUrlFilterBuilder.builder().build());
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R enterprise(final Function<EnterpriseSelector, R> selection) {
        return cursor.objectRequired("enterprise", child -> selection.apply(new EnterpriseSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> enterpriseInstallations(
            final Paging paging,
            final EnterpriseUserAccountEnterpriseInstallationsFilter arguments,
            final Function<EnterpriseServerInstallationSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "enterpriseInstallations",
                child -> selection.apply(new EnterpriseServerInstallationSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "EnterpriseServerInstallationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("query", STRING, arguments.query()),
                Argument.of("role", "EnterpriseUserAccountMembershipRole", arguments.role()));
    }

    @Override
    public <R> Page<R> enterpriseInstallations(
            final Paging paging, final Function<EnterpriseServerInstallationSelector, R> selection) {
        return enterpriseInstallations(
                paging,
                EnterpriseUserAccountEnterpriseInstallationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String login() {
        return cursor.getRequired("login", ScalarType.STRING);
    }

    @Override
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> organizations(
            final Paging paging,
            final EnterpriseUserAccountOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "organizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "OrganizationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("query", STRING, arguments.query()),
                Argument.of("role", "EnterpriseUserAccountMembershipRole", arguments.role()));
    }

    @Override
    public <R> Page<R> organizations(final Paging paging, final Function<OrganizationSelector, R> selection) {
        return organizations(
                paging,
                EnterpriseUserAccountOrganizationsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R user(final Function<UserSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
