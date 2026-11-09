package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.OrgRestoreMemberMembershipRepositoryAuditEntryDataSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code OrgRestoreMemberMembershipRepositoryAuditEntryData}; used by the generated
 * selection code only.
 */
final class OrgRestoreMemberMembershipRepositoryAuditEntryDataSelectorImpl
        implements OrgRestoreMemberMembershipRepositoryAuditEntryDataSelector {

    private final Cursor cursor;

    OrgRestoreMemberMembershipRepositoryAuditEntryDataSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public @Nullable String repositoryName() {
        return cursor.get("repositoryName", ScalarType.STRING);
    }

    @Override
    public @Nullable String repositoryResourcePath() {
        return cursor.get("repositoryResourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable String repositoryUrl() {
        return cursor.get("repositoryUrl", ScalarType.STRING);
    }
}
