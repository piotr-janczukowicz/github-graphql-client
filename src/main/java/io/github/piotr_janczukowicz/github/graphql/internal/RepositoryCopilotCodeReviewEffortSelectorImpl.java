package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewEffortLevel;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCopilotCodeReviewEffortSelector;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RepositoryCopilotCodeReviewEffort}; used by the generated selection code only.
 */
final class RepositoryCopilotCodeReviewEffortSelectorImpl implements RepositoryCopilotCodeReviewEffortSelector {

    private final Cursor cursor;

    RepositoryCopilotCodeReviewEffortSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable CopilotCodeReviewEffortLevel configured() {
        return cursor.get(
                "configured",
                ScalarType.enumeration(CopilotCodeReviewEffortLevel::fromWire, CopilotCodeReviewEffortLevel.AUTO));
    }

    @Override
    public CopilotCodeReviewEffortLevel effective() {
        return cursor.getRequired(
                "effective",
                ScalarType.enumeration(CopilotCodeReviewEffortLevel::fromWire, CopilotCodeReviewEffortLevel.AUTO));
    }
}
