package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.BlameRangeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CheckConclusionState;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CheckSuiteSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommitAssociatedPullRequestsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitAuthorBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCheckSuitesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitDeploymentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitHistoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitSignatureSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusCheckRollupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StatusSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubmoduleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubscriptionState;
import io.github.piotr_janczukowicz.github.graphql.model.TreeEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TreeSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class CommitSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"abbreviatedOid\":\"x\"" + "," + "\"additions\":1" + ","
            + "\"associatedPullRequests\":{\"nodes\": [{\"activeLockReason\": \"OFF_TOPIC\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"author\":{\"avatarUrl\": \"x\"}" + "," + "\"authoredByCommitter\":true" + ","
            + "\"authoredDate\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"authors\":{\"nodes\": [{\"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"blame\":{\"ranges\": [{\"age\": 1}]}" + "," + "\"changedFiles\":1" + ","
            + "\"changedFilesIfAvailable\":1" + ","
            + "\"checkSuites\":{\"nodes\": [{\"conclusion\": \"ACTION_REQUIRED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"comments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"commitResourcePath\":\"x\"" + "," + "\"commitUrl\":\"x\"" + ","
            + "\"committedDate\":\"2024-05-01T10:15:30Z\"" + "," + "\"committedViaWeb\":true" + ","
            + "\"committer\":{\"avatarUrl\": \"x\"}" + "," + "\"deletions\":1" + ","
            + "\"deployments\":{\"nodes\": [{\"commitOid\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"file\":{\"extension\": \"x\"}" + ","
            + "\"history\":{\"nodes\": [{\"abbreviatedOid\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"message\":\"x\"" + "," + "\"messageBody\":\"x\"" + ","
            + "\"messageBodyHTML\":\"x\"" + "," + "\"messageHeadline\":\"x\"" + "," + "\"messageHeadlineHTML\":\"x\""
            + "," + "\"oid\":\"x\"" + "," + "\"onBehalfOf\":{\"anyPinnableItems\": true}" + ","
            + "\"parents\":{\"nodes\": [{\"abbreviatedOid\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"pushedDate\":\"2024-05-01T10:15:30Z\"" + "," + "\"repository\":{\"allowUpdateBranch\": true}"
            + "," + "\"resourcePath\":\"x\"" + "," + "\"signature\":{\"email\": \"x\"}" + ","
            + "\"status\":{\"id\": \"x\"}" + "," + "\"statusCheckRollup\":{\"id\": \"x\"}" + ","
            + "\"submodules\":{\"nodes\": [{\"branch\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"tarballUrl\":\"x\"" + "," + "\"tree\":{\"abbreviatedOid\": \"x\"}" + ","
            + "\"treeResourcePath\":\"x\"" + "," + "\"treeUrl\":\"x\"" + "," + "\"url\":\"x\"" + ","
            + "\"viewerCanSubscribe\":true" + "," + "\"viewerSubscription\":\"IGNORED\"" + "," + "\"zipballUrl\":\"x\""
            + "}";

    private static List<Object> readWithArguments(final CommitSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.abbreviatedOid());
        values.add(selector.additions());
        values.add(selector.associatedPullRequests(
                Paging.first(1),
                CommitAssociatedPullRequestsFilterBuilder.builder()
                        .orderBy(PullRequestOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(PullRequestOrderField.CREATED_AT)
                                .build())
                        .build(),
                PullRequestSelector::activeLockReason));
        values.add(selector.author(GitActorSelector::avatarUrl));
        values.add(selector.authoredByCommitter());
        values.add(selector.authoredDate());
        values.add(selector.authors(Paging.first(1), GitActorSelector::avatarUrl));
        values.add(selector.blame("x", child -> child.ranges(BlameRangeSelector::age)));
        values.add(selector.changedFiles());
        values.add(selector.changedFilesIfAvailable());
        values.add(selector.checkSuites(
                Paging.first(1),
                CommitCheckSuitesFilterBuilder.builder()
                        .filterBy(CheckSuiteFilterBuilder.builder().build())
                        .build(),
                CheckSuiteSelector::conclusion));
        values.add(selector.comments(Paging.first(1), CommitCommentSelector::authorAssociation));
        values.add(selector.commitResourcePath());
        values.add(selector.commitUrl());
        values.add(selector.committedDate());
        values.add(selector.committedViaWeb());
        values.add(selector.committer(GitActorSelector::avatarUrl));
        values.add(selector.deletions());
        values.add(selector.deployments(
                Paging.first(1),
                CommitDeploymentsFilterBuilder.builder()
                        .environments(List.of("x"))
                        .orderBy(DeploymentOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(DeploymentOrderField.CREATED_AT)
                                .build())
                        .build(),
                DeploymentSelector::commitOid));
        values.add(selector.file("x", TreeEntrySelector::extension));
        values.add(selector.history(
                Paging.first(1),
                CommitHistoryFilterBuilder.builder()
                        .author(CommitAuthorBuilder.builder().build())
                        .path("x")
                        .since(OffsetDateTime.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .until(OffsetDateTime.parse(VALUE_2024_05_01_T10_15_30_Z))
                        .build(),
                CommitSelector::abbreviatedOid));
        values.add(selector.id());
        values.add(selector.message());
        values.add(selector.messageBody());
        values.add(selector.messageBodyHTML());
        values.add(selector.messageHeadline());
        values.add(selector.messageHeadlineHTML());
        values.add(selector.oid());
        values.add(selector.onBehalfOf(OrganizationSelector::anyPinnableItems));
        values.add(selector.parents(Paging.first(1), CommitSelector::abbreviatedOid));
        values.add(selector.pushedDate());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.signature(GitSignatureSelector::email));
        values.add(selector.status(StatusSelector::id));
        values.add(selector.statusCheckRollup(StatusCheckRollupSelector::id));
        values.add(selector.submodules(Paging.first(1), SubmoduleSelector::branch));
        values.add(selector.tarballUrl());
        values.add(selector.tree(TreeSelector::abbreviatedOid));
        values.add(selector.treeResourcePath());
        values.add(selector.treeUrl());
        values.add(selector.url());
        values.add(selector.viewerCanSubscribe());
        values.add(selector.viewerSubscription());
        values.add(selector.zipballUrl());
        return values;
    }

    private static List<Object> readWithoutArguments(final CommitSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.associatedPullRequests(Paging.first(1), PullRequestSelector::activeLockReason));
        values.add(selector.checkSuites(Paging.first(1), CheckSuiteSelector::conclusion));
        values.add(selector.deployments(Paging.first(1), DeploymentSelector::commitOid));
        values.add(selector.history(Paging.first(1), CommitSelector::abbreviatedOid));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CommitSelectorImpl(new RecordingCursor(root)));
        final CommitSelectorImpl selector = new CommitSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        1,
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        "x",
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of("x"), false, null),
                        List.of(1),
                        1,
                        1,
                        new Page<>(List.of(CheckConclusionState.ACTION_REQUIRED), false, null),
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        "x",
                        1,
                        new Page<>(List.of("x"), false, null),
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        new Page<>(List.of("x"), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        "x",
                        "x",
                        "x",
                        "x",
                        new Page<>(List.of("x"), false, null),
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        true,
                        SubscriptionState.IGNORED,
                        "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new CommitSelectorImpl(new RecordingCursor(root)));
        final CommitSelectorImpl selector = new CommitSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(LockReason.OFF_TOPIC), false, null),
                        new Page<>(List.of(CheckConclusionState.ACTION_REQUIRED), false, null),
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of("x"), false, null));
    }
}
