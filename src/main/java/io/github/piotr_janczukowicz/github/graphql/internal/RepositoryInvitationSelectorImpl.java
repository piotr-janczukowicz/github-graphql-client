package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInvitationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPermission;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryInvitation}; used by the generated selection code only. */
final class RepositoryInvitationSelectorImpl implements RepositoryInvitationSelector {

    private final Cursor cursor;

    RepositoryInvitationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String email() {
        return cursor.get("email", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R invitee(final Function<UserSelector, R> selection) {
        return cursor.object("invitee", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public <R> R inviter(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("inviter", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public String permalink() {
        return cursor.getRequired("permalink", ScalarType.STRING);
    }

    @Override
    public RepositoryPermission permission() {
        return cursor.getRequired(
                "permission", ScalarType.enumeration(RepositoryPermission::fromWire, RepositoryPermission.ADMIN));
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositoryInfoSelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositoryInfoSelectorImpl(child)));
    }
}
