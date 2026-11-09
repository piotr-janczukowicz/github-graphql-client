package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code SshSignature}. */
public interface SshSignatureSelector {

    String email();

    boolean isValid();

    @Nullable String keyFingerprint();

    String payload();

    String signature();

    <R> @Nullable R signer(Function<UserSelector, R> selection);

    GitSignatureState state();

    @Nullable Instant verifiedAt();

    boolean wasSignedByGitHub();
}
