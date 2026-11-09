package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberAuditEntryMembershipSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code OrgRestoreMemberAuditEntryMembership}; used by the generated selection code
 * only.
 */
final class OrgRestoreMemberAuditEntryMembershipSelectorImpl implements OrgRestoreMemberAuditEntryMembershipSelector {

    private final Cursor cursor;

    OrgRestoreMemberAuditEntryMembershipSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, OrgRestoreMemberAuditEntryMembershipSelector.class, type, selection);
    }
}
