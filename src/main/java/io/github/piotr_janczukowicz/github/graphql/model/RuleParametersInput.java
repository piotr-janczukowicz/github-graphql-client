package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RuleParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RuleParametersInput(
        @Nullable BranchNamePatternParametersInput branchNamePattern,
        @Nullable CodeCoverageParametersInput codeCoverage,
        @Nullable CodeQualityParametersInput codeQuality,
        @Nullable CodeScanningParametersInput codeScanning,
        @Nullable CommitAuthorEmailPatternParametersInput commitAuthorEmailPattern,
        @Nullable CommitMessagePatternParametersInput commitMessagePattern,
        @Nullable CommitterEmailPatternParametersInput committerEmailPattern,
        @Nullable CopilotCodeReviewParametersInput copilotCodeReview,
        @Nullable FileExtensionRestrictionParametersInput fileExtensionRestriction,
        @Nullable FilePathRestrictionParametersInput filePathRestriction,
        @Nullable MaxFilePathLengthParametersInput maxFilePathLength,
        @Nullable MaxFileSizeParametersInput maxFileSize,
        @Nullable MergeQueueParametersInput mergeQueue,
        @Nullable PullRequestParametersInput pullRequest,
        @Nullable RequiredDeploymentsParametersInput requiredDeployments,
        @Nullable RequiredStatusChecksParametersInput requiredStatusChecks,
        @Nullable TagNamePatternParametersInput tagNamePattern,
        @Nullable UpdateParametersInput update,
        @Nullable WorkflowsParametersInput workflows) {

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.branchNamePattern != null) {
            variable.put("branchNamePattern", this.branchNamePattern.toVariable());
        }
        if (this.codeCoverage != null) {
            variable.put("codeCoverage", this.codeCoverage.toVariable());
        }
        if (this.codeQuality != null) {
            variable.put("codeQuality", this.codeQuality.toVariable());
        }
        if (this.codeScanning != null) {
            variable.put("codeScanning", this.codeScanning.toVariable());
        }
        if (this.commitAuthorEmailPattern != null) {
            variable.put("commitAuthorEmailPattern", this.commitAuthorEmailPattern.toVariable());
        }
        if (this.commitMessagePattern != null) {
            variable.put("commitMessagePattern", this.commitMessagePattern.toVariable());
        }
        if (this.committerEmailPattern != null) {
            variable.put("committerEmailPattern", this.committerEmailPattern.toVariable());
        }
        if (this.copilotCodeReview != null) {
            variable.put("copilotCodeReview", this.copilotCodeReview.toVariable());
        }
        if (this.fileExtensionRestriction != null) {
            variable.put("fileExtensionRestriction", this.fileExtensionRestriction.toVariable());
        }
        if (this.filePathRestriction != null) {
            variable.put("filePathRestriction", this.filePathRestriction.toVariable());
        }
        if (this.maxFilePathLength != null) {
            variable.put("maxFilePathLength", this.maxFilePathLength.toVariable());
        }
        if (this.maxFileSize != null) {
            variable.put("maxFileSize", this.maxFileSize.toVariable());
        }
        if (this.mergeQueue != null) {
            variable.put("mergeQueue", this.mergeQueue.toVariable());
        }
        if (this.pullRequest != null) {
            variable.put("pullRequest", this.pullRequest.toVariable());
        }
        if (this.requiredDeployments != null) {
            variable.put("requiredDeployments", this.requiredDeployments.toVariable());
        }
        if (this.requiredStatusChecks != null) {
            variable.put("requiredStatusChecks", this.requiredStatusChecks.toVariable());
        }
        if (this.tagNamePattern != null) {
            variable.put("tagNamePattern", this.tagNamePattern.toVariable());
        }
        if (this.update != null) {
            variable.put("update", this.update.toVariable());
        }
        if (this.workflows != null) {
            variable.put("workflows", this.workflows.toVariable());
        }
        return Collections.unmodifiableMap(variable);
    }
}
