package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersErrorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCodeownersSelector;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code RepositoryCodeowners}; used by the generated selection code only. */
final class RepositoryCodeownersSelectorImpl implements RepositoryCodeownersSelector {

    private final Cursor cursor;

    RepositoryCodeownersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> errors(final Function<RepositoryCodeownersErrorSelector, R> selection) {
        return cursor.listRequired(
                "errors", child -> selection.apply(new RepositoryCodeownersErrorSelectorImpl(child)));
    }
}
