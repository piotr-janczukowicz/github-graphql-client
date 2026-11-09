package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ReleaseAsset}. */
public interface ReleaseAssetSelector {

    String contentType();

    Instant createdAt();

    @Nullable String digest();

    int downloadCount();

    String downloadUrl();

    String id();

    String name();

    <R> @Nullable R release(Function<ReleaseSelector, R> selection);

    int size();

    Instant updatedAt();

    <R> R uploadedBy(Function<UserSelector, R> selection);

    String url();
}
