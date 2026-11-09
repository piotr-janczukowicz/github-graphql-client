package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ExternalIdentitySamlAttributes}. */
public interface ExternalIdentitySamlAttributesSelector {

    <R> List<R> attributes(Function<ExternalIdentityAttributeSelector, R> selection);

    <R> List<R> emails(Function<UserEmailMetadataSelector, R> selection);

    @Nullable String familyName();

    @Nullable String givenName();

    List<String> groups();

    @Nullable String nameId();

    @Nullable String username();
}
