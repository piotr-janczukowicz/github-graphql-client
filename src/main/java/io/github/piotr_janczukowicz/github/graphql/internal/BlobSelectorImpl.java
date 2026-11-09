package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BlobSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Blob}; used by the generated selection code only. */
final class BlobSelectorImpl implements BlobSelector {

    private final Cursor cursor;

    BlobSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String abbreviatedOid() {
        return cursor.getRequired("abbreviatedOid", ScalarType.STRING);
    }

    @Override
    public int byteSize() {
        return cursor.getRequired("byteSize", ScalarType.INT);
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
    public @Nullable Boolean isBinary() {
        return cursor.get("isBinary", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isTruncated() {
        return cursor.getRequired("isTruncated", ScalarType.BOOLEAN);
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
    public @Nullable String text() {
        return cursor.get("text", ScalarType.STRING);
    }
}
