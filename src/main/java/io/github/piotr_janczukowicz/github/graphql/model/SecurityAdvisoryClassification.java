package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code SecurityAdvisoryClassification}. {@link #UNRECOGNIZED} stands for a value GitHub added after
 * this version.
 */
public enum SecurityAdvisoryClassification {
    GENERAL,
    MALWARE,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<SecurityAdvisoryClassification> WIRE_INDEX =
            EnumUtils.index(SecurityAdvisoryClassification.class, SecurityAdvisoryClassification::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static SecurityAdvisoryClassification fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
