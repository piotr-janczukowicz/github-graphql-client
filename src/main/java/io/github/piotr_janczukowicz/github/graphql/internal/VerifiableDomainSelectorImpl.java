package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.VerifiableDomainSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code VerifiableDomain}; used by the generated selection code only. */
final class VerifiableDomainSelectorImpl implements VerifiableDomainSelector {

    private final Cursor cursor;

    VerifiableDomainSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable String dnsHostName() {
        return cursor.get("dnsHostName", ScalarType.STRING);
    }

    @Override
    public String domain() {
        return cursor.getRequired("domain", ScalarType.STRING);
    }

    @Override
    public boolean hasFoundHostName() {
        return cursor.getRequired("hasFoundHostName", ScalarType.BOOLEAN);
    }

    @Override
    public boolean hasFoundVerificationToken() {
        return cursor.getRequired("hasFoundVerificationToken", ScalarType.BOOLEAN);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isApproved() {
        return cursor.getRequired("isApproved", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isRequiredForPolicyEnforcement() {
        return cursor.getRequired("isRequiredForPolicyEnforcement", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isVerified() {
        return cursor.getRequired("isVerified", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R owner(final Function<VerifiableDomainOwnerSelector, R> selection) {
        return cursor.objectRequired("owner", child -> selection.apply(new VerifiableDomainOwnerSelectorImpl(child)));
    }

    @Override
    public String punycodeEncodedDomain() {
        return cursor.getRequired("punycodeEncodedDomain", ScalarType.STRING);
    }

    @Override
    public @Nullable Instant tokenExpirationTime() {
        return cursor.get("tokenExpirationTime", ScalarType.INSTANT);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String verificationToken() {
        return cursor.get("verificationToken", ScalarType.STRING);
    }
}
