package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AssigneeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.HovercardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueBlockedByFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueBlockedByFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueBlockingFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueBlockingFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueClosedByPullRequestsReferencesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueClosedByPullRequestsReferencesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueDependenciesSummarySelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFieldValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueHovercardFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueHovercardFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueLabelsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueLabelsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectCardsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectCardsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectsV2Filter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueProjectsV2FilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueReactionsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueRelatesToFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueRelatesToFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReason;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReasonFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueStateReasonFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSuggestedActorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSuggestedActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTimelineItemsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTrackedIssuesCountFilter;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTrackedIssuesCountFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueTypeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LabelSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LinkedBranchSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.MilestoneSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PendingIssueSuggestionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedIssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectCardSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubIssuesSummarySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.ThreadSubscriptionFormAction;
import io.github.piotr_janczukowicz.github.graphql.model.ThreadSubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Issue}; used by the generated selection code only. */
final class IssueSelectorImpl implements IssueSelector {

    private static final String PAGING = "paging";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ARGUMENTS = "arguments";

    private static final String ORDER_BY = "orderBy";

    private static final String BOOLEAN = "Boolean";

    private static final String REMOVAL = "removal";

    private final Cursor cursor;

    IssueSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable LockReason activeLockReason() {
        return cursor.get("activeLockReason", ScalarType.enumeration(LockReason::fromWire, LockReason.OFF_TOPIC));
    }

