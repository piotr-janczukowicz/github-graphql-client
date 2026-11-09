package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateEnterpriseMembersCanDeleteIssuesSettingPayload}. */
public interface UpdateEnterpriseMembersCanDeleteIssuesSettingPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R enterprise(Function<EnterpriseSelector, R> selection);

    @Nullable String message();
}
