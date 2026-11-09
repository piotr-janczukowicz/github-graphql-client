package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code VerifiableDomain}. */
public interface VerifiableDomainSelector {

    Instant createdAt();

    @Nullable Integer databaseId();

    @Nullable String dnsHostName();

    String domain();

    boolean hasFoundHostName();

    boolean hasFoundVerificationToken();

    String id();

    boolean isApproved();

    boolean isRequiredForPolicyEnforcement();

    boolean isVerified();

    <R> R owner(Function<VerifiableDomainOwnerSelector, R> selection);

    String punycodeEncodedDomain();

    @Nullable Instant tokenExpirationTime();

    Instant updatedAt();

    @Nullable String verificationToken();
}
