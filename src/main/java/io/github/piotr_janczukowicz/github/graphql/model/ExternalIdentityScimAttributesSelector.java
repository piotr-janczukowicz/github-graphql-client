package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ExternalIdentityScimAttributes}. */
public interface ExternalIdentityScimAttributesSelector {

    <R> List<R> emails(Function<UserEmailMetadataSelector, R> selection);

    @Nullable String familyName();

    @Nullable String givenName();

    List<String> groups();

    @Nullable String username();
}
