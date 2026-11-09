package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.BlameSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitAssociatedPullRequestsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CommitAssociatedPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCheckSuitesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCheckSuitesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitDeploymentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CommitDeploymentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitHistoryFilter;
import io.github.piotr_janczukowicz.github.graphql.model.CommitHistoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitSignatureSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckRollupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubmoduleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.TreeEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TreeSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Commit}; used by the generated selection code only. */
final class CommitSelectorImpl implements CommitSelector {

    private static final String PAGING = "paging";

    private static final String ARGUMENTS = "arguments";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String PATH = "path";

    private final Cursor cursor;

    CommitSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String abbreviatedOid() {
        return cursor.getRequired("abbreviatedOid", ScalarType.STRING);
    }

    @Override
    public int additions() {
        return cursor.getRequired("additions", ScalarType.INT);
    }

    @Override
    public <R> Page<R> associatedPullRequests(
            final Paging paging,
            final CommitAssociatedPullRequestsFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "associatedPullRequests",
                child -> selection.apply(new PullRequestSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "PullRequestOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> associatedPullRequests(final Paging paging, final Function<PullRequestSelector, R> selection) {
        return associatedPullRequests(
                paging, CommitAssociatedPullRequestsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R author(final Function<GitActorSelector, R> selection) {
        return cursor.object("author", child -> selection.apply(new GitActorSelectorImpl(child)));
    }

    @Override
    public boolean authoredByCommitter() {
        return cursor.getRequired("authoredByCommitter", ScalarType.BOOLEAN);
    }

    @Override
    public Instant authoredDate() {
        return cursor.getRequired("authoredDate", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> authors(final Paging paging, final Function<GitActorSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "authors",
                child -> selection.apply(new GitActorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> R blame(final String path, final Function<BlameSelector, R> selection) {
        requireNonNull(path, PATH);
        return cursor.objectRequired(
                "blame", child -> selection.apply(new BlameSelectorImpl(child)), Argument.of(PATH, "String!", path));
    }

    /** @deprecated `changedFiles` will be removed. Use `changedFilesIfAvailable` instead. Removal on 2023-01-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public int changedFiles() {
        return cursor.getRequired("changedFiles", ScalarType.INT);
    }

    @Override
    public @Nullable Integer changedFilesIfAvailable() {
        return cursor.get("changedFilesIfAvailable", ScalarType.INT);
    }

    @Override
    public <R> Page<R> checkSuites(
            final Paging paging,
            final CommitCheckSuitesFilter arguments,
            final Function<CheckSuiteSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "checkSuites",
                child -> selection.apply(new CheckSuiteSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        "filterBy",
                        "CheckSuiteFilter",
                        arguments.filterBy() == null
                                ? null
                                : arguments.filterBy().toVariable()));
    }

    @Override
    public <R> Page<R> checkSuites(final Paging paging, final Function<CheckSuiteSelector, R> selection) {
        return checkSuites(paging, CommitCheckSuitesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> comments(final Paging paging, final Function<CommitCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "comments",
                child -> selection.apply(new CommitCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public String commitResourcePath() {
        return cursor.getRequired("commitResourcePath", ScalarType.STRING);
    }

    @Override
    public String commitUrl() {
        return cursor.getRequired("commitUrl", ScalarType.STRING);
    }

    @Override
    public Instant committedDate() {
        return cursor.getRequired("committedDate", ScalarType.INSTANT);
    }

    @Override
    public boolean committedViaWeb() {
        return cursor.getRequired("committedViaWeb", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R committer(final Function<GitActorSelector, R> selection) {
        return cursor.object("committer", child -> selection.apply(new GitActorSelectorImpl(child)));
    }

    @Override
    public int deletions() {
        return cursor.getRequired("deletions", ScalarType.INT);
    }

    @Override
    public <R> Page<R> deployments(
            final Paging paging,
            final CommitDeploymentsFilter arguments,
            final Function<DeploymentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "deployments",
                child -> selection.apply(new DeploymentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("environments", "[String!]", arguments.environments()),
                Argument.of(
                        "orderBy",
                        "DeploymentOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> deployments(final Paging paging, final Function<DeploymentSelector, R> selection) {
        return deployments(paging, CommitDeploymentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R file(final String path, final Function<TreeEntrySelector, R> selection) {
        requireNonNull(path, PATH);
        return cursor.object(
                "file", child -> selection.apply(new TreeEntrySelectorImpl(child)), Argument.of(PATH, "String!", path));
    }

    @Override
    public <R> Page<R> history(
            final Paging paging, final CommitHistoryFilter arguments, final Function<CommitSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "history",
                child -> selection.apply(new CommitSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        "author",
                        "CommitAuthor",
                        arguments.author() == null ? null : arguments.author().toVariable()),
                Argument.of(PATH, STRING, arguments.path()),
                Argument.of("since", "GitTimestamp", arguments.since()),
                Argument.of("until", "GitTimestamp", arguments.until()));
    }

    @Override
    public <R> Page<R> history(final Paging paging, final Function<CommitSelector, R> selection) {
        return history(paging, CommitHistoryFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String message() {
        return cursor.getRequired("message", ScalarType.STRING);
    }

    @Override
    public String messageBody() {
        return cursor.getRequired("messageBody", ScalarType.STRING);
    }

    @Override
    public String messageBodyHTML() {
        return cursor.getRequired("messageBodyHTML", ScalarType.STRING);
    }

    @Override
    public String messageHeadline() {
        return cursor.getRequired("messageHeadline", ScalarType.STRING);
    }

    @Override
    public String messageHeadlineHTML() {
        return cursor.getRequired("messageHeadlineHTML", ScalarType.STRING);
    }

    @Override
    public String oid() {
        return cursor.getRequired("oid", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R onBehalfOf(final Function<OrganizationSelector, R> selection) {
        return cursor.object("onBehalfOf", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> parents(final Paging paging, final Function<CommitSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "parents",
                child -> selection.apply(new CommitSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    /** @deprecated `pushedDate` is no longer supported. Removal on 2023-07-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings("removal")
    public @Nullable Instant pushedDate() {
        return cursor.get("pushedDate", ScalarType.INSTANT);
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R signature(final Function<GitSignatureSelector, R> selection) {
        return cursor.object("signature", child -> selection.apply(new GitSignatureSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R status(final Function<StatusSelector, R> selection) {
        return cursor.object("status", child -> selection.apply(new StatusSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R statusCheckRollup(final Function<StatusCheckRollupSelector, R> selection) {
        return cursor.object("statusCheckRollup", child -> selection.apply(new StatusCheckRollupSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> submodules(final Paging paging, final Function<SubmoduleSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "submodules",
                child -> selection.apply(new SubmoduleSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public String tarballUrl() {
        return cursor.getRequired("tarballUrl", ScalarType.STRING);
    }

    @Override
    public <R> R tree(final Function<TreeSelector, R> selection) {
        return cursor.objectRequired("tree", child -> selection.apply(new TreeSelectorImpl(child)));
    }

    @Override
    public String treeResourcePath() {
        return cursor.getRequired("treeResourcePath", ScalarType.STRING);
    }

    @Override
    public String treeUrl() {
        return cursor.getRequired("treeUrl", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public boolean viewerCanSubscribe() {
        return cursor.getRequired("viewerCanSubscribe", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable SubscriptionState viewerSubscription() {
        return cursor.get(
                "viewerSubscription", ScalarType.enumeration(SubscriptionState::fromWire, SubscriptionState.IGNORED));
    }

    @Override
    public String zipballUrl() {
        return cursor.getRequired("zipballUrl", ScalarType.STRING);
    }
}
