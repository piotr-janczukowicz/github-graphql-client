package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayload}; used by the
 * generated selection code only.
 */
final class UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayloadSelectorImpl
        implements UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayloadSelector {

    private final Cursor cursor;

    UpdateEnterpriseMembersCanDeleteRepositoriesSettingPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R enterprise(final Function<EnterpriseSelector, R> selection) {
        return cursor.object("enterprise", child -> selection.apply(new EnterpriseSelectorImpl(child)));
    }

    @Override
    public @Nullable String message() {
        return cursor.get("message", ScalarType.STRING);
    }
}
