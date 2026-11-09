package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The optional arguments of {@code Organization.innersourceVulnerabilities}; an argument left {@code null} is not sent.
 */
@RecordBuilder
public record OrganizationInnersourceVulnerabilitiesFilter(
        @Nullable SecurityAdvisoryEcosystem ecosystem,
        @Nullable SecurityVulnerabilityOrder orderBy,
        @Nullable String packageValue,
        @Nullable List<SecurityAdvisorySeverity> severities) {

    public OrganizationInnersourceVulnerabilitiesFilter {
        severities = ListUtils.copyOrNull(severities);
    }
}
