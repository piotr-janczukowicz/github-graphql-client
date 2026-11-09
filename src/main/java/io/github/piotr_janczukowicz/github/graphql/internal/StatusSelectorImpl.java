package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckRollupContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusState;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Status}; used by the generated selection code only. */
final class StatusSelectorImpl implements StatusSelector {

    private final Cursor cursor;

    StatusSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> combinedContexts(
            final Paging paging, final Function<StatusCheckRollupContextSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "combinedContexts",
                child -> selection.apply(new StatusCheckRollupContextSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public <R> @Nullable R commit(final Function<CommitSelector, R> selection) {
        return cursor.object("commit", child -> selection.apply(new CommitSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R context(final String name, final Function<StatusContextSelector, R> selection) {
        requireNonNull(name, "name");
        return cursor.object(
                "context",
                child -> selection.apply(new StatusContextSelectorImpl(child)),
                Argument.of("name", "String!", name));
    }

    @Override
    public <R> List<R> contexts(final Function<StatusContextSelector, R> selection) {
        return cursor.listRequired("contexts", child -> selection.apply(new StatusContextSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public StatusState state() {
        return cursor.getRequired("state", ScalarType.enumeration(StatusState::fromWire, StatusState.ERROR));
    }
}
