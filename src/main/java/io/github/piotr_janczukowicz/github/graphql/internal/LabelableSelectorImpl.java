package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelableLabelsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.LabelableLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LabelableSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Labelable}; used by the generated selection code only. */
final class LabelableSelectorImpl implements LabelableSelector {

    private final Cursor cursor;

    LabelableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> labels(
            final Paging paging, final LabelableLabelsFilter arguments, final Function<LabelSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "labels",
                child -> selection.apply(new LabelSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "LabelOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> labels(final Paging paging, final Function<LabelSelector, R> selection) {
        return labels(paging, LabelableLabelsFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean viewerCanLabel() {
        return cursor.getRequired("viewerCanLabel", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, LabelableSelector.class, type, selection);
    }
}
