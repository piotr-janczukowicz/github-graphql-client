package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Blob}. */
public interface BlobSelector {

    String abbreviatedOid();

    int byteSize();

    String commitResourcePath();

    String commitUrl();

    String id();

    @Nullable Boolean isBinary();

    boolean isTruncated();

    String oid();

    <R> R repository(Function<RepositorySelector, R> selection);

    @Nullable String text();
}
