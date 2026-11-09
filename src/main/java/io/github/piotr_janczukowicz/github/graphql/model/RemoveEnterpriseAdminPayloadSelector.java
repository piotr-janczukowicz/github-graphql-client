package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RemoveEnterpriseAdminPayload}. */
public interface RemoveEnterpriseAdminPayloadSelector {

    <R> @Nullable R admin(Function<UserSelector, R> selection);

    @Nullable String clientMutationId();

    <R> @Nullable R enterprise(Function<EnterpriseSelector, R> selection);

    @Nullable String message();

    <R> @Nullable R viewer(Function<UserSelector, R> selection);
}
