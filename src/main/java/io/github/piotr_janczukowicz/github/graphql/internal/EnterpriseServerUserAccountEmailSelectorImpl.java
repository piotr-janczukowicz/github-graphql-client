package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountEmailSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerUserAccountSelector;
import java.time.Instant;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code EnterpriseServerUserAccountEmail}; used by the generated selection code only.
 */
final class EnterpriseServerUserAccountEmailSelectorImpl implements EnterpriseServerUserAccountEmailSelector {

    private final Cursor cursor;

    EnterpriseServerUserAccountEmailSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String email() {
        return cursor.getRequired("email", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isPrimary() {
        return cursor.getRequired("isPrimary", ScalarType.BOOLEAN);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R userAccount(final Function<EnterpriseServerUserAccountSelector, R> selection) {
        return cursor.objectRequired(
                "userAccount", child -> selection.apply(new EnterpriseServerUserAccountSelectorImpl(child)));
    }
}
