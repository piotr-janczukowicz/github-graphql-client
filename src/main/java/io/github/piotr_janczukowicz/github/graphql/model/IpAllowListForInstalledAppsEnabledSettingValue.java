package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code IpAllowListForInstalledAppsEnabledSettingValue}. {@link #UNRECOGNIZED} stands for a value
 * GitHub added after this version.
 */
public enum IpAllowListForInstalledAppsEnabledSettingValue {
    DISABLED,
    ENABLED,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<IpAllowListForInstalledAppsEnabledSettingValue> WIRE_INDEX =
            EnumUtils.index(
                    IpAllowListForInstalledAppsEnabledSettingValue.class,
                    IpAllowListForInstalledAppsEnabledSettingValue::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static IpAllowListForInstalledAppsEnabledSettingValue fromWire(final String value) {
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
