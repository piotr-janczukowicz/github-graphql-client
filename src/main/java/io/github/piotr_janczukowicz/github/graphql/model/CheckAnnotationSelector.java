package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CheckAnnotation}. */
public interface CheckAnnotationSelector {

    @Nullable CheckAnnotationLevel annotationLevel();

    String blobUrl();

    /**
     * @deprecated `databaseId` will be removed because it does not support 64-bit signed integer identifiers. Use
     *     `fullDatabaseId` instead. Removal on 2027-01-01 UTC.
     */
    @Deprecated(forRemoval = true)
    @Nullable Integer databaseId();

    @Nullable BigInteger fullDatabaseId();

    <R> R location(Function<CheckAnnotationSpanSelector, R> selection);

    String message();

    String path();

    @Nullable String rawDetails();

    @Nullable String title();
}
