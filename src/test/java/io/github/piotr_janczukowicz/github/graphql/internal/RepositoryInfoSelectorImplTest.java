package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueCreationPolicy;
import io.github.piotr_janczukowicz.github.graphql.model.LicenseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestCreationPolicy;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInfoShortDescriptionHTMLFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryLockReason;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryInfoSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"archivedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"description\":\"x\"" + ","
            + "\"descriptionHTML\":\"x\"" + "," + "\"forkCount\":1" + "," + "\"hasDiscussionsEnabled\":true" + ","
            + "\"hasIssuesEnabled\":true" + "," + "\"hasProjectsEnabled\":true" + ","
            + "\"hasPullRequestsEnabled\":true" + "," + "\"hasSponsorshipsEnabled\":true" + ","
            + "\"hasWikiEnabled\":true" + "," + "\"homepageUrl\":\"x\"" + "," + "\"isArchived\":true" + ","
            + "\"isFork\":true" + "," + "\"isInOrganization\":true" + "," + "\"isLocked\":true" + ","
            + "\"isMirror\":true" + "," + "\"isPrivate\":true" + "," + "\"isTemplate\":true" + ","
            + "\"issueCreationPolicy\":\"ALL\"" + "," + "\"licenseInfo\":{\"body\": \"x\"}" + ","
            + "\"lockReason\":\"BILLING\"" + "," + "\"mirrorUrl\":\"x\"" + "," + "\"name\":\"x\"" + ","
            + "\"nameWithOwner\":\"x\"" + "," + "\"openGraphImageUrl\":\"x\"" + "," + "\"owner\":{\"avatarUrl\": \"x\"}"
            + "," + "\"pullRequestCreationPolicy\":\"ALL\"" + "," + "\"pushedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"resourcePath\":\"x\"" + "," + "\"shortDescriptionHTML\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + ","
            + "\"usesCustomOpenGraphImage\":true" + "," + "\"visibility\":\"INTERNAL\"" + ","
            + "\"allowUpdateBranch\":true" + "," + "\"__typename\":\"Repository\"" + "}";

    private static List<Object> readWithArguments(final RepositoryInfoSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.archivedAt());
        values.add(selector.createdAt());
        values.add(selector.description());
        values.add(selector.descriptionHTML());
        values.add(selector.forkCount());
        values.add(selector.hasDiscussionsEnabled());
        values.add(selector.hasIssuesEnabled());
        values.add(selector.hasProjectsEnabled());
        values.add(selector.hasPullRequestsEnabled());
        values.add(selector.hasSponsorshipsEnabled());
        values.add(selector.hasWikiEnabled());
        values.add(selector.homepageUrl());
        values.add(selector.isArchived());
        values.add(selector.isFork());
        values.add(selector.isInOrganization());
        values.add(selector.isLocked());
        values.add(selector.isMirror());
        values.add(selector.isPrivate());
        values.add(selector.isTemplate());
        values.add(selector.issueCreationPolicy());
        values.add(selector.licenseInfo(LicenseSelector::body));
        values.add(selector.lockReason());
        values.add(selector.mirrorUrl());
        values.add(selector.name());
        values.add(selector.nameWithOwner());
        values.add(selector.openGraphImageUrl());
        values.add(selector.owner(RepositoryOwnerSelector::avatarUrl));
        values.add(selector.pullRequestCreationPolicy());
        values.add(selector.pushedAt());
        values.add(selector.resourcePath());
        values.add(selector.shortDescriptionHTML(RepositoryInfoShortDescriptionHTMLFilterBuilder.builder()
                .limit(1)
                .build()));
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.usesCustomOpenGraphImage());
        values.add(selector.visibility());
        values.add(selector.on(RepositorySelector.class, RepositorySelector::allowUpdateBranch));
        return values;
    }

    private static List<Object> readWithoutArguments(final RepositoryInfoSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.shortDescriptionHTML());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryInfoSelectorImpl(new RecordingCursor(root)));
        final RepositoryInfoSelectorImpl selector =
                new RepositoryInfoSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        1,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "x",
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        IssueCreationPolicy.ALL,
                        "x",
                        RepositoryLockReason.BILLING,
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        PullRequestCreationPolicy.ALL,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        RepositoryVisibility.INTERNAL,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new RepositoryInfoSelectorImpl(new RecordingCursor(root)));
        final RepositoryInfoSelectorImpl selector =
                new RepositoryInfoSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
