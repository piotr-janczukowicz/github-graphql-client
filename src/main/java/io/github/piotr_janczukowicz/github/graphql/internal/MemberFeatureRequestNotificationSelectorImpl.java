package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.MemberFeatureRequestNotificationSelector;
import java.time.Instant;

/**
 * Reads and records the fields of {@code MemberFeatureRequestNotification}; used by the generated selection code only.
 */
final class MemberFeatureRequestNotificationSelectorImpl implements MemberFeatureRequestNotificationSelector {

    private final Cursor cursor;

    MemberFeatureRequestNotificationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
