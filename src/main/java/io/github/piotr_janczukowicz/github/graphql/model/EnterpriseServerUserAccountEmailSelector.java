package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;

/** Selection of the GraphQL type {@code EnterpriseServerUserAccountEmail}. */
public interface EnterpriseServerUserAccountEmailSelector {

    Instant createdAt();

    String email();

    String id();

    boolean isPrimary();

    Instant updatedAt();

    <R> R userAccount(Function<EnterpriseServerUserAccountSelector, R> selection);
}
