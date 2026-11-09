package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionCalendarSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionCommitContributionsByRepositoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionCommitContributionsByRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionIssueContributionsByRepositoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionIssueContributionsByRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionIssueContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionIssueContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestContributionsByRepositoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestContributionsByRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestReviewContributionsByRepositoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestReviewContributionsByRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestReviewContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionPullRequestReviewContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionRepositoryContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalIssueContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalIssueContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalPullRequestContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalPullRequestContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoriesWithContributedIssuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoriesWithContributedIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoriesWithContributedPullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoriesWithContributedPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoryContributionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.ContributionsCollectionTotalRepositoryContributionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedIssueContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedIssueOrRestrictedContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestOrRestrictedContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestReviewContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedRepositoryContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CreatedRepositoryOrRestrictedContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.JoinedGitHubContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewContributionsByRepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code ContributionsCollection}; used by the generated selection code only. */
final class ContributionsCollectionSelectorImpl implements ContributionsCollectionSelector {

    private static final String ARGUMENTS = "arguments";

    private static final String MAX_REPOSITORIES = "maxRepositories";

    private static final String INT = "Int";

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT_2 = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String EXCLUDE_FIRST = "excludeFirst";

    private static final String BOOLEAN = "Boolean";

    private static final String EXCLUDE_POPULAR = "excludePopular";

    private static final String ORDER_BY = "orderBy";

    private static final String CONTRIBUTION_ORDER = "ContributionOrder";

    private final Cursor cursor;

    ContributionsCollectionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> commitContributionsByRepository(
            final ContributionsCollectionCommitContributionsByRepositoryFilter arguments,
            final Function<CommitContributionsByRepositorySelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.listRequired(
                "commitContributionsByRepository",
                child -> selection.apply(new CommitContributionsByRepositorySelectorImpl(child)),
                Argument.of(MAX_REPOSITORIES, INT, arguments.maxRepositories()));
    }

