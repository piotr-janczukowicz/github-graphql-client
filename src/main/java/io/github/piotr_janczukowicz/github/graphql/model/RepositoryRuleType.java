package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code RepositoryRuleType}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum RepositoryRuleType {
    AUTHORIZATION,
    BRANCH_NAME_PATTERN,
    CODE_COVERAGE,
    CODE_QUALITY,
    CODE_SCANNING,
    COMMITTER_EMAIL_PATTERN,
    COMMIT_AUTHOR_EMAIL_PATTERN,
    COMMIT_MESSAGE_PATTERN,
    COPILOT_CODE_REVIEW,
    CREATION,
    DELETION,
    FILE_EXTENSION_RESTRICTION,
    FILE_PATH_RESTRICTION,
    LICENSE_COMPLIANCE_SCANNING,
    LOCK_BRANCH,
    MAX_FILE_PATH_LENGTH,
    MAX_FILE_SIZE,
    MAX_REF_UPDATES,
    MERGE_QUEUE,
    MERGE_QUEUE_LOCKED_REF,
    NON_FAST_FORWARD,
    PULL_REQUEST,
    REQUIRED_DEPLOYMENTS,
    REQUIRED_LINEAR_HISTORY,
    REQUIRED_REVIEW_THREAD_RESOLUTION,
    REQUIRED_SIGNATURES,
    REQUIRED_STATUS_CHECKS,
    REQUIRED_WORKFLOW_STATUS_CHECKS,
    SECRET_SCANNING,
    TAG,
    TAG_NAME_PATTERN,
    UPDATE,
    WORKFLOWS,
    WORKFLOW_UPDATES,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<RepositoryRuleType> WIRE_INDEX =
            EnumUtils.index(RepositoryRuleType.class, RepositoryRuleType::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static RepositoryRuleType fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }

    /**
     * Returns the value name GraphQL expects when this constant is sent.
     *
     * @return the GraphQL value name
     * @throws IllegalArgumentException when this is {@link #UNRECOGNIZED}, which cannot be sent
     */
    public String wireValue() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("UNRECOGNIZED cannot be sent to GitHub");
        }
        return name();
    }
}
