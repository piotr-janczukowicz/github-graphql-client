package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateSponsorshipPreferencesPayload}. */
public interface UpdateSponsorshipPreferencesPayloadSelector {

    @Nullable String clientMutationId();

    <R> @Nullable R sponsorship(Function<SponsorshipSelector, R> selection);
}
