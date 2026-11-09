package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The optional arguments of {@code Organization.totalSponsorshipAmountAsSponsorInCents}; an argument left {@code null}
 * is not sent.
 */
@RecordBuilder
public record OrganizationTotalSponsorshipAmountAsSponsorInCentsFilter(
        @Nullable Instant since,
        @Nullable List<String> sponsorableLogins,
        @Nullable Instant until) {

    public OrganizationTotalSponsorshipAmountAsSponsorInCentsFilter {
        sponsorableLogins = ListUtils.copyOrNull(sponsorableLogins);
    }
}
