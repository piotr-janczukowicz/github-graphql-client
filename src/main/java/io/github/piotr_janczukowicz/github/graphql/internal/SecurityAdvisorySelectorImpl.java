package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CVSSSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CWESelector;
import io.github.piotr_janczukowicz.github.graphql.model.CvssSeveritiesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EPSSSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryClassification;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryIdentifierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryReferenceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySeverity;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryVulnerabilitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryVulnerabilitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilitySelector;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SecurityAdvisory}; used by the generated selection code only. */
final class SecurityAdvisorySelectorImpl implements SecurityAdvisorySelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    SecurityAdvisorySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public SecurityAdvisoryClassification classification() {
        return cursor.getRequired(
                "classification",
                ScalarType.enumeration(
                        SecurityAdvisoryClassification::fromWire, SecurityAdvisoryClassification.GENERAL));
    }

    @Override
    public @Nullable String cveId() {
        return cursor.get("cveId", ScalarType.STRING);
    }

    /**
     * @deprecated `cvss` will be removed. New `cvss_severities` field will now contain both `cvss_v3` and `cvss_v4`
     *     properties. Removal on 2025-10-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public <R> R cvss(final Function<CVSSSelector, R> selection) {
        return cursor.objectRequired("cvss", child -> selection.apply(new CVSSSelectorImpl(child)));
    }

    @Override
    public <R> R cvssSeverities(final Function<CvssSeveritiesSelector, R> selection) {
        return cursor.objectRequired("cvssSeverities", child -> selection.apply(new CvssSeveritiesSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> cwes(final Paging paging, final Function<CWESelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "cwes",
                child -> selection.apply(new CWESelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()));
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public String description() {
        return cursor.getRequired("description", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R epss(final Function<EPSSSelector, R> selection) {
        return cursor.object("epss", child -> selection.apply(new EPSSSelectorImpl(child)));
    }

    @Override
    public String ghsaId() {
        return cursor.getRequired("ghsaId", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant githubReviewedAt() {
        return cursor.get("githubReviewedAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public <R> List<R> identifiers(final Function<SecurityAdvisoryIdentifierSelector, R> selection) {
        return cursor.listRequired(
                "identifiers", child -> selection.apply(new SecurityAdvisoryIdentifierSelectorImpl(child)));
    }

    @Override
    public @Nullable String notificationsPermalink() {
        return cursor.get("notificationsPermalink", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant nvdPublishedAt() {
        return cursor.get("nvdPublishedAt", ScalarType.INSTANT);
    }

    @Override
    public String origin() {
        return cursor.getRequired("origin", ScalarType.STRING);
    }

    @Override
    public @Nullable String permalink() {
        return cursor.get("permalink", ScalarType.STRING);
    }

    @Override
    public Instant publishedAt() {
        return cursor.getRequired("publishedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> List<R> references(final Function<SecurityAdvisoryReferenceSelector, R> selection) {
        return cursor.listRequired(
                "references", child -> selection.apply(new SecurityAdvisoryReferenceSelectorImpl(child)));
    }

    @Override
    public @Nullable String repositoryAdvisoryUrl() {
        return cursor.get("repositoryAdvisoryUrl", ScalarType.STRING);
    }

    @Override
    public SecurityAdvisorySeverity severity() {
        return cursor.getRequired(
                "severity",
                ScalarType.enumeration(SecurityAdvisorySeverity::fromWire, SecurityAdvisorySeverity.CRITICAL));
    }

    @Override
    public @Nullable String sourceCodeLocation() {
        return cursor.get("sourceCodeLocation", ScalarType.STRING);
    }

    @Override
    public String summary() {
        return cursor.getRequired("summary", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> vulnerabilities(
            final Paging paging,
            final SecurityAdvisoryVulnerabilitiesFilter arguments,
            final Function<SecurityVulnerabilitySelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "vulnerabilities",
                child -> selection.apply(new SecurityVulnerabilitySelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of("classifications", "[SecurityAdvisoryClassification!]", arguments.classifications()),
                Argument.of("ecosystem", "SecurityAdvisoryEcosystem", arguments.ecosystem()),
                Argument.of(
                        "orderBy",
                        "SecurityVulnerabilityOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("package", STRING, arguments.packageValue()),
                Argument.of("severities", "[SecurityAdvisorySeverity!]", arguments.severities()));
    }

    @Override
    public <R> Page<R> vulnerabilities(
            final Paging paging, final Function<SecurityVulnerabilitySelector, R> selection) {
        return vulnerabilities(
                paging, SecurityAdvisoryVulnerabilitiesFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Instant withdrawnAt() {
        return cursor.get("withdrawnAt", ScalarType.INSTANT);
    }
}
