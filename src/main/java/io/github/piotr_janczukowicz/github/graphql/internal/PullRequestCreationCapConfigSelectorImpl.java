package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCreationCapConfigSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code PullRequestCreationCapConfig}; used by the generated selection code only. */
final class PullRequestCreationCapConfigSelectorImpl implements PullRequestCreationCapConfigSelector {

    private final Cursor cursor;

    PullRequestCreationCapConfigSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> bypassedUsers(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "bypassedUsers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
