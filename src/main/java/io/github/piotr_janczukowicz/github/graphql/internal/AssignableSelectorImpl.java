package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AssignableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssignableSuggestedActorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.AssignableSuggestedActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.AssigneeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Assignable}; used by the generated selection code only. */
final class AssignableSelectorImpl implements AssignableSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private final Cursor cursor;

    AssignableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> assignedActors(final Paging paging, final Function<AssigneeSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "assignedActors",
                child -> selection.apply(new AssigneeSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> assignees(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "assignees",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> suggestedActors(
            final Paging paging,
            final AssignableSuggestedActorsFilter arguments,
            final Function<AssigneeSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "suggestedActors",
                child -> selection.apply(new AssigneeSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("query", STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> suggestedActors(final Paging paging, final Function<AssigneeSelector, R> selection) {
        return suggestedActors(
                paging, AssignableSuggestedActorsFilterBuilder.builder().build(), selection);
    }

    @Override
    public boolean viewerCanAssign() {
        return cursor.getRequired("viewerCanAssign", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, AssignableSelector.class, type, selection);
    }
}
