package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListOwnerSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IpAllowListEntry}; used by the generated selection code only. */
final class IpAllowListEntrySelectorImpl implements IpAllowListEntrySelector {

    private final Cursor cursor;

    IpAllowListEntrySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String allowListValue() {
        return cursor.getRequired("allowListValue", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isActive() {
        return cursor.getRequired("isActive", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }

    @Override
    public <R> R owner(final Function<IpAllowListOwnerSelector, R> selection) {
        return cursor.objectRequired("owner", child -> selection.apply(new IpAllowListOwnerSelectorImpl(child)));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
