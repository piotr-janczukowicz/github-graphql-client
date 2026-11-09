package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.UpdateNotificationRestrictionSettingPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainOwnerSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateNotificationRestrictionSettingPayload}; used by the generated selection
 * code only.
 */
final class UpdateNotificationRestrictionSettingPayloadSelectorImpl
        implements UpdateNotificationRestrictionSettingPayloadSelector {

    private final Cursor cursor;

    UpdateNotificationRestrictionSettingPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R owner(final Function<VerifiableDomainOwnerSelector, R> selection) {
        return cursor.object("owner", child -> selection.apply(new VerifiableDomainOwnerSelectorImpl(child)));
    }
}
