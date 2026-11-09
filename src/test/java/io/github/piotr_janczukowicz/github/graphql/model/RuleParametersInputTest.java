package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RuleParametersInputTest {

    private static final String OPERATOR = "operator";

    private static final String PATTERN = "pattern";

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final RuleParametersInput input = RuleParametersInputBuilder.builder().build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).isEmpty();
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RuleParametersInput input = RuleParametersInputBuilder.builder()
                .branchNamePattern(BranchNamePatternParametersInputBuilder.builder()
                        .operator("x")
                        .pattern("x")
                        .build())
                .codeCoverage(CodeCoverageParametersInputBuilder.builder().build())
                .codeQuality(CodeQualityParametersInputBuilder.builder()
                        .severity(CodeQualitySeverity.ALL)
                        .build())
                .codeScanning(CodeScanningParametersInputBuilder.builder()
                        .codeScanningTools(List.of(CodeScanningToolInputBuilder.builder()
                                .alertsThreshold("x")
                                .securityAlertsThreshold("x")
                                .tool("x")
                                .build()))
                        .build())
                .commitAuthorEmailPattern(CommitAuthorEmailPatternParametersInputBuilder.builder()
                        .operator("x")
                        .pattern("x")
                        .build())
                .commitMessagePattern(CommitMessagePatternParametersInputBuilder.builder()
                        .operator("x")
                        .pattern("x")
                        .build())
                .committerEmailPattern(CommitterEmailPatternParametersInputBuilder.builder()
                        .operator("x")
                        .pattern("x")
                        .build())
                .copilotCodeReview(
                        CopilotCodeReviewParametersInputBuilder.builder().build())
                .fileExtensionRestriction(FileExtensionRestrictionParametersInputBuilder.builder()
                        .restrictedFileExtensions(List.of("x"))
                        .build())
                .filePathRestriction(FilePathRestrictionParametersInputBuilder.builder()
                        .restrictedFilePaths(List.of("x"))
                        .build())
                .maxFilePathLength(MaxFilePathLengthParametersInputBuilder.builder()
                        .maxFilePathLength(1)
                        .build())
                .maxFileSize(MaxFileSizeParametersInputBuilder.builder()
                        .maxFileSize(1)
                        .build())
                .mergeQueue(MergeQueueParametersInputBuilder.builder()
                        .checkResponseTimeoutMinutes(1)
                        .groupingStrategy(MergeQueueGroupingStrategy.ALLGREEN)
                        .maxEntriesToBuild(1)
                        .maxEntriesToMerge(1)
                        .mergeMethod(MergeQueueMergeMethod.MERGE)
                        .minEntriesToMerge(1)
                        .minEntriesToMergeWaitMinutes(1)
                        .build())
                .pullRequest(PullRequestParametersInputBuilder.builder()
                        .dismissStaleReviewsOnPush(true)
                        .requireCodeOwnerReview(true)
                        .requireLastPushApproval(true)
                        .requiredApprovingReviewCount(1)
                        .requiredReviewThreadResolution(true)
                        .build())
                .requiredDeployments(RequiredDeploymentsParametersInputBuilder.builder()
                        .requiredDeploymentEnvironments(List.of("x"))
                        .build())
                .requiredStatusChecks(RequiredStatusChecksParametersInputBuilder.builder()
                        .requiredStatusChecks(List.of(StatusCheckConfigurationInputBuilder.builder()
                                .context("x")
                                .build()))
                        .strictRequiredStatusChecksPolicy(true)
                        .build())
                .tagNamePattern(TagNamePatternParametersInputBuilder.builder()
                        .operator("x")
                        .pattern("x")
                        .build())
                .update(UpdateParametersInputBuilder.builder()
                        .updateAllowsFetchAndMerge(true)
                        .build())
                .workflows(WorkflowsParametersInputBuilder.builder()
                        .workflows(List.of(WorkflowFileReferenceInputBuilder.builder()
                                .path("x")
                                .repositoryId(1)
                                .build()))
                        .build())
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("branchNamePattern", Map.ofEntries(entry(OPERATOR, "x"), entry(PATTERN, "x"))),
                        entry("codeCoverage", Map.ofEntries()),
                        entry("codeQuality", Map.ofEntries(entry("severity", "ALL"))),
                        entry(
                                "codeScanning",
                                Map.ofEntries(entry(
                                        "codeScanningTools",
                                        List.of(Map.ofEntries(
                                                entry("alertsThreshold", "x"),
                                                entry("securityAlertsThreshold", "x"),
                                                entry("tool", "x")))))),
                        entry("commitAuthorEmailPattern", Map.ofEntries(entry(OPERATOR, "x"), entry(PATTERN, "x"))),
                        entry("commitMessagePattern", Map.ofEntries(entry(OPERATOR, "x"), entry(PATTERN, "x"))),
                        entry("committerEmailPattern", Map.ofEntries(entry(OPERATOR, "x"), entry(PATTERN, "x"))),
                        entry("copilotCodeReview", Map.ofEntries()),
                        entry(
                                "fileExtensionRestriction",
                                Map.ofEntries(entry("restrictedFileExtensions", List.of("x")))),
                        entry("filePathRestriction", Map.ofEntries(entry("restrictedFilePaths", List.of("x")))),
                        entry("maxFilePathLength", Map.ofEntries(entry("maxFilePathLength", 1))),
                        entry("maxFileSize", Map.ofEntries(entry("maxFileSize", 1))),
                        entry(
                                "mergeQueue",
                                Map.ofEntries(
                                        entry("checkResponseTimeoutMinutes", 1),
                                        entry("groupingStrategy", "ALLGREEN"),
                                        entry("maxEntriesToBuild", 1),
                                        entry("maxEntriesToMerge", 1),
                                        entry("mergeMethod", "MERGE"),
                                        entry("minEntriesToMerge", 1),
                                        entry("minEntriesToMergeWaitMinutes", 1))),
                        entry(
                                "pullRequest",
                                Map.ofEntries(
                                        entry("dismissStaleReviewsOnPush", true),
                                        entry("requireCodeOwnerReview", true),
                                        entry("requireLastPushApproval", true),
                                        entry("requiredApprovingReviewCount", 1),
                                        entry("requiredReviewThreadResolution", true))),
                        entry(
                                "requiredDeployments",
                                Map.ofEntries(entry("requiredDeploymentEnvironments", List.of("x")))),
                        entry(
                                "requiredStatusChecks",
                                Map.ofEntries(
                                        entry("requiredStatusChecks", List.of(Map.ofEntries(entry("context", "x")))),
                                        entry("strictRequiredStatusChecksPolicy", true))),
                        entry("tagNamePattern", Map.ofEntries(entry(OPERATOR, "x"), entry(PATTERN, "x"))),
                        entry("update", Map.ofEntries(entry("updateAllowsFetchAndMerge", true))),
                        entry(
                                "workflows",
                                Map.ofEntries(entry(
                                        "workflows",
                                        List.of(Map.ofEntries(entry("path", "x"), entry("repositoryId", 1)))))));
    }
}
