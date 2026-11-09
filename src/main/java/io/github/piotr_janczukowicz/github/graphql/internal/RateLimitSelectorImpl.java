package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RateLimitSelector;
import java.time.Instant;

/** Reads and records the fields of {@code RateLimit}; used by the generated selection code only. */
final class RateLimitSelectorImpl implements RateLimitSelector {

    private final Cursor cursor;

    RateLimitSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int cost() {
        return cursor.getRequired("cost", ScalarType.INT);
    }

    @Override
    public int limit() {
        return cursor.getRequired("limit", ScalarType.INT);
    }

    @Override
    public int nodeCount() {
        return cursor.getRequired("nodeCount", ScalarType.INT);
    }

    @Override
    public int remaining() {
        return cursor.getRequired("remaining", ScalarType.INT);
    }

    @Override
    public Instant resetAt() {
        return cursor.getRequired("resetAt", ScalarType.INSTANT);
    }

    @Override
    public int used() {
        return cursor.getRequired("used", ScalarType.INT);
    }
}
