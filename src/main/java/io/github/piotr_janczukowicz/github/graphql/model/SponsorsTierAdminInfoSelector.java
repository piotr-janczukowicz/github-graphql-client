package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code SponsorsTierAdminInfo}. */
public interface SponsorsTierAdminInfoSelector {

    boolean isDraft();

    boolean isPublished();

    boolean isRetired();

    <R> Page<R> sponsorships(
            Paging paging,
            SponsorsTierAdminInfoSponsorshipsFilter arguments,
            Function<SponsorshipSelector, R> selection);

    <R> Page<R> sponsorships(Paging paging, Function<SponsorshipSelector, R> selection);
}
