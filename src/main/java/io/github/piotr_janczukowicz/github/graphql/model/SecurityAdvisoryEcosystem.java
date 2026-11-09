package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code SecurityAdvisoryEcosystem}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum SecurityAdvisoryEcosystem {
    ACTIONS,
    COMPOSER,
    ERLANG,
    GO,
    MAVEN,
    NPM,
    NUGET,
    PIP,
    PUB,
    RUBYGEMS,
    RUST,
    SWIFT,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<SecurityAdvisoryEcosystem> WIRE_INDEX =
            EnumUtils.index(SecurityAdvisoryEcosystem.class, SecurityAdvisoryEcosystem::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static SecurityAdvisoryEcosystem fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
