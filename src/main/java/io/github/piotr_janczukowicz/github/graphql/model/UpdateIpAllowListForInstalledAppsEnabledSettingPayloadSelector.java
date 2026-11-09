package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateIpAllowListForInstalledAppsEnabledSettingPayload}. */
public interface UpdateIpAllowListForInstalledAppsEnabledSettingPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R owner(Function<IpAllowListOwnerSelector, R> selection);
}
