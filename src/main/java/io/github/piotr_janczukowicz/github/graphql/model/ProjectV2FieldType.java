package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code ProjectV2FieldType}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum ProjectV2FieldType {
    ASSIGNEES,
    CLOSED,
    CREATED,
    DATE,
    ISSUE_TYPE,
    ITERATION,
    LABELS,
    LINKED_PULL_REQUESTS,
    MILESTONE,
    MULTI_SELECT,
    NUMBER,
    PARENT_ISSUE,
    REPOSITORY,
    REVIEWERS,
    SINGLE_SELECT,
    SUB_ISSUES_PROGRESS,
    TEXT,
    TITLE,
    TRACKED_BY,
    TRACKS,
    UPDATED,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<ProjectV2FieldType> WIRE_INDEX =
            EnumUtils.index(ProjectV2FieldType.class, ProjectV2FieldType::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static ProjectV2FieldType fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
