package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorsGoalKind;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsGoalSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SponsorsGoal}; used by the generated selection code only. */
final class SponsorsGoalSelectorImpl implements SponsorsGoalSelector {

    private final Cursor cursor;

    SponsorsGoalSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public SponsorsGoalKind kind() {
        return cursor.getRequired(
                "kind",
                ScalarType.enumeration(SponsorsGoalKind::fromWire, SponsorsGoalKind.MONTHLY_SPONSORSHIP_AMOUNT));
    }

    @Override
    public int percentComplete() {
        return cursor.getRequired("percentComplete", ScalarType.INT);
    }

    @Override
    public int targetValue() {
        return cursor.getRequired("targetValue", ScalarType.INT);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }
}
