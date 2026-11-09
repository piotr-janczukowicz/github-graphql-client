package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberMembershipTeamAuditEntryDataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code OrgRestoreMemberMembershipTeamAuditEntryData}; used by the generated selection
 * code only.
 */
final class OrgRestoreMemberMembershipTeamAuditEntryDataSelectorImpl
        implements OrgRestoreMemberMembershipTeamAuditEntryDataSelector {

    private final Cursor cursor;

    OrgRestoreMemberMembershipTeamAuditEntryDataSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R team(final Function<TeamSelector, R> selection) {
        return cursor.object("team", child -> selection.apply(new TeamSelectorImpl(child)));
    }

    @Override
    public @Nullable String teamName() {
        return cursor.get("teamName", ScalarType.STRING);
    }

    @Override
    public @Nullable String teamResourcePath() {
        return cursor.get("teamResourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable String teamUrl() {
        return cursor.get("teamUrl", ScalarType.STRING);
    }
}
