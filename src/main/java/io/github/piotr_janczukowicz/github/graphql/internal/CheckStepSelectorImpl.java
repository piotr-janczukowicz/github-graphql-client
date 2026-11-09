package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CheckConclusionState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStatusState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckStepSelector;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CheckStep}; used by the generated selection code only. */
final class CheckStepSelectorImpl implements CheckStepSelector {

    private final Cursor cursor;

    CheckStepSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Instant completedAt() {
        return cursor.get("completedAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable CheckConclusionState conclusion() {
        return cursor.get(
                "conclusion",
                ScalarType.enumeration(CheckConclusionState::fromWire, CheckConclusionState.ACTION_REQUIRED));
    }

    @Override
    public @Nullable String externalId() {
        return cursor.get("externalId", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public int number() {
        return cursor.getRequired("number", ScalarType.INT);
    }

    @Override
    public @Nullable Integer secondsToCompletion() {
        return cursor.get("secondsToCompletion", ScalarType.INT);
    }

    @Override
    public @Nullable Instant startedAt() {
        return cursor.get("startedAt", ScalarType.INSTANT);
    }

    @Override
    public CheckStatusState status() {
        return cursor.getRequired(
                "status", ScalarType.enumeration(CheckStatusState::fromWire, CheckStatusState.COMPLETED));
    }
}
