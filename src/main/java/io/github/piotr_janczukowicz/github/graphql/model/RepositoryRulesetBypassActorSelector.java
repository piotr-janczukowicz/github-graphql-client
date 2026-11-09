package io.github.piotr_janczukowicz.github.graphql.model;

import java.math.BigInteger;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RepositoryRulesetBypassActor}. */
public interface RepositoryRulesetBypassActorSelector {

    <R> @Nullable R actor(Function<BypassActorSelector, R> selection);

    @Nullable RepositoryRulesetBypassActorBypassMode bypassMode();

    boolean deployKey();

    boolean enterpriseOwner();

    boolean enterpriseRole();

    @Nullable BigInteger enterpriseRoleDatabaseId();

    String id();

    boolean organizationAdmin();

    @Nullable Integer repositoryRoleDatabaseId();

    @Nullable String repositoryRoleName();

    <R> @Nullable R repositoryRuleset(Function<RepositoryRulesetSelector, R> selection);
}
