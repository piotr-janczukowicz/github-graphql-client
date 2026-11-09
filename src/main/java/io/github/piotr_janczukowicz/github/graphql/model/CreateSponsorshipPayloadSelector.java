package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CreateSponsorshipPayload}. */
public interface CreateSponsorshipPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R sponsorship(Function<SponsorshipSelector, R> selection);
}
