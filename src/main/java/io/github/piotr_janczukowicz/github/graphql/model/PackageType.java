package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/** The GraphQL enum {@code PackageType}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version. */
public enum PackageType {
    DEBIAN,
    /**
     * @deprecated DOCKER will be removed from this enum as this type will be migrated to only be used by the Packages
     *     REST API. Removal on 2021-06-21 UTC.
     */
    @Deprecated(forRemoval = true)
    DOCKER,
    /**
     * @deprecated MAVEN will be removed from this enum as this type will be migrated to only be used by the Packages
     *     REST API. Removal on 2023-02-10 UTC.
     */
    @Deprecated(forRemoval = true)
    MAVEN,
    /**
     * @deprecated NPM will be removed from this enum as this type will be migrated to only be used by the Packages REST
     *     API. Removal on 2022-11-21 UTC.
     */
    @Deprecated(forRemoval = true)
    NPM,
    /**
     * @deprecated NUGET will be removed from this enum as this type will be migrated to only be used by the Packages
     *     REST API. Removal on 2022-11-21 UTC.
     */
    @Deprecated(forRemoval = true)
    NUGET,
    PYPI,
    /**
     * @deprecated RUBYGEMS will be removed from this enum as this type will be migrated to only be used by the Packages
     *     REST API. Removal on 2022-12-28 UTC.
     */
    @Deprecated(forRemoval = true)
    RUBYGEMS,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<PackageType> WIRE_INDEX =
            EnumUtils.index(PackageType.class, PackageType::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static PackageType fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
