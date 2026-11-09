package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code EnterpriseServerUserAccount}; used by the generated selection code only. */
final class EnterpriseServerUserAccountSelectorImpl implements EnterpriseServerUserAccountSelector {

    private final Cursor cursor;

    EnterpriseServerUserAccountSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> emails(
            final Paging paging,
            final EnterpriseServerUserAccountEmailsFilter arguments,
            final Function<EnterpriseServerUserAccountEmailSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "emails",
                child -> selection.apply(new EnterpriseServerUserAccountEmailSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "EnterpriseServerUserAccountEmailOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> emails(
            final Paging paging, final Function<EnterpriseServerUserAccountEmailSelector, R> selection) {
        return emails(
                paging, EnterpriseServerUserAccountEmailsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R enterpriseServerInstallation(final Function<EnterpriseServerInstallationSelector, R> selection) {
        return cursor.objectRequired(
                "enterpriseServerInstallation",
                child -> selection.apply(new EnterpriseServerInstallationSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isSiteAdmin() {
        return cursor.getRequired("isSiteAdmin", ScalarType.BOOLEAN);
    }

    @Override
    public String login() {
        return cursor.getRequired("login", ScalarType.STRING);
    }

    @Override
    public @Nullable String profileName() {
        return cursor.get("profileName", ScalarType.STRING);
    }

    @Override
    public Instant remoteCreatedAt() {
        return cursor.getRequired("remoteCreatedAt", ScalarType.INSTANT);
    }

    @Override
    public int remoteUserId() {
        return cursor.getRequired("remoteUserId", ScalarType.INT);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
