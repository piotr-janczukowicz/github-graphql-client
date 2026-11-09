package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldTextValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldTextValue}; used by the generated selection code only. */
final class IssueFieldTextValueSelectorImpl implements IssueFieldTextValueSelector {

    private final Cursor cursor;

    IssueFieldTextValueSelectorImpl(final Cursor cursor) {
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
