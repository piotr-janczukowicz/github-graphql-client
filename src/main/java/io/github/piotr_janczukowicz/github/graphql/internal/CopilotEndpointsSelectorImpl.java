package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotEndpointsSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CopilotEndpoints}; used by the generated selection code only. */
final class CopilotEndpointsSelectorImpl implements CopilotEndpointsSelector {

    private final Cursor cursor;

    CopilotEndpointsSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String api() {
        return cursor.getRequired("api", ScalarType.STRING);
    }

    @Override
    public @Nullable String exp() {
        return cursor.get("exp", ScalarType.STRING);
    }

    @Override
    public String originTracker() {
        return cursor.getRequired("originTracker", ScalarType.STRING);
    }

    @Override
    public String proxy() {
        return cursor.getRequired("proxy", ScalarType.STRING);
    }

    @Override
    public String telemetry() {
        return cursor.getRequired("telemetry", ScalarType.STRING);
    }
}