    @Override
    public <R> Page<R> assignedActors(final Paging paging, final Function<AssigneeSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "assignedActors",
                child -> selection.apply(new AssigneeSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> assignees(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "assignees",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R author(final Function<ActorSelector, R> selection) {
        return cursor.object("author", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public CommentAuthorAssociation authorAssociation() {
        return cursor.getRequired(
                "authorAssociation",
                ScalarType.enumeration(CommentAuthorAssociation::fromWire, CommentAuthorAssociation.COLLABORATOR));
    }

    @Override
    public <R> Page<R> blockedBy(
            final Paging paging, final IssueBlockedByFilter arguments, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "blockedBy",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueDependencyOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> blockedBy(final Paging paging, final Function<IssueSelector, R> selection) {
        return blockedBy(paging, IssueBlockedByFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> blocking(
            final Paging paging, final IssueBlockingFilter arguments, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "blocking",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueDependencyOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> blocking(final Paging paging, final Function<IssueSelector, R> selection) {
        return blocking(paging, IssueBlockingFilterBuilder.builder().build(), selection);
    }

    @Override
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public String bodyHTML() {
        return cursor.getRequired("bodyHTML", ScalarType.STRING);
    }

    @Override
    public String bodyResourcePath() {
        return cursor.getRequired("bodyResourcePath", ScalarType.STRING);
    }

    @Override
    public String bodyText() {
        return cursor.getRequired("bodyText", ScalarType.STRING);
    }

    @Override
    public String bodyUrl() {
        return cursor.getRequired("bodyUrl", ScalarType.STRING);
    }

    @Override
    public boolean closed() {
        return cursor.getRequired("closed", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Instant closedAt() {
        return cursor.get("closedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> closedByPullRequestsReferences(
            final Paging paging,
            final IssueClosedByPullRequestsReferencesFilter arguments,
            final Function<PullRequestSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "closedByPullRequestsReferences",
                child -> selection.apply(new PullRequestSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("excludeUserLinked", BOOLEAN, arguments.excludeUserLinked()),
                Argument.of("includeClosedPrs", BOOLEAN, arguments.includeClosedPrs()),
                Argument.of("orderByState", BOOLEAN, arguments.orderByState()),
                Argument.of("userLinkedOnly", BOOLEAN, arguments.userLinkedOnly()));
    }

    @Override
    public <R> Page<R> closedByPullRequestsReferences(
            final Paging paging, final Function<PullRequestSelector, R> selection) {
        return closedByPullRequestsReferences(
                paging,
                IssueClosedByPullRequestsReferencesFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> comments(
            final Paging paging,
            final IssueCommentsFilter arguments,
            final Function<IssueCommentSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "comments",
                child -> selection.apply(new IssueCommentSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueCommentOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> comments(final Paging paging, final Function<IssueCommentSelector, R> selection) {
        return comments(paging, IssueCommentsFilterBuilder.builder().build(), selection);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public boolean createdViaEmail() {
        return cursor.getRequired("createdViaEmail", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R duplicateOf(final Function<IssueSelector, R> selection) {
        return cursor.object("duplicateOf", child -> selection.apply(new IssueSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R editor(final Function<ActorSelector, R> selection) {
        return cursor.object("editor", child -> selection.apply(new ActorSelectorImpl(child)));
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public <R> R hovercard(final IssueHovercardFilter arguments, final Function<HovercardSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.objectRequired(
                "hovercard",
                child -> selection.apply(new HovercardSelectorImpl(child)),
                Argument.of("includeNotificationContexts", BOOLEAN, arguments.includeNotificationContexts()));
    }

    @Override
    public <R> R hovercard(final Function<HovercardSelector, R> selection) {
        return hovercard(IssueHovercardFilterBuilder.builder().build(), selection);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean includesCreatedEdit() {
        return cursor.getRequired("includesCreatedEdit", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean isPinned() {
        return cursor.get("isPinned", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean isReadByViewer() {
        return cursor.get("isReadByViewer", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R issueDependenciesSummary(final Function<IssueDependenciesSummarySelector, R> selection) {
        return cursor.objectRequired(
                "issueDependenciesSummary", child -> selection.apply(new IssueDependenciesSummarySelectorImpl(child)));
    }

    @Override
    public <R> Page<R> issueFieldValues(final Paging paging, final Function<IssueFieldValueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "issueFieldValues",
                child -> selection.apply(new IssueFieldValueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> @Nullable R issueType(final Function<IssueTypeSelector, R> selection) {
        return cursor.object("issueType", child -> selection.apply(new IssueTypeSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> labels(
            final Paging paging, final IssueLabelsFilter arguments, final Function<LabelSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "labels",
                child -> selection.apply(new LabelSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "LabelOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> labels(final Paging paging, final Function<LabelSelector, R> selection) {
        return labels(paging, IssueLabelsFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Instant lastEditedAt() {
        return cursor.get("lastEditedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> Page<R> linkedBranches(final Paging paging, final Function<LinkedBranchSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "linkedBranches",
                child -> selection.apply(new LinkedBranchSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public boolean locked() {
        return cursor.getRequired("locked", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R milestone(final Function<MilestoneSelector, R> selection) {
        return cursor.object("milestone", child -> selection.apply(new MilestoneSelectorImpl(child)));
    }

    @Override
    public int number() {
        return cursor.getRequired("number", ScalarType.INT);
    }

    @Override
    public <R> @Nullable R parent(final Function<IssueSelector, R> selection) {
        return cursor.object("parent", child -> selection.apply(new IssueSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> participants(final Paging paging, final Function<UserSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "participants",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> List<R> pendingSuggestions(final Function<PendingIssueSuggestionSelector, R> selection) {
        return cursor.list(
                "pendingSuggestions", child -> selection.apply(new PendingIssueSuggestionSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R pinnedIssueComment(final Function<PinnedIssueCommentSelector, R> selection) {
        return cursor.object("pinnedIssueComment", child -> selection.apply(new PinnedIssueCommentSelectorImpl(child)));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projectCards(
            final Paging paging,
            final IssueProjectCardsFilter arguments,
            final Function<ProjectCardSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projectCards",
                child -> selection.apply(new ProjectCardSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("archivedStates", "[ProjectCardArchivedState]", arguments.archivedStates()));
    }

    /**
     * @deprecated Projects (classic) is being deprecated in favor of the new Projects experience, see:
     *     https://github.blog/changelog/2024-05-23-sunset-notice-projects-classic/. Removal on 2025-04-01 UTC.
     */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> projectCards(final Paging paging, final Function<ProjectCardSelector, R> selection) {
        return projectCards(paging, IssueProjectCardsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> projectItems(
            final Paging paging,
            final IssueProjectItemsFilter arguments,
            final Function<ProjectV2ItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.page(
                "projectItems",
                child -> selection.apply(new ProjectV2ItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("includeArchived", BOOLEAN, arguments.includeArchived()));
    }

    @Override
    public <R> Page<R> projectItems(final Paging paging, final Function<ProjectV2ItemSelector, R> selection) {
        return projectItems(paging, IssueProjectItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R projectV2(final int number, final Function<ProjectV2Selector, R> selection) {
        return cursor.object(
                "projectV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of("number", INT, number));
    }

    @Override
    public <R> Page<R> projectsV2(
            final Paging paging,
            final IssueProjectsV2Filter arguments,
            final Function<ProjectV2Selector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "projectsV2",
                child -> selection.apply(new ProjectV2SelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("minPermissionLevel", "ProjectV2PermissionLevel", arguments.minPermissionLevel()),
                Argument.of(
                        ORDER_BY,
                        "ProjectV2Order",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("query", STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> projectsV2(final Paging paging, final Function<ProjectV2Selector, R> selection) {
        return projectsV2(paging, IssueProjectsV2FilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Instant publishedAt() {
        return cursor.get("publishedAt", ScalarType.INSTANT);
    }

    @Override
    public <R> List<R> reactionGroups(final Function<ReactionGroupSelector, R> selection) {
        return cursor.list("reactionGroups", child -> selection.apply(new ReactionGroupSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> reactions(
            final Paging paging, final IssueReactionsFilter arguments, final Function<ReactionSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "reactions",
                child -> selection.apply(new ReactionSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("content", "ReactionContent", arguments.content()),
                Argument.of(
                        ORDER_BY,
                        "ReactionOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> reactions(final Paging paging, final Function<ReactionSelector, R> selection) {
        return reactions(paging, IssueReactionsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> relatesTo(
            final Paging paging, final IssueRelatesToFilter arguments, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "relatesTo",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "IssueRelatesToOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> relatesTo(final Paging paging, final Function<IssueSelector, R> selection) {
        return relatesTo(paging, IssueRelatesToFilterBuilder.builder().build(), selection);
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
    public IssueState state() {
        return cursor.getRequired("state", ScalarType.enumeration(IssueState::fromWire, IssueState.CLOSED));
    }

    @Override
    public @Nullable IssueStateReason stateReason(final IssueStateReasonFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.get(
                "stateReason",
                ScalarType.enumeration(IssueStateReason::fromWire, IssueStateReason.COMPLETED),
                Argument.of("enableDuplicate", BOOLEAN, arguments.enableDuplicate()));
    }

    @Override
    public @Nullable IssueStateReason stateReason() {
        return stateReason(IssueStateReasonFilterBuilder.builder().build());
    }

    @Override
    public <R> Page<R> subIssues(final Paging paging, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "subIssues",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> R subIssuesSummary(final Function<SubIssuesSummarySelector, R> selection) {
        return cursor.objectRequired(
                "subIssuesSummary", child -> selection.apply(new SubIssuesSummarySelectorImpl(child)));
    }

    @Override
    public <R> Page<R> suggestedActors(
            final Paging paging,
            final IssueSuggestedActorsFilter arguments,
            final Function<AssigneeSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "suggestedActors",
                child -> selection.apply(new AssigneeSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("query", STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> suggestedActors(final Paging paging, final Function<AssigneeSelector, R> selection) {
        return suggestedActors(
                paging, IssueSuggestedActorsFilterBuilder.builder().build(), selection);
    }

    /** @deprecated `timeline` will be removed Use Issue.timelineItems instead. Removal on 2020-10-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> timeline(
            final Paging paging,
            final IssueTimelineFilter arguments,
            final Function<IssueTimelineItemSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "timeline",
                child -> selection.apply(new IssueTimelineItemSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("since", "DateTime", arguments.since()));
    }

    /** @deprecated `timeline` will be removed Use Issue.timelineItems instead. Removal on 2020-10-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> Page<R> timeline(final Paging paging, final Function<IssueTimelineItemSelector, R> selection) {
        return timeline(paging, IssueTimelineFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> timelineItems(
            final Paging paging,
            final IssueTimelineItemsFilter arguments,
            final Function<IssueTimelineItemsSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "timelineItems",
                child -> selection.apply(new IssueTimelineItemsSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("itemTypes", "[IssueTimelineItemsItemType!]", arguments.itemTypes()),
                Argument.of("since", "DateTime", arguments.since()),
                Argument.of("skip", "Int", arguments.skip()));
    }

    @Override
    public <R> Page<R> timelineItems(final Paging paging, final Function<IssueTimelineItemsSelector, R> selection) {
        return timelineItems(paging, IssueTimelineItemsFilterBuilder.builder().build(), selection);
    }

    @Override
    public String title() {
        return cursor.getRequired("title", ScalarType.STRING);
    }

    @Override
    public String titleHTML() {
        return cursor.getRequired("titleHTML", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> trackedInIssues(final Paging paging, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "trackedInIssues",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public <R> Page<R> trackedIssues(final Paging paging, final Function<IssueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.pageRequired(
                "trackedIssues",
                child -> selection.apply(new IssueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public int trackedIssuesCount(final IssueTrackedIssuesCountFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.getRequired(
                "trackedIssuesCount",
                ScalarType.INT,
                Argument.of("states", "[TrackedIssueStates]", arguments.states()));
    }

    @Override
    public int trackedIssuesCount() {
        return trackedIssuesCount(IssueTrackedIssuesCountFilterBuilder.builder().build());
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> userContentEdits(final Paging paging, final Function<UserContentEditSelector, R> selection) {
        requireNonNull(paging, PAGING);
        return cursor.page(
                "userContentEdits",
                child -> selection.apply(new UserContentEditSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()));
    }

    @Override
    public boolean viewerCanAssign() {
        return cursor.getRequired("viewerCanAssign", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanClose() {
        return cursor.getRequired("viewerCanClose", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanDelete() {
        return cursor.getRequired("viewerCanDelete", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanLabel() {
        return cursor.getRequired("viewerCanLabel", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReact() {
        return cursor.getRequired("viewerCanReact", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanReopen() {
        return cursor.getRequired("viewerCanReopen", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean viewerCanSetFields() {
        return cursor.get("viewerCanSetFields", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanSetMilestone() {
        return cursor.getRequired("viewerCanSetMilestone", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanSubscribe() {
        return cursor.getRequired("viewerCanSubscribe", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean viewerCanType() {
        return cursor.get("viewerCanType", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanUpdate() {
        return cursor.getRequired("viewerCanUpdate", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Boolean viewerCanUpdateMetadata() {
        return cursor.get("viewerCanUpdateMetadata", ScalarType.BOOLEAN);
    }

    @Override
    public List<CommentCannotUpdateReason> viewerCannotUpdateReasons() {
        return cursor.scalarListRequired(
                "viewerCannotUpdateReasons",
                ScalarType.enumeration(CommentCannotUpdateReason::fromWire, CommentCannotUpdateReason.ARCHIVED));
    }

    @Override
    public boolean viewerDidAuthor() {
        return cursor.getRequired("viewerDidAuthor", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable SubscriptionState viewerSubscription() {
        return cursor.get(
                "viewerSubscription", ScalarType.enumeration(SubscriptionState::fromWire, SubscriptionState.IGNORED));
    }

    @Override
    public @Nullable ThreadSubscriptionFormAction viewerThreadSubscriptionFormAction() {
        return cursor.get(
                "viewerThreadSubscriptionFormAction",
                ScalarType.enumeration(ThreadSubscriptionFormAction::fromWire, ThreadSubscriptionFormAction.NONE));
    }

    @Override
    public @Nullable ThreadSubscriptionState viewerThreadSubscriptionStatus() {
        return cursor.get(
                "viewerThreadSubscriptionStatus",
                ScalarType.enumeration(ThreadSubscriptionState::fromWire, ThreadSubscriptionState.DISABLED));
    }
}
