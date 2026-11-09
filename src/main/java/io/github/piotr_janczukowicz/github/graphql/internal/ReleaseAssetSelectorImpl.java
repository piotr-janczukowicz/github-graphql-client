package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ReleaseAssetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ReleaseAsset}; used by the generated selection code only. */
final class ReleaseAssetSelectorImpl implements ReleaseAssetSelector {

    private final Cursor cursor;

    ReleaseAssetSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String contentType() {
        return cursor.getRequired("contentType", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String digest() {
        return cursor.get("digest", ScalarType.STRING);
    }

    @Override
    public int downloadCount() {
        return cursor.getRequired("downloadCount", ScalarType.INT);
    }

    @Override
    public String downloadUrl() {
        return cursor.getRequired("downloadUrl", ScalarType.STRING);
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
    public <R> @Nullable R release(final Function<ReleaseSelector, R> selection) {
        return cursor.object("release", child -> selection.apply(new ReleaseSelectorImpl(child)));
    }

    @Override
    public int size() {
        return cursor.getRequired("size", ScalarType.INT);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R uploadedBy(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("uploadedBy", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
