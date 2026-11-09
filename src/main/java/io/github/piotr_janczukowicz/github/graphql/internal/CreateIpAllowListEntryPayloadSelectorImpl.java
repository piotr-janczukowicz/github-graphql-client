package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateIpAllowListEntryPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CreateIpAllowListEntryPayload}; used by the generated selection code only. */
final class CreateIpAllowListEntryPayloadSelectorImpl implements CreateIpAllowListEntryPayloadSelector {

    private final Cursor cursor;

    CreateIpAllowListEntryPayloadSelectorImpl(final Cursor cursor) {
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
