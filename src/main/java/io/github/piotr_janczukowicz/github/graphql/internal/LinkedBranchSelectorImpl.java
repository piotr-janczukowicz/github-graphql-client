package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.LinkedBranchSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code LinkedBranch}; used by the generated selection code only. */
final class LinkedBranchSelectorImpl implements LinkedBranchSelector {

    private final Cursor cursor;

    LinkedBranchSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R ref(final Function<RefSelector, R> selection) {
        return cursor.object("ref", child -> selection.apply(new RefSelectorImpl(child)));
    }
}
