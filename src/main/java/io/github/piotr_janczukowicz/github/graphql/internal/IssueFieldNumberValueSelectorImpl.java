package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldNumberValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldNumberValue}; used by the generated selection code only. */
final class IssueFieldNumberValueSelectorImpl implements IssueFieldNumberValueSelector {

    private final Cursor cursor;

    IssueFieldNumberValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R field(final Function<IssueFieldsSelector, R> selection) {
        return cursor.object("field", child -> selection.apply(new IssueFieldsSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public double value() {
        return cursor.getRequired("value", ScalarType.FLOAT);
    }
}
