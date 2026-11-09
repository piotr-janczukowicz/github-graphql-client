package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdatePatreonSponsorabilityPayload}. */
public interface UpdatePatreonSponsorabilityPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R sponsorsListing(Function<SponsorsListingSelector, R> selection);
}
