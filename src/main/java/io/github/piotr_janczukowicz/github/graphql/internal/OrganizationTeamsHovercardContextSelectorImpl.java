package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationTeamsHovercardContextSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code OrganizationTeamsHovercardContext}; used by the generated selection code only.
 */
final class OrganizationTeamsHovercardContextSelectorImpl implements OrganizationTeamsHovercardContextSelector {

    private final Cursor cursor;

    OrganizationTeamsHovercardContextSelectorImpl(final Cursor cursor) {
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
    public <R> Page<R> relevantTeams(final Paging paging, final Function<TeamSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "relevantTeams",
                child -> selection.apply(new TeamSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public String teamsResourcePath() {
        return cursor.getRequired("teamsResourcePath", ScalarType.STRING);
    }

    @Override
    public String teamsUrl() {
        return cursor.getRequired("teamsUrl", ScalarType.STRING);
    }

    @Override
    public int totalTeamCount() {
        return cursor.getRequired("totalTeamCount", ScalarType.INT);
    }
}
