package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code OrganizationsHovercardContext}. */
public interface OrganizationsHovercardContextSelector {

    String message();

    String octicon();

    <R> Page<R> relevantOrganizations(
            Paging paging,
            OrganizationsHovercardContextRelevantOrganizationsFilter arguments,
            Function<OrganizationSelector, R> selection);

    <R> Page<R> relevantOrganizations(Paging paging, Function<OrganizationSelector, R> selection);

    int totalOrganizationCount();
}
