package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectOptionColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldSingleSelectValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueFieldSingleSelectValue}; used by the generated selection code only. */
final class IssueFieldSingleSelectValueSelectorImpl implements IssueFieldSingleSelectValueSelector {

    private final Cursor cursor;

    IssueFieldSingleSelectValueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public IssueFieldSingleSelectOptionColor color() {
        return cursor.getRequired(
                "color",
                ScalarType.enumeration(
                        IssueFieldSingleSelectOptionColor::fromWire, IssueFieldSingleSelectOptionColor.BLUE));
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
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
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public @Nullable String optionId() {
        return cursor.get("optionId", ScalarType.STRING);
    }

    @Override
    public String value() {
        return cursor.getRequired("value", ScalarType.STRING);
    }
}