    @Override
    public <R> List<R> commitContributionsByRepository(
            final Function<CommitContributionsByRepositorySelector, R> selection) {
        return commitContributionsByRepository(
                ContributionsCollectionCommitContributionsByRepositoryFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> R contributionCalendar(final Function<ContributionCalendarSelector, R> selection) {
        return cursor.objectRequired(
                "contributionCalendar", child -> selection.apply(new ContributionCalendarSelectorImpl(child)));
    }

    @Override
    public List<Integer> contributionYears() {
        return cursor.scalarListRequired("contributionYears", ScalarType.INT);
    }

    @Override
    public boolean doesEndInCurrentMonth() {
        return cursor.getRequired("doesEndInCurrentMonth", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable LocalDate earliestRestrictedContributionDate() {
        return cursor.get("earliestRestrictedContributionDate", ScalarType.LOCAL_DATE);
    }

    @Override
    public Instant endedAt() {
        return cursor.getRequired("endedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> @Nullable R firstIssueContribution(
            final Function<CreatedIssueOrRestrictedContributionSelector, R> selection) {
        return cursor.object(
                "firstIssueContribution",
                child -> selection.apply(new CreatedIssueOrRestrictedContributionSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R firstPullRequestContribution(
            final Function<CreatedPullRequestOrRestrictedContributionSelector, R> selection) {
        return cursor.object(
                "firstPullRequestContribution",
                child -> selection.apply(new CreatedPullRequestOrRestrictedContributionSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R firstRepositoryContribution(
            final Function<CreatedRepositoryOrRestrictedContributionSelector, R> selection) {
        return cursor.object(
                "firstRepositoryContribution",
                child -> selection.apply(new CreatedRepositoryOrRestrictedContributionSelectorImpl(child)));
    }

    @Override
    public boolean hasActivityInThePast() {
        return cursor.getRequired("hasActivityInThePast", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasAnyContributions() {
        return cursor.getRequired("hasAnyContributions", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasAnyRestrictedContributions() {
        return cursor.getRequired("hasAnyRestrictedContributions", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isSingleDay() {
        return cursor.getRequired("isSingleDay", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> issueContributions(
            final Paging paging,
            final ContributionsCollectionIssueContributionsFilter arguments,
            final Function<CreatedIssueContributionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "issueContributions",
                child -> selection.apply(new CreatedIssueContributionSelectorImpl(child)),
                Argument.of(FIRST, INT_2, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(EXCLUDE_POPULAR, BOOLEAN, arguments.excludePopular()),
                Argument.of(
                        ORDER_BY,
                        CONTRIBUTION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> issueContributions(
            final Paging paging, final Function<CreatedIssueContributionSelector, R> selection) {
        return issueContributions(
                paging,
                ContributionsCollectionIssueContributionsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> List<R> issueContributionsByRepository(
            final ContributionsCollectionIssueContributionsByRepositoryFilter arguments,
            final Function<IssueContributionsByRepositorySelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.listRequired(
                "issueContributionsByRepository",
                child -> selection.apply(new IssueContributionsByRepositorySelectorImpl(child)),
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(EXCLUDE_POPULAR, BOOLEAN, arguments.excludePopular()),
                Argument.of(MAX_REPOSITORIES, INT, arguments.maxRepositories()));
    }

    @Override
    public <R> List<R> issueContributionsByRepository(
            final Function<IssueContributionsByRepositorySelector, R> selection) {
        return issueContributionsByRepository(
                ContributionsCollectionIssueContributionsByRepositoryFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> @Nullable R joinedGitHubContribution(final Function<JoinedGitHubContributionSelector, R> selection) {
        return cursor.object(
                "joinedGitHubContribution", child -> selection.apply(new JoinedGitHubContributionSelectorImpl(child)));
    }

    @Override
    public @Nullable LocalDate latestRestrictedContributionDate() {
        return cursor.get("latestRestrictedContributionDate", ScalarType.LOCAL_DATE);
    }

    @Override
    public <R> @Nullable R mostRecentCollectionWithActivity(
            final Function<ContributionsCollectionSelector, R> selection) {
        return cursor.object(
                "mostRecentCollectionWithActivity",
                child -> selection.apply(new ContributionsCollectionSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R mostRecentCollectionWithoutActivity(
            final Function<ContributionsCollectionSelector, R> selection) {
        return cursor.object(
                "mostRecentCollectionWithoutActivity",
                child -> selection.apply(new ContributionsCollectionSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R popularIssueContribution(final Function<CreatedIssueContributionSelector, R> selection) {
        return cursor.object(
                "popularIssueContribution", child -> selection.apply(new CreatedIssueContributionSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R popularPullRequestContribution(
            final Function<CreatedPullRequestContributionSelector, R> selection) {
        return cursor.object(
                "popularPullRequestContribution",
                child -> selection.apply(new CreatedPullRequestContributionSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> pullRequestContributions(
            final Paging paging,
            final ContributionsCollectionPullRequestContributionsFilter arguments,
            final Function<CreatedPullRequestContributionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pullRequestContributions",
                child -> selection.apply(new CreatedPullRequestContributionSelectorImpl(child)),
                Argument.of(FIRST, INT_2, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(EXCLUDE_POPULAR, BOOLEAN, arguments.excludePopular()),
                Argument.of(
                        ORDER_BY,
                        CONTRIBUTION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> pullRequestContributions(
            final Paging paging, final Function<CreatedPullRequestContributionSelector, R> selection) {
        return pullRequestContributions(
                paging,
                ContributionsCollectionPullRequestContributionsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> List<R> pullRequestContributionsByRepository(
            final ContributionsCollectionPullRequestContributionsByRepositoryFilter arguments,
            final Function<PullRequestContributionsByRepositorySelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.listRequired(
                "pullRequestContributionsByRepository",
                child -> selection.apply(new PullRequestContributionsByRepositorySelectorImpl(child)),
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(EXCLUDE_POPULAR, BOOLEAN, arguments.excludePopular()),
                Argument.of(MAX_REPOSITORIES, INT, arguments.maxRepositories()));
    }

    @Override
    public <R> List<R> pullRequestContributionsByRepository(
            final Function<PullRequestContributionsByRepositorySelector, R> selection) {
        return pullRequestContributionsByRepository(
                ContributionsCollectionPullRequestContributionsByRepositoryFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> pullRequestReviewContributions(
            final Paging paging,
            final ContributionsCollectionPullRequestReviewContributionsFilter arguments,
            final Function<CreatedPullRequestReviewContributionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "pullRequestReviewContributions",
                child -> selection.apply(new CreatedPullRequestReviewContributionSelectorImpl(child)),
                Argument.of(FIRST, INT_2, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        CONTRIBUTION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> pullRequestReviewContributions(
            final Paging paging, final Function<CreatedPullRequestReviewContributionSelector, R> selection) {
        return pullRequestReviewContributions(
                paging,
                ContributionsCollectionPullRequestReviewContributionsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> List<R> pullRequestReviewContributionsByRepository(
            final ContributionsCollectionPullRequestReviewContributionsByRepositoryFilter arguments,
            final Function<PullRequestReviewContributionsByRepositorySelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.listRequired(
                "pullRequestReviewContributionsByRepository",
                child -> selection.apply(new PullRequestReviewContributionsByRepositorySelectorImpl(child)),
                Argument.of(MAX_REPOSITORIES, INT, arguments.maxRepositories()));
    }

    @Override
    public <R> List<R> pullRequestReviewContributionsByRepository(
            final Function<PullRequestReviewContributionsByRepositorySelector, R> selection) {
        return pullRequestReviewContributionsByRepository(
                ContributionsCollectionPullRequestReviewContributionsByRepositoryFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> repositoryContributions(
            final Paging paging,
            final ContributionsCollectionRepositoryContributionsFilter arguments,
            final Function<CreatedRepositoryContributionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "repositoryContributions",
                child -> selection.apply(new CreatedRepositoryContributionSelectorImpl(child)),
                Argument.of(FIRST, INT_2, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(
                        ORDER_BY,
                        CONTRIBUTION_ORDER,
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> repositoryContributions(
            final Paging paging, final Function<CreatedRepositoryContributionSelector, R> selection) {
        return repositoryContributions(
                paging,
                ContributionsCollectionRepositoryContributionsFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public int restrictedContributionsCount() {
        return cursor.getRequired("restrictedContributionsCount", ScalarType.INT);
    }

    @Override
    public Instant startedAt() {
        return cursor.getRequired("startedAt", ScalarType.INSTANT);
    }

    @Override
    public int totalCommitContributions() {
        return cursor.getRequired("totalCommitContributions", ScalarType.INT);
    }

    @Override
    public int totalIssueContributions(final ContributionsCollectionTotalIssueContributionsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "totalIssueContributions",
                ScalarType.INT,
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(EXCLUDE_POPULAR, BOOLEAN, arguments.excludePopular()));
    }

    @Override
    public int totalIssueContributions() {
        return totalIssueContributions(ContributionsCollectionTotalIssueContributionsFilterBuilder.builder()
                .build());
    }

    @Override
    public int totalPullRequestContributions(
            final ContributionsCollectionTotalPullRequestContributionsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "totalPullRequestContributions",
                ScalarType.INT,
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(EXCLUDE_POPULAR, BOOLEAN, arguments.excludePopular()));
    }

    @Override
    public int totalPullRequestContributions() {
        return totalPullRequestContributions(ContributionsCollectionTotalPullRequestContributionsFilterBuilder.builder()
                .build());
    }

    @Override
    public int totalPullRequestReviewContributions() {
        return cursor.getRequired("totalPullRequestReviewContributions", ScalarType.INT);
    }

    @Override
    public int totalRepositoriesWithContributedCommits() {
        return cursor.getRequired("totalRepositoriesWithContributedCommits", ScalarType.INT);
    }

    @Override
    public int totalRepositoriesWithContributedIssues(
            final ContributionsCollectionTotalRepositoriesWithContributedIssuesFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "totalRepositoriesWithContributedIssues",
                ScalarType.INT,
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(EXCLUDE_POPULAR, BOOLEAN, arguments.excludePopular()));
    }

    @Override
    public int totalRepositoriesWithContributedIssues() {
        return totalRepositoriesWithContributedIssues(
                ContributionsCollectionTotalRepositoriesWithContributedIssuesFilterBuilder.builder()
                        .build());
    }

    @Override
    public int totalRepositoriesWithContributedPullRequestReviews() {
        return cursor.getRequired("totalRepositoriesWithContributedPullRequestReviews", ScalarType.INT);
    }

    @Override
    public int totalRepositoriesWithContributedPullRequests(
            final ContributionsCollectionTotalRepositoriesWithContributedPullRequestsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "totalRepositoriesWithContributedPullRequests",
                ScalarType.INT,
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()),
                Argument.of(EXCLUDE_POPULAR, BOOLEAN, arguments.excludePopular()));
    }

    @Override
    public int totalRepositoriesWithContributedPullRequests() {
        return totalRepositoriesWithContributedPullRequests(
                ContributionsCollectionTotalRepositoriesWithContributedPullRequestsFilterBuilder.builder()
                        .build());
    }

    @Override
    public int totalRepositoryContributions(final ContributionsCollectionTotalRepositoryContributionsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "totalRepositoryContributions",
                ScalarType.INT,
                Argument.of(EXCLUDE_FIRST, BOOLEAN, arguments.excludeFirst()));
    }

    @Override
    public int totalRepositoryContributions() {
        return totalRepositoryContributions(ContributionsCollectionTotalRepositoryContributionsFilterBuilder.builder()
                .build());
    }

    @Override
    public <R> R user(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
