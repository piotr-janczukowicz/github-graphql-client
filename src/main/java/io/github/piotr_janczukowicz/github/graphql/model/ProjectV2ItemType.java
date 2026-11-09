package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code ProjectV2ItemType}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version.
 */
public enum ProjectV2ItemType {
    DRAFT_ISSUE,
    ISSUE,
    PULL_REQUEST,
    REDACTED,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<ProjectV2ItemType> WIRE_INDEX =
            EnumUtils.index(ProjectV2ItemType.class, ProjectV2ItemType::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static ProjectV2ItemType fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
