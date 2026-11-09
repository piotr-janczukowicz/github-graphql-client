package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CommitMessagePatternParametersSelector;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CommitMessagePatternParameters}; used by the generated selection code only.
 */
final class CommitMessagePatternParametersSelectorImpl implements CommitMessagePatternParametersSelector {

    private final Cursor cursor;

    CommitMessagePatternParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String name() {
        return cursor.get("name", ScalarType.STRING);
    }

    @Override
    public boolean negate() {
        return cursor.getRequired("negate", ScalarType.BOOLEAN);
    }

    @Override
    public String operator() {
        return cursor.getRequired("operator", ScalarType.STRING);
    }

    @Override
    public String pattern() {
        return cursor.getRequired("pattern", ScalarType.STRING);
    }
}
