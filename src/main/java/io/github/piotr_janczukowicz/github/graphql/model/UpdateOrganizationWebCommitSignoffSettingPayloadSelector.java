package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateOrganizationWebCommitSignoffSettingPayload}. */
public interface UpdateOrganizationWebCommitSignoffSettingPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String message();

    <R> @Nullable R organization(Function<OrganizationSelector, R> selection);
}
