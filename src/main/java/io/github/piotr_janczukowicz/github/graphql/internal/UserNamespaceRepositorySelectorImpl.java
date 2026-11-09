package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserNamespaceRepositorySelector;
import java.util.function.Function;

/** Reads and records the fields of {@code UserNamespaceRepository}; used by the generated selection code only. */
final class UserNamespaceRepositorySelectorImpl implements UserNamespaceRepositorySelector {

    private final Cursor cursor;

    UserNamespaceRepositorySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String nameWithOwner() {
        return cursor.getRequired("nameWithOwner", ScalarType.STRING);
    }

    @Override
    public <R> R owner(final Function<RepositoryOwnerSelector, R> selection) {
        return cursor.objectRequired("owner", child -> selection.apply(new RepositoryOwnerSelectorImpl(child)));
    }
}
