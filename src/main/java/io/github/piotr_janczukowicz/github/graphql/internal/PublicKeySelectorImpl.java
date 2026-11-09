package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.PublicKeySelector;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code PublicKey}; used by the generated selection code only. */
final class PublicKeySelectorImpl implements PublicKeySelector {

    private final Cursor cursor;

    PublicKeySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Instant accessedAt() {
        return cursor.get("accessedAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Instant createdAt() {
        return cursor.get("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String fingerprint() {
        return cursor.getRequired("fingerprint", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable Boolean isReadOnly() {
        return cursor.get("isReadOnly", ScalarType.BOOLEAN);
    }

    @Override
    public String key() {
        return cursor.getRequired("key", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant updatedAt() {
        return cursor.get("updatedAt", ScalarType.INSTANT);
    }
}
