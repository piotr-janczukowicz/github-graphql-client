package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateIpAllowListEntryPayload}. */
public interface CreateIpAllowListEntryPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R ipAllowListEntry(Function<IpAllowListEntrySelector, R> selection);
}
