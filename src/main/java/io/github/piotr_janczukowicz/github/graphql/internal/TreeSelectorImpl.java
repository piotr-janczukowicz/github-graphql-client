package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TreeEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TreeSelector;
import java.util.List;
import java.util.function.Function;

/** Reads and records the fields of {@code Tree}; used by the generated selection code only. */
final class TreeSelectorImpl implements TreeSelector {

    private final Cursor cursor;

    TreeSelectorImpl(final Cursor cursor) {
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
    public <R> List<R> entries(final Function<TreeEntrySelector, R> selection) {
        return cursor.list("entries", child -> selection.apply(new TreeEntrySelectorImpl(child)));
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
}
