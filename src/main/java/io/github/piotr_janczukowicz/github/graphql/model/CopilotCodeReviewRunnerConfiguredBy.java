package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code CopilotCodeReviewRunnerConfiguredBy}. {@link #UNRECOGNIZED} stands for a value GitHub added
 * after this version.
 */
public enum CopilotCodeReviewRunnerConfiguredBy {
    CODE_REVIEW,
    CODING_AGENT,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<CopilotCodeReviewRunnerConfiguredBy> WIRE_INDEX =
            EnumUtils.index(CopilotCodeReviewRunnerConfiguredBy.class, CopilotCodeReviewRunnerConfiguredBy::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static CopilotCodeReviewRunnerConfiguredBy fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
