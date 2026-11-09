package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code User.sponsorsActivities}; an argument left {@code null} is not sent. */
@RecordBuilder
public record UserSponsorsActivitiesFilter(
        @Nullable List<SponsorsActivityAction> actions,
        @Nullable Boolean includeAsSponsor,
        @Nullable Boolean includePrivate,
        @Nullable SponsorsActivityOrder orderBy,
        @Nullable SponsorsActivityPeriod period,
        @Nullable Instant since,
        @Nullable Instant until) {

    public UserSponsorsActivitiesFilter {
        actions = ListUtils.copyOrNull(actions);
    }
}
