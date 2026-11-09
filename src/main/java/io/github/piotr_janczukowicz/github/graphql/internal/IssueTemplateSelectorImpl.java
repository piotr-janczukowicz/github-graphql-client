package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTemplateLabelsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTemplateLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTemplateSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code IssueTemplate}; used by the generated selection code only. */
final class IssueTemplateSelectorImpl implements IssueTemplateSelector {

    private final Cursor cursor;

    IssueTemplateSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String about() {
        return cursor.get("about", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> assignees(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "assignees",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public @Nullable String body() {
        return cursor.get("body", ScalarType.STRING);
    }

    @Override
    public String filename() {
        return cursor.getRequired("filename", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> labels(
            final Paging paging,
            final IssueTemplateLabelsFilter arguments,
            final Function<LabelSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "labels",
                child -> selection.apply(new LabelSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "LabelOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> labels(final Paging paging, final Function<LabelSelector, R> selection) {
        return labels(paging, IssueTemplateLabelsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public @Nullable String title() {
        return cursor.get("title", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R type(final Function<IssueTypeSelector, R> selection) {
        return cursor.object("type", child -> selection.apply(new IssueTypeSelectorImpl(child)));
    }
}
