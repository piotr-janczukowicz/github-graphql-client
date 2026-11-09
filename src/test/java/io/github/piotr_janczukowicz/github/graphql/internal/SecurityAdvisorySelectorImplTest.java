package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CVSSSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CWESelector;
import io.github.piotr_janczukowicz.github.graphql.model.EPSSSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryClassification;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryEcosystem;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryIdentifierSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryReferenceSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisorySeverity;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityAdvisoryVulnerabilitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilityOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilityOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.SecurityVulnerabilitySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class SecurityAdvisorySelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"classification\":\"GENERAL\"" + "," + "\"cveId\":\"x\"" + ","
            + "\"cvss\":{\"score\": 1.5}" + "," + "\"cvssSeverities\":{\"cvssV3\": {\"score\": 1.5}}" + ","
            + "\"cwes\":{\"nodes\": [{\"cweId\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"databaseId\":1" + "," + "\"description\":\"x\"" + "," + "\"epss\":{\"percentage\": 1.5}" + ","
            + "\"ghsaId\":\"x\"" + "," + "\"githubReviewedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + ","
            + "\"identifiers\":[{\"type\": \"x\"}]" + "," + "\"notificationsPermalink\":\"x\"" + ","
            + "\"nvdPublishedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"origin\":\"x\"" + "," + "\"permalink\":\"x\""
            + "," + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"references\":[{\"url\": \"x\"}]" + ","
            + "\"repositoryAdvisoryUrl\":\"x\"" + "," + "\"severity\":\"CRITICAL\"" + ","
            + "\"sourceCodeLocation\":\"x\"" + "," + "\"summary\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"vulnerabilities\":{\"nodes\": [{\"severity\": \"CRITICAL\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"withdrawnAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final SecurityAdvisorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.classification());
        values.add(selector.cveId());
        values.add(selector.cvss(CVSSSelector::score));
        values.add(selector.cvssSeverities(child -> child.cvssV3(CVSSSelector::score)));
        values.add(selector.cwes(Paging.first(1), CWESelector::cweId));
        values.add(selector.databaseId());
        values.add(selector.description());
        values.add(selector.epss(EPSSSelector::percentage));
        values.add(selector.ghsaId());
        values.add(selector.githubReviewedAt());
        values.add(selector.id());
        values.add(selector.identifiers(SecurityAdvisoryIdentifierSelector::type));
        values.add(selector.notificationsPermalink());
        values.add(selector.nvdPublishedAt());
        values.add(selector.origin());
        values.add(selector.permalink());
        values.add(selector.publishedAt());
        values.add(selector.references(SecurityAdvisoryReferenceSelector::url));
        values.add(selector.repositoryAdvisoryUrl());
        values.add(selector.severity());
        values.add(selector.sourceCodeLocation());
        values.add(selector.summary());
        values.add(selector.updatedAt());
        values.add(selector.vulnerabilities(
                Paging.first(1),
                SecurityAdvisoryVulnerabilitiesFilterBuilder.builder()
                        .classifications(List.of(SecurityAdvisoryClassification.GENERAL))
                        .ecosystem(SecurityAdvisoryEcosystem.ACTIONS)
                        .orderBy(SecurityVulnerabilityOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(SecurityVulnerabilityOrderField.UPDATED_AT)
                                .build())
                        .packageValue("x")
                        .severities(List.of(SecurityAdvisorySeverity.CRITICAL))
                        .build(),
                SecurityVulnerabilitySelector::severity));
        values.add(selector.withdrawnAt());
        return values;
    }

    private static List<Object> readWithoutArguments(final SecurityAdvisorySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.vulnerabilities(Paging.first(1), SecurityVulnerabilitySelector::severity));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SecurityAdvisorySelectorImpl(new RecordingCursor(root)));
        final SecurityAdvisorySelectorImpl selector =
                new SecurityAdvisorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        SecurityAdvisoryClassification.GENERAL,
                        "x",
                        1.5,
                        1.5,
                        new Page<>(List.of("x"), false, null),
                        1,
                        "x",
                        1.5,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        List.of("x"),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        List.of("x"),
                        "x",
                        SecurityAdvisorySeverity.CRITICAL,
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(SecurityAdvisorySeverity.CRITICAL), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new SecurityAdvisorySelectorImpl(new RecordingCursor(root)));
        final SecurityAdvisorySelectorImpl selector =
                new SecurityAdvisorySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(SecurityAdvisorySeverity.CRITICAL), false, null));
    }
}
