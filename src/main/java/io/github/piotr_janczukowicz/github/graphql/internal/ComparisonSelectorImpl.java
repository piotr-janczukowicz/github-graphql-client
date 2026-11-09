package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ComparisonSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ComparisonStatus;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code Comparison}; used by the generated selection code only. */
final class ComparisonSelectorImpl implements ComparisonSelector {

    private final Cursor cursor;

    ComparisonSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int aheadBy() {
        return cursor.getRequired("aheadBy", ScalarType.INT);
    }

    @Override
    public <R> R baseTarget(final Function<GitObjectSelector, R> selection) {
        return cursor.objectRequired("baseTarget", child -> selection.apply(new GitObjectSelectorImpl(child)));
    }

    @Override
    public int behindBy() {
        return cursor.getRequired("behindBy", ScalarType.INT);
    }

    @Override
    public <R> Page<R> commits(final Paging paging, final Function<CommitSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "commits",
                child -> selection.apply(new CommitSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public <R> R headTarget(final Function<GitObjectSelector, R> selection) {
        return cursor.objectRequired("headTarget", child -> selection.apply(new GitObjectSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public ComparisonStatus status() {
        return cursor.getRequired("status", ScalarType.enumeration(ComparisonStatus::fromWire, ComparisonStatus.AHEAD));
    }
}
