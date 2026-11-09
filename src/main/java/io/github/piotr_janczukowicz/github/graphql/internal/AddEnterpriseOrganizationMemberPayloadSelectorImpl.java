package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AddEnterpriseOrganizationMemberPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code AddEnterpriseOrganizationMemberPayload}; used by the generated selection code
 * only.
 */
final class AddEnterpriseOrganizationMemberPayloadSelectorImpl
        implements AddEnterpriseOrganizationMemberPayloadSelector {

    private final Cursor cursor;

    AddEnterpriseOrganizationMemberPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> List<R> users(final Function<UserSelector, R> selection) {
        return cursor.list("users", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
