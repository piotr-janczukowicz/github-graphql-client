package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code OrganizationTeamsHovercardContext}. */
public interface OrganizationTeamsHovercardContextSelector {

    String message();

    String octicon();

    <R> Page<R> relevantTeams(Paging paging, Function<TeamSelector, R> selection);

    String teamsResourcePath();

    String teamsUrl();

    int totalTeamCount();
}
