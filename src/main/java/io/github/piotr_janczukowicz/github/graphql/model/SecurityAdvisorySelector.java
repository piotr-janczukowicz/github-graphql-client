package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SecurityAdvisory}. */
public interface SecurityAdvisorySelector {

    SecurityAdvisoryClassification classification();

    @Nullable String cveId();

    /**
     * @deprecated `cvss` will be removed. New `cvss_severities` field will now contain both `cvss_v3` and `cvss_v4`
     *     properties. Removal on 2025-10-01 UTC.
     */
    @Deprecated(forRemoval = true)
    <R> R cvss(Function<CVSSSelector, R> selection);

    <R> R cvssSeverities(Function<CvssSeveritiesSelector, R> selection);

    <R> Page<R> cwes(Paging paging, Function<CWESelector, R> selection);

    @Nullable Integer databaseId();

    String description();

    <R> @Nullable R epss(Function<EPSSSelector, R> selection);

    String ghsaId();

    @Nullable Instant githubReviewedAt();

    String id();

    <R> List<R> identifiers(Function<SecurityAdvisoryIdentifierSelector, R> selection);

    @Nullable String notificationsPermalink();

    @Nullable Instant nvdPublishedAt();

    String origin();

    @Nullable String permalink();

    Instant publishedAt();

    <R> List<R> references(Function<SecurityAdvisoryReferenceSelector, R> selection);

    @Nullable String repositoryAdvisoryUrl();

    SecurityAdvisorySeverity severity();

    @Nullable String sourceCodeLocation();

    String summary();

    Instant updatedAt();

    <R> Page<R> vulnerabilities(
            Paging paging,
            SecurityAdvisoryVulnerabilitiesFilter arguments,
            Function<SecurityVulnerabilitySelector, R> selection);

    <R> Page<R> vulnerabilities(Paging paging, Function<SecurityVulnerabilitySelector, R> selection);

    @Nullable Instant withdrawnAt();
}
