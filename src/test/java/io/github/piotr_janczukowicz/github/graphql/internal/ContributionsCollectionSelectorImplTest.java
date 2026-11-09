package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionCommitContributionsByRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionIssueContributionsByRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionIssueContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestContributionsByRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestReviewContributionsByRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestReviewContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalIssueContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalPullRequestContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoriesWithContributedIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoriesWithContributedPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedIssueContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestReviewContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedRepositoryContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.JoinedGitHubContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ContributionsCollectionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"commitContributionsByRepository\":[{\"resourcePath\": \"x\"}]" + ","
            + "\"contributionCalendar\":{\"colors\": [\"x\"]}" + "," + "\"contributionYears\":[1]" + ","
            + "\"doesEndInCurrentMonth\":true" + "," + "\"earliestRestrictedContributionDate\":\"2024-05-01\"" + ","
            + "\"endedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"firstIssueContribution\":{\"__typename\": \"CreatedIssueContribution\", \"isRestricted\": true}" + ","
            + "\"firstPullRequestContribution\":{\"__typename\": \"CreatedPullRequestContribution\", \"isRestricted\": true}"
            + ","
            + "\"firstRepositoryContribution\":{\"__typename\": \"CreatedRepositoryContribution\", \"isRestricted\": true}"
            + "," + "\"hasActivityInThePast\":true" + "," + "\"hasAnyContributions\":true" + ","
            + "\"hasAnyRestrictedContributions\":true" + "," + "\"isSingleDay\":true" + ","
            + "\"issueContributions\":{\"nodes\": [{\"isRestricted\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"issueContributionsByRepository\":[{\"contributions\": {\"nodes\": [{\"isRestricted\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}}]"
            + "," + "\"joinedGitHubContribution\":{\"isRestricted\": true}" + ","
            + "\"latestRestrictedContributionDate\":\"2024-05-01\"" + ","
            + "\"mostRecentCollectionWithActivity\":{\"contributionYears\": [1]}" + ","
            + "\"mostRecentCollectionWithoutActivity\":{\"contributionYears\": [1]}" + ","
            + "\"popularIssueContribution\":{\"isRestricted\": true}" + ","
            + "\"popularPullRequestContribution\":{\"isRestricted\": true}" + ","
            + "\"pullRequestContributions\":{\"nodes\": [{\"isRestricted\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pullRequestContributionsByRepository\":[{\"contributions\": {\"nodes\": [{\"isRestricted\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}}]"
            + ","
            + "\"pullRequestReviewContributions\":{\"nodes\": [{\"isRestricted\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"pullRequestReviewContributionsByRepository\":[{\"contributions\": {\"nodes\": [{\"isRestricted\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}}]"
            + ","
            + "\"repositoryContributions\":{\"nodes\": [{\"isRestricted\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"restrictedContributionsCount\":1" + "," + "\"startedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"totalCommitContributions\":1" + "," + "\"totalIssueContributions\":1" + ","
            + "\"totalPullRequestContributions\":1" + "," + "\"totalPullRequestReviewContributions\":1" + ","
            + "\"totalRepositoriesWithContributedCommits\":1" + "," + "\"totalRepositoriesWithContributedIssues\":1"
            + "," + "\"totalRepositoriesWithContributedPullRequestReviews\":1" + ","
            + "\"totalRepositoriesWithContributedPullRequests\":1" + "," + "\"totalRepositoryContributions\":1" + ","
            + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final ContributionsCollectionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.commitContributionsByRepository(
                ContributionsCollectionCommitContributionsByRepositoryFilterBuilder.builder()
                        .maxRepositories(1)
                        .build(),
                CommitContributionsByRepositorySelector::resourcePath));
        values.add(selector.contributionCalendar(ContributionCalendarSelector::colors));
        values.add(selector.contributionYears());
        values.add(selector.doesEndInCurrentMonth());
        values.add(selector.earliestRestrictedContributionDate());
        values.add(selector.endedAt());
        values.add(selector.firstIssueContribution(child ->
                child.on(CreatedIssueContributionSelector.class, CreatedIssueContributionSelector::isRestricted)));
        values.add(selector.firstPullRequestContribution(child -> child.on(
                CreatedPullRequestContributionSelector.class, CreatedPullRequestContributionSelector::isRestricted)));
        values.add(selector.firstRepositoryContribution(child -> child.on(
                CreatedRepositoryContributionSelector.class, CreatedRepositoryContributionSelector::isRestricted)));
        values.add(selector.hasActivityInThePast());
        values.add(selector.hasAnyContributions());
        values.add(selector.hasAnyRestrictedContributions());
        values.add(selector.isSingleDay());
        values.add(selector.issueContributions(
                Paging.first(1),
                ContributionsCollectionIssueContributionsFilterBuilder.builder()
                        .excludeFirst(true)
                        .excludePopular(true)
                        .orderBy(ContributionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .build())
                        .build(),
                CreatedIssueContributionSelector::isRestricted));
        values.add(selector.issueContributionsByRepository(
                ContributionsCollectionIssueContributionsByRepositoryFilterBuilder.builder()
                        .excludeFirst(true)
                        .excludePopular(true)
                        .maxRepositories(1)
                        .build(),
                child -> child.contributions(Paging.first(1), CreatedIssueContributionSelector::isRestricted)));
        values.add(selector.joinedGitHubContribution(JoinedGitHubContributionSelector::isRestricted));
        values.add(selector.latestRestrictedContributionDate());
        values.add(selector.mostRecentCollectionWithActivity(ContributionsCollectionSelector::contributionYears));
        values.add(selector.mostRecentCollectionWithoutActivity(ContributionsCollectionSelector::contributionYears));
        values.add(selector.popularIssueContribution(CreatedIssueContributionSelector::isRestricted));
        values.add(selector.popularPullRequestContribution(CreatedPullRequestContributionSelector::isRestricted));
        values.add(selector.pullRequestContributions(
                Paging.first(1),
                ContributionsCollectionPullRequestContributionsFilterBuilder.builder()
                        .excludeFirst(true)
                        .excludePopular(true)
                        .orderBy(ContributionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .build())
                        .build(),
                CreatedPullRequestContributionSelector::isRestricted));
        values.add(selector.pullRequestContributionsByRepository(
                ContributionsCollectionPullRequestContributionsByRepositoryFilterBuilder.builder()
                        .excludeFirst(true)
                        .excludePopular(true)
                        .maxRepositories(1)
                        .build(),
                child -> child.contributions(Paging.first(1), CreatedPullRequestContributionSelector::isRestricted)));
        values.add(selector.pullRequestReviewContributions(
                Paging.first(1),
                ContributionsCollectionPullRequestReviewContributionsFilterBuilder.builder()
                        .orderBy(ContributionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .build())
                        .build(),
                CreatedPullRequestReviewContributionSelector::isRestricted));
        values.add(selector.pullRequestReviewContributionsByRepository(
                ContributionsCollectionPullRequestReviewContributionsByRepositoryFilterBuilder.builder()
                        .maxRepositories(1)
                        .build(),
                child -> child.contributions(
                        Paging.first(1), CreatedPullRequestReviewContributionSelector::isRestricted)));
        values.add(selector.repositoryContributions(
                Paging.first(1),
                ContributionsCollectionRepositoryContributionsFilterBuilder.builder()
                        .excludeFirst(true)
                        .orderBy(ContributionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .build())
                        .build(),
                CreatedRepositoryContributionSelector::isRestricted));
        values.add(selector.restrictedContributionsCount());
        values.add(selector.startedAt());
        values.add(selector.totalCommitContributions());
        values.add(
                selector.totalIssueContributions(ContributionsCollectionTotalIssueContributionsFilterBuilder.builder()
                        .excludeFirst(true)
                        .excludePopular(true)
                        .build()));
        values.add(selector.totalPullRequestContributions(
                ContributionsCollectionTotalPullRequestContributionsFilterBuilder.builder()
                        .excludeFirst(true)
                        .excludePopular(true)
                        .build()));
        values.add(selector.totalPullRequestReviewContributions());
        values.add(selector.totalRepositoriesWithContributedCommits());
        values.add(selector.totalRepositoriesWithContributedIssues(
                ContributionsCollectionTotalRepositoriesWithContributedIssuesFilterBuilder.builder()
                        .excludeFirst(true)
                        .excludePopular(true)
                        .build()));
        values.add(selector.totalRepositoriesWithContributedPullRequestReviews());
        values.add(selector.totalRepositoriesWithContributedPullRequests(
                ContributionsCollectionTotalRepositoriesWithContributedPullRequestsFilterBuilder.builder()
                        .excludeFirst(true)
                        .excludePopular(true)
                        .build()));
        values.add(selector.totalRepositoryContributions(
                ContributionsCollectionTotalRepositoryContributionsFilterBuilder.builder()
                        .excludeFirst(true)
                        .build()));
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    private static List<Object> readWithoutArguments(final ContributionsCollectionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.commitContributionsByRepository(CommitContributionsByRepositorySelector::resourcePath));
        values.add(selector.issueContributions(Paging.first(1), CreatedIssueContributionSelector::isRestricted));
        values.add(selector.issueContributionsByRepository(
                child -> child.contributions(Paging.first(1), CreatedIssueContributionSelector::isRestricted)));
        values.add(selector.pullRequestContributions(
                Paging.first(1), CreatedPullRequestContributionSelector::isRestricted));
        values.add(selector.pullRequestContributionsByRepository(
                child -> child.contributions(Paging.first(1), CreatedPullRequestContributionSelector::isRestricted)));
        values.add(selector.pullRequestReviewContributions(
                Paging.first(1), CreatedPullRequestReviewContributionSelector::isRestricted));
        values.add(selector.pullRequestReviewContributionsByRepository(child ->
                child.contributions(Paging.first(1), CreatedPullRequestReviewContributionSelector::isRestricted)));
        values.add(
                selector.repositoryContributions(Paging.first(1), CreatedRepositoryContributionSelector::isRestricted));
        values.add(selector.totalIssueContributions());
        values.add(selector.totalPullRequestContributions());
        values.add(selector.totalRepositoriesWithContributedIssues());
        values.add(selector.totalRepositoriesWithContributedPullRequests());
        values.add(selector.totalRepositoryContributions());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ContributionsCollectionSelectorImpl(new RecordingCursor(root)));
        final ContributionsCollectionSelectorImpl selector =
                new ContributionsCollectionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        List.of("x"),
                        List.of("x"),
                        List.of(1),
                        true,
                        LocalDate.of(2024, 5, 1),
                        Instant.parse("2024-05-01T10:15:30Z"),
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        new Page<>(List.of(true), false, null),
                        List.of(new Page<>(List.of(true), false, null)),
                        true,
                        LocalDate.of(2024, 5, 1),
                        List.of(1),
                        List.of(1),
                        true,
                        true,
                        new Page<>(List.of(true), false, null),
                        List.of(new Page<>(List.of(true), false, null)),
                        new Page<>(List.of(true), false, null),
                        List.of(new Page<>(List.of(true), false, null)),
                        new Page<>(List.of(true), false, null),
                        1,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        1,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ContributionsCollectionSelectorImpl(new RecordingCursor(root)));
        final ContributionsCollectionSelectorImpl selector =
                new ContributionsCollectionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        List.of("x"),
                        new Page<>(List.of(true), false, null),
                        List.of(new Page<>(List.of(true), false, null)),
                        new Page<>(List.of(true), false, null),
                        List.of(new Page<>(List.of(true), false, null)),
                        new Page<>(List.of(true), false, null),
                        List.of(new Page<>(List.of(true), false, null)),
                        new Page<>(List.of(true), false, null),
                        1,
                        1,
                        1,
                        1,
                        1);
    }
}
