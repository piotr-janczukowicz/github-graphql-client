package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RemoveEnterpriseAdminPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RemoveEnterpriseAdminPayload}; used by the generated selection code only. */
final class RemoveEnterpriseAdminPayloadSelectorImpl implements RemoveEnterpriseAdminPayloadSelector {

    private final Cursor cursor;

    RemoveEnterpriseAdminPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R admin(final Function<UserSelector, R> selection) {
        return cursor.object("admin", child -> selection.apply(new UserSelectorImpl(child)));
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

    @Override
    public <R> @Nullable R viewer(final Function<UserSelector, R> selection) {
        return cursor.object("viewer", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
