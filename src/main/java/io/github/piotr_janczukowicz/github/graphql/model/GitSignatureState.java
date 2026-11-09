package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code GitSignatureState}. {@link #UNRECOGNIZED} stands for a value GitHub added after this version.
 */
public enum GitSignatureState {
    BAD_CERT,
    BAD_EMAIL,
    EXPIRED_KEY,
    GPGVERIFY_ERROR,
    GPGVERIFY_UNAVAILABLE,
    INVALID,
    MALFORMED_SIG,
    NOT_SIGNING_KEY,
    NO_USER,
    OCSP_ERROR,
    OCSP_PENDING,
    OCSP_REVOKED,
    UNKNOWN_KEY,
    UNKNOWN_SIG_TYPE,
    UNSIGNED,
    UNVERIFIED_EMAIL,
    VALID,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<GitSignatureState> WIRE_INDEX =
            EnumUtils.index(GitSignatureState.class, GitSignatureState::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static GitSignatureState fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
