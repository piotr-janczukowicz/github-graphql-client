package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewSourceKind;
import io.github.piotr_janczukowicz.github.graphql.model.CopilotCodeReviewSourceSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CopilotCodeReviewSource}; used by the generated selection code only. */
final class CopilotCodeReviewSourceSelectorImpl implements CopilotCodeReviewSourceSelector {

    private final Cursor cursor;

    CopilotCodeReviewSourceSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public CopilotCodeReviewSourceKind kind() {
        return cursor.getRequired(
                "kind",
                ScalarType.enumeration(
                        CopilotCodeReviewSourceKind::fromWire, CopilotCodeReviewSourceKind.CUSTOM_INSTRUCTIONS));
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public @Nullable String path() {
        return cursor.get("path", ScalarType.STRING);
    }
}
