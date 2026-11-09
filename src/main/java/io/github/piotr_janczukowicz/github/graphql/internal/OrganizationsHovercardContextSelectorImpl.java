package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationsHovercardContextRelevantOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationsHovercardContextRelevantOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationsHovercardContextSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code OrganizationsHovercardContext}; used by the generated selection code only. */
final class OrganizationsHovercardContextSelectorImpl implements OrganizationsHovercardContextSelector {

    private final Cursor cursor;

    OrganizationsHovercardContextSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String message() {
        return cursor.getRequired("message", ScalarType.STRING);
    }

    @Override
    public String octicon() {
        return cursor.getRequired("octicon", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> relevantOrganizations(
            final Paging paging,
            final OrganizationsHovercardContextRelevantOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "relevantOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of(
                        "orderBy",
                        "OrganizationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> relevantOrganizations(final Paging paging, final Function<OrganizationSelector, R> selection) {
        return relevantOrganizations(
                paging,
                OrganizationsHovercardContextRelevantOrganizationsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public int totalOrganizationCount() {
        return cursor.getRequired("totalOrganizationCount", ScalarType.INT);
    }
}
