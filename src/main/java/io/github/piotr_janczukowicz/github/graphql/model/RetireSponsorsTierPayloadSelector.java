package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RetireSponsorsTierPayload}. */
public interface RetireSponsorsTierPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R sponsorsTier(Function<SponsorsTierSelector, R> selection);
}
