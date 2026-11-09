package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code Commit}. */
public interface CommitSelector {

    String abbreviatedOid();

    int additions();

    <R> Page<R> associatedPullRequests(
            Paging paging, CommitAssociatedPullRequestsFilter arguments, Function<PullRequestSelector, R> selection);

    <R> Page<R> associatedPullRequests(Paging paging, Function<PullRequestSelector, R> selection);

    <R> @Nullable R author(Function<GitActorSelector, R> selection);

    boolean authoredByCommitter();

    Instant authoredDate();

    <R> Page<R> authors(Paging paging, Function<GitActorSelector, R> selection);

    <R> R blame(String path, Function<BlameSelector, R> selection);

    /** @deprecated `changedFiles` will be removed. Use `changedFilesIfAvailable` instead. Removal on 2023-01-01 UTC. */
    @Deprecated(forRemoval = true)
    int changedFiles();

    @Nullable Integer changedFilesIfAvailable();

    <R> Page<R> checkSuites(
            Paging paging, CommitCheckSuitesFilter arguments, Function<CheckSuiteSelector, R> selection);

    <R> Page<R> checkSuites(Paging paging, Function<CheckSuiteSelector, R> selection);

    <R> Page<R> comments(Paging paging, Function<CommitCommentSelector, R> selection);

    String commitResourcePath();

    String commitUrl();

    Instant committedDate();

    boolean committedViaWeb();

    <R> @Nullable R committer(Function<GitActorSelector, R> selection);

    int deletions();

    <R> Page<R> deployments(
            Paging paging, CommitDeploymentsFilter arguments, Function<DeploymentSelector, R> selection);

    <R> Page<R> deployments(Paging paging, Function<DeploymentSelector, R> selection);

    <R> @Nullable R file(String path, Function<TreeEntrySelector, R> selection);

    <R> Page<R> history(Paging paging, CommitHistoryFilter arguments, Function<CommitSelector, R> selection);

    <R> Page<R> history(Paging paging, Function<CommitSelector, R> selection);

    String id();

    String message();

    String messageBody();

    String messageBodyHTML();

    String messageHeadline();

    String messageHeadlineHTML();

    String oid();

    <R> @Nullable R onBehalfOf(Function<OrganizationSelector, R> selection);

    <R> Page<R> parents(Paging paging, Function<CommitSelector, R> selection);

    /** @deprecated `pushedDate` is no longer supported. Removal on 2023-07-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable Instant pushedDate();

    <R> R repository(Function<RepositorySelector, R> selection);

    String resourcePath();

    <R> @Nullable R signature(Function<GitSignatureSelector, R> selection);

    <R> @Nullable R status(Function<StatusSelector, R> selection);

    <R> @Nullable R statusCheckRollup(Function<StatusCheckRollupSelector, R> selection);

    <R> Page<R> submodules(Paging paging, Function<SubmoduleSelector, R> selection);

    String tarballUrl();

    <R> R tree(Function<TreeSelector, R> selection);

    String treeResourcePath();

    String treeUrl();

    String url();

    boolean viewerCanSubscribe();

    @Nullable SubscriptionState viewerSubscription();

    String zipballUrl();
}
