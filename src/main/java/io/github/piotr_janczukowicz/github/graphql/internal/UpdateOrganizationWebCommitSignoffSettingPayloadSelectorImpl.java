package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateOrganizationWebCommitSignoffSettingPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateOrganizationWebCommitSignoffSettingPayload}; used by the generated
 * selection code only.
 */
final class UpdateOrganizationWebCommitSignoffSettingPayloadSelectorImpl
        implements UpdateOrganizationWebCommitSignoffSettingPayloadSelector {

    private final Cursor cursor;

    UpdateOrganizationWebCommitSignoffSettingPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public @Nullable String message() {
        return cursor.get("message", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R organization(final Function<OrganizationSelector, R> selection) {
        return cursor.object("organization", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }
}
