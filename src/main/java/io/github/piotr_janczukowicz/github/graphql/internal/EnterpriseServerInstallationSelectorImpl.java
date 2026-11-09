package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationUserAccountsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationUserAccountsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationUserAccountsUploadsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationUserAccountsUploadsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountsUploadSelector;
import java.time.Instant;
import java.util.function.Function;

/** Reads and records the fields of {@code EnterpriseServerInstallation}; used by the generated selection code only. */
final class EnterpriseServerInstallationSelectorImpl implements EnterpriseServerInstallationSelector {

    private final Cursor cursor;

    EnterpriseServerInstallationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String customerName() {
        return cursor.getRequired("customerName", ScalarType.STRING);
    }

    @Override
    public String hostName() {
        return cursor.getRequired("hostName", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isConnected() {
        return cursor.getRequired("isConnected", ScalarType.BOOLEAN);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> userAccounts(
            final Paging paging,
            final EnterpriseServerInstallationUserAccountsFilter arguments,
            final Function<EnterpriseServerUserAccountSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "userAccounts",
                child -> selection.apply(new EnterpriseServerUserAccountSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "EnterpriseServerUserAccountOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> userAccounts(
            final Paging paging, final Function<EnterpriseServerUserAccountSelector, R> selection) {
        return userAccounts(
                paging,
                EnterpriseServerInstallationUserAccountsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> userAccountsUploads(
            final Paging paging,
            final EnterpriseServerInstallationUserAccountsUploadsFilter arguments,
            final Function<EnterpriseServerUserAccountsUploadSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "userAccountsUploads",
                child -> selection.apply(new EnterpriseServerUserAccountsUploadSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "EnterpriseServerUserAccountsUploadOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> userAccountsUploads(
            final Paging paging, final Function<EnterpriseServerUserAccountsUploadSelector, R> selection) {
        return userAccountsUploads(
                paging,
                EnterpriseServerInstallationUserAccountsUploadsFilterBuilder.builder()
                        .build(),
                selection);
    }
}
