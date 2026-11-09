package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeColor;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeIssuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueType}; used by the generated selection code only. */
final class IssueTypeSelectorImpl implements IssueTypeSelector {

    private final Cursor cursor;

    IssueTypeSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public IssueTypeColor color() {
        return cursor.getRequired("color", ScalarType.enumeration(IssueTypeColor::fromWire, IssueTypeColor.BLUE));
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isEnabled() {
        return cursor.getRequired("isEnabled", ScalarType.BOOLEAN);
    }

    /** @deprecated Private issue types are being deprecated and can no longer be created. Removal on 2025-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public boolean isPrivate() {
        return cursor.getRequired("isPrivate", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> issues(
            final String repositoryId,
            final Paging paging,
            final IssueTypeIssuesFilter arguments,
            final Function<IssueSelector, R> selection) {
        requireNonNull(repositoryId, "repositoryId");
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "issues",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "filterBy",
                        "IssueFilters",
                        arguments.filterBy() == null
                                ? null
                                : arguments.filterBy().toVariable()),
                Argument.of("labels", "[String!]", arguments.labels()),
                Argument.of(
                        "orderBy",
                        "IssueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("repositoryId", "ID!", repositoryId),
                Argument.of("states", "[IssueState!]", arguments.states()));
    }

    @Override
    public <R> Page<R> issues(
            final String repositoryId, final Paging paging, final Function<IssueSelector, R> selection) {
        return issues(
                repositoryId, paging, IssueTypeIssuesFilterBuilder.builder().build(), selection);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> List<R> pinnedFields(final Function<IssueFieldsSelector, R> selection) {
        return cursor.list("pinnedFields", child -> selection.apply(new IssueFieldsSelectorImpl(child)));
    }
}
