package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DraftIssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DraftIssue}; used by the generated selection code only. */
final class DraftIssueSelectorImpl implements DraftIssueSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private final Cursor cursor;

    DraftIssueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
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
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public String bodyHTML() {
        return cursor.getRequired("bodyHTML", ScalarType.STRING);
    }

    @Override
    public String bodyText() {
        return cursor.getRequired("bodyText", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R creator(final Function<ActorSelector, R> selection) {
        return cursor.object("creator", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> projectV2Items(final Paging paging, final Function<ProjectV2ItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "projectV2Items",
                child -> selection.apply(new ProjectV2ItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> projectsV2(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "projectsV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
