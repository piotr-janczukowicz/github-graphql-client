package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code GitObject}; used by the generated selection code only. */
final class GitObjectSelectorImpl implements GitObjectSelector {

    private final Cursor cursor;

    GitObjectSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String abbreviatedOid() {
        return cursor.getRequired("abbreviatedOid", ScalarType.STRING);
    }

    @Override
    public String commitResourcePath() {
        return cursor.getRequired("commitResourcePath", ScalarType.STRING);
    }

    @Override
    public String commitUrl() {
        return cursor.getRequired("commitUrl", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String oid() {
        return cursor.getRequired("oid", ScalarType.STRING);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, GitObjectSelector.class, type, selection);
    }
}
