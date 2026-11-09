package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.StarrableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StarrableStargazersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.StarrableStargazersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Starrable}; used by the generated selection code only. */
final class StarrableSelectorImpl implements StarrableSelector {

    private final Cursor cursor;

    StarrableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public int stargazerCount() {
        return cursor.getRequired("stargazerCount", ScalarType.INT);
    }

    @Override
    public <R> Page<R> stargazers(
            final Paging paging, final StarrableStargazersFilter arguments, final Function<UserSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "stargazers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "StarOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> stargazers(final Paging paging, final Function<UserSelector, R> selection) {
        return stargazers(paging, StarrableStargazersFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean viewerHasStarred() {
        return cursor.getRequired("viewerHasStarred", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, StarrableSelector.class, type, selection);
    }
}
