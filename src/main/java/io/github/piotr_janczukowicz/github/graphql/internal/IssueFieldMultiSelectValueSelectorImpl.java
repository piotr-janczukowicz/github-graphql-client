package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldMultiSelectValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldMultiSelectValue}; used by the generated selection code only. */
final class IssueFieldMultiSelectValueSelectorImpl implements IssueFieldMultiSelectValueSelector {

    private final Cursor cursor;

    IssueFieldMultiSelectValueSelectorImpl(final Cursor cursor) {
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
    public <R> List<R> options(final Function<IssueFieldSingleSelectOptionSelector, R> selection) {
        return cursor.listRequired(
                "options", child -> selection.apply(new IssueFieldSingleSelectOptionSelectorImpl(child)));
    }

    @Override
    public @Nullable String value() {
        return cursor.get("value", ScalarType.STRING);
    }
}
