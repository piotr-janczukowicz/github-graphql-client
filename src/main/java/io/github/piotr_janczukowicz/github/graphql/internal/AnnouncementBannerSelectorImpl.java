package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.AnnouncementBannerSelector;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code AnnouncementBanner}; used by the generated selection code only. */
final class AnnouncementBannerSelectorImpl implements AnnouncementBannerSelector {

    private final Cursor cursor;

    AnnouncementBannerSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Instant expiresAt() {
        return cursor.get("expiresAt", ScalarType.INSTANT);
    }

    @Override
    public boolean isUserDismissible() {
        return cursor.getRequired("isUserDismissible", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable String message() {
        return cursor.get("message", ScalarType.STRING);
    }
}
