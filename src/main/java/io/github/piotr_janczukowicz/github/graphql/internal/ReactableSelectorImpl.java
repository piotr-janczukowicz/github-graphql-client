package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ReactableReactionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ReactableReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Reactable}; used by the generated selection code only. */
final class ReactableSelectorImpl implements ReactableSelector {

    private final Cursor cursor;

    ReactableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> List<R> reactionGroups(final Function<ReactionGroupSelector, R> selection) {
        return cursor.list("reactionGroups", child -> selection.apply(new ReactionGroupSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> reactions(
            final Paging paging,
            final ReactableReactionsFilter arguments,
            final Function<ReactionSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "reactions",
                child -> selection.apply(new ReactionSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("content", "ReactionContent", arguments.content()),
                Argument.of(
                        "orderBy",
                        "ReactionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> reactions(final Paging paging, final Function<ReactionSelector, R> selection) {
        return reactions(paging, ReactableReactionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean viewerCanReact() {
        return cursor.getRequired("viewerCanReact", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, ReactableSelector.class, type, selection);
    }
}
