package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateIpAllowListEntryPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code UpdateIpAllowListEntryPayload}; used by the generated selection code only. */
final class UpdateIpAllowListEntryPayloadSelectorImpl implements UpdateIpAllowListEntryPayloadSelector {

    private final Cursor cursor;

    UpdateIpAllowListEntryPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R ipAllowListEntry(final Function<IpAllowListEntrySelector, R> selection) {
        return cursor.object("ipAllowListEntry", child -> selection.apply(new IpAllowListEntrySelectorImpl(child)));
    }
}
