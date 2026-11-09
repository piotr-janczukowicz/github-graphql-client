package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RemoveEnterpriseMemberPayload}. */
public interface RemoveEnterpriseMemberPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R enterprise(Function<EnterpriseSelector, R> selection);

    <R> @Nullable R user(Function<UserSelector, R> selection);

    <R> @Nullable R viewer(Function<UserSelector, R> selection);
}
