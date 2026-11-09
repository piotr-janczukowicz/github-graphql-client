package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Sponsorable.sponsorshipsAsSponsor}; an argument left {@code null} is not sent. */
@RecordBuilder
public record SponsorableSponsorshipsAsSponsorFilter(
        @Nullable Boolean activeOnly,
        @Nullable List<String> maintainerLogins,
        @Nullable SponsorshipOrder orderBy) {

    public SponsorableSponsorshipsAsSponsorFilter {
        maintainerLogins = ListUtils.copyOrNull(maintainerLogins);
    }
}
