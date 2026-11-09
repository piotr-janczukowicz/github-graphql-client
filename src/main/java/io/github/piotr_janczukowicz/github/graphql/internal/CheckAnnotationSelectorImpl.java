package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationLevel;
import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationSpanSelector;
import java.math.BigInteger;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code CheckAnnotation}; used by the generated selection code only. */
final class CheckAnnotationSelectorImpl implements CheckAnnotationSelector {

    private final Cursor cursor;

    CheckAnnotationSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable CheckAnnotationLevel annotationLevel() {
        return cursor.get(
                "annotationLevel",
                ScalarType.enumeration(CheckAnnotationLevel::fromWire, CheckAnnotationLevel.FAILURE));
    }

    @Override
    public String blobUrl() {
        return cursor.getRequired("blobUrl", ScalarType.STRING);
    }

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2027-01-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public <R> R location(final Function<CheckAnnotationSpanSelector, R> selection) {
        return cursor.objectRequired("location", child -> selection.apply(new CheckAnnotationSpanSelectorImpl(child)));
    }

    @Override
    public String message() {
        return cursor.getRequired("message", ScalarType.STRING);
    }

    @Override
    public String path() {
        return cursor.getRequired("path", ScalarType.STRING);
    }

    @Override
    public @Nullable String rawDetails() {
        return cursor.get("rawDetails", ScalarType.STRING);
    }

    @Override
    public @Nullable String title() {
        return cursor.get("title", ScalarType.STRING);
    }
}
