package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ContributionsCollection}. */
public interface ContributionsCollectionSelector {

    <R> List<R> commitContributionsByRepository(
            ContributionsCollectionCommitContributionsByRepositoryFilter arguments,
            Function<CommitContributionsByRepositorySelector, R> selection);

    <R> List<R> commitContributionsByRepository(Function<CommitContributionsByRepositorySelector, R> selection);

    <R> R contributionCalendar(Function<ContributionCalendarSelector, R> selection);

    List<Integer> contributionYears();

    boolean doesEndInCurrentMonth();

    @Nullable LocalDate earliestRestrictedContributionDate();

    Instant endedAt();

    <R> @Nullable R firstIssueContribution(Function<CreatedIssueOrRestrictedContributionSelector, R> selection);

    <R> @Nullable R firstPullRequestContribution(
            Function<CreatedPullRequestOrRestrictedContributionSelector, R> selection);

    <R> @Nullable R firstRepositoryContribution(
            Function<CreatedRepositoryOrRestrictedContributionSelector, R> selection);

    boolean hasActivityInThePast();

    boolean hasAnyContributions();

    boolean hasAnyRestrictedContributions();

    boolean isSingleDay();

    <R> Page<R> issueContributions(
            Paging paging,
            ContributionsCollectionIssueContributionsFilter arguments,
            Function<CreatedIssueContributionSelector, R> selection);

    <R> Page<R> issueContributions(Paging paging, Function<CreatedIssueContributionSelector, R> selection);

    <R> List<R> issueContributionsByRepository(
            ContributionsCollectionIssueContributionsByRepositoryFilter arguments,
            Function<IssueContributionsByRepositorySelector, R> selection);

    <R> List<R> issueContributionsByRepository(Function<IssueContributionsByRepositorySelector, R> selection);

    <R> @Nullable R joinedGitHubContribution(Function<JoinedGitHubContributionSelector, R> selection);

    @Nullable LocalDate latestRestrictedContributionDate();

    <R> @Nullable R mostRecentCollectionWithActivity(Function<ContributionsCollectionSelector, R> selection);

    <R> @Nullable R mostRecentCollectionWithoutActivity(Function<ContributionsCollectionSelector, R> selection);

    <R> @Nullable R popularIssueContribution(Function<CreatedIssueContributionSelector, R> selection);

    <R> @Nullable R popularPullRequestContribution(Function<CreatedPullRequestContributionSelector, R> selection);

    <R> Page<R> pullRequestContributions(
            Paging paging,
            ContributionsCollectionPullRequestContributionsFilter arguments,
            Function<CreatedPullRequestContributionSelector, R> selection);

    <R> Page<R> pullRequestContributions(Paging paging, Function<CreatedPullRequestContributionSelector, R> selection);

    <R> List<R> pullRequestContributionsByRepository(
            ContributionsCollectionPullRequestContributionsByRepositoryFilter arguments,
            Function<PullRequestContributionsByRepositorySelector, R> selection);

    <R> List<R> pullRequestContributionsByRepository(
            Function<PullRequestContributionsByRepositorySelector, R> selection);

    <R> Page<R> pullRequestReviewContributions(
            Paging paging,
            ContributionsCollectionPullRequestReviewContributionsFilter arguments,
            Function<CreatedPullRequestReviewContributionSelector, R> selection);

    <R> Page<R> pullRequestReviewContributions(
            Paging paging, Function<CreatedPullRequestReviewContributionSelector, R> selection);

    <R> List<R> pullRequestReviewContributionsByRepository(
            ContributionsCollectionPullRequestReviewContributionsByRepositoryFilter arguments,
            Function<PullRequestReviewContributionsByRepositorySelector, R> selection);

    <R> List<R> pullRequestReviewContributionsByRepository(
            Function<PullRequestReviewContributionsByRepositorySelector, R> selection);

    <R> Page<R> repositoryContributions(
            Paging paging,
            ContributionsCollectionRepositoryContributionsFilter arguments,
            Function<CreatedRepositoryContributionSelector, R> selection);

    <R> Page<R> repositoryContributions(Paging paging, Function<CreatedRepositoryContributionSelector, R> selection);

    int restrictedContributionsCount();

    Instant startedAt();

    int totalCommitContributions();

    int totalIssueContributions(ContributionsCollectionTotalIssueContributionsFilter arguments);

    int totalIssueContributions();

    int totalPullRequestContributions(ContributionsCollectionTotalPullRequestContributionsFilter arguments);

    int totalPullRequestContributions();

    int totalPullRequestReviewContributions();

    int totalRepositoriesWithContributedCommits();

    int totalRepositoriesWithContributedIssues(
            ContributionsCollectionTotalRepositoriesWithContributedIssuesFilter arguments);

    int totalRepositoriesWithContributedIssues();

    int totalRepositoriesWithContributedPullRequestReviews();

    int totalRepositoriesWithContributedPullRequests(
            ContributionsCollectionTotalRepositoriesWithContributedPullRequestsFilter arguments);

    int totalRepositoriesWithContributedPullRequests();

    int totalRepositoryContributions(ContributionsCollectionTotalRepositoryContributionsFilter arguments);

    int totalRepositoryContributions();

    <R> R user(Function<UserSelector, R> selection);
}
