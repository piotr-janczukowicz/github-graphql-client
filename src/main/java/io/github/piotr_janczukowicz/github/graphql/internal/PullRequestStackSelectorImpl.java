package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestStackSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code PullRequestStack}; used by the generated selection code only. */
final class PullRequestStackSelectorImpl implements PullRequestStackSelector {

    private final Cursor cursor;

    PullRequestStackSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String baseRefName() {
        return cursor.getRequired("baseRefName", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> entries(final Paging paging, final Function<PullRequestStackEntrySelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "entries",
                child -> selection.apply(new PullRequestStackEntrySelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public int number() {
        return cursor.getRequired("number", ScalarType.INT);
    }

    @Override
    public int size() {
        return cursor.getRequired("size", ScalarType.INT);
    }
}
