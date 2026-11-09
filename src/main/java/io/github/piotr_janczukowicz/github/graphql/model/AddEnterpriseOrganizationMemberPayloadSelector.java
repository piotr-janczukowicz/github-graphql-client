package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AddEnterpriseOrganizationMemberPayload}. */
public interface AddEnterpriseOrganizationMemberPayloadSelector {

    @Nullable String clientMutationId();

    <R> List<R> users(Function<UserSelector, R> selection);
}
