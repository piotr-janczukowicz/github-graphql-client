package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateIpAllowListEnabledSettingPayload}. */
public interface UpdateIpAllowListEnabledSettingPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R owner(Function<IpAllowListOwnerSelector, R> selection);
}
