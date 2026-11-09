package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldDateValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldDateValue}; used by the generated selection code only. */
final class IssueFieldDateValueSelectorImpl implements IssueFieldDateValueSelector {

    private final Cursor cursor;

    IssueFieldDateValueSelectorImpl(final Cursor cursor) {
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
    public String value() {
        return cursor.getRequired("value", ScalarType.STRING);
    }
}
