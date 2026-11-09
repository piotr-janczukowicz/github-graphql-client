package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Query.securityAdvisories}; an argument left {@code null} is not sent. */
@RecordBuilder
public record QuerySecurityAdvisoriesFilter(
        @Nullable List<SecurityAdvisoryClassification> classifications,
        @Nullable Double epssPercentage,
        @Nullable Double epssPercentile,
        @Nullable SecurityAdvisoryIdentifierFilter identifier,
        @Nullable Boolean isWithdrawn,
        @Nullable SecurityAdvisoryOrder orderBy,
        @Nullable Instant publishedSince,
        @Nullable List<SecurityAdvisorySeverity> severities,
        @Nullable Instant updatedSince) {

    public QuerySecurityAdvisoriesFilter {
        classifications = ListUtils.copyOrNull(classifications);
        severities = ListUtils.copyOrNull(severities);
    }
}
