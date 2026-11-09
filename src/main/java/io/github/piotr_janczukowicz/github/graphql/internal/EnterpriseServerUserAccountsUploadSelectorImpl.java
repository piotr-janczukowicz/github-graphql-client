package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountsUploadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountsUploadSyncState;
import java.time.Instant;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code EnterpriseServerUserAccountsUpload}; used by the generated selection code
 * only.
 */
final class EnterpriseServerUserAccountsUploadSelectorImpl implements EnterpriseServerUserAccountsUploadSelector {

    private final Cursor cursor;

    EnterpriseServerUserAccountsUploadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
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
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public EnterpriseServerUserAccountsUploadSyncState syncState() {
        return cursor.getRequired(
                "syncState",
                ScalarType.enumeration(
                        EnterpriseServerUserAccountsUploadSyncState::fromWire,
                        EnterpriseServerUserAccountsUploadSyncState.FAILURE));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
