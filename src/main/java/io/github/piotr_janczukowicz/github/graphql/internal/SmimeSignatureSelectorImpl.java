package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.GitSignatureState;
import io.github.piotr_janczukowicz.github.graphql.model.SmimeSignatureSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SmimeSignature}; used by the generated selection code only. */
final class SmimeSignatureSelectorImpl implements SmimeSignatureSelector {

    private final Cursor cursor;

    SmimeSignatureSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String email() {
        return cursor.getRequired("email", ScalarType.STRING);
    }

    @Override
    public boolean isValid() {
        return cursor.getRequired("isValid", ScalarType.BOOLEAN);
    }

    @Override
    public String payload() {
        return cursor.getRequired("payload", ScalarType.STRING);
    }

    @Override
    public String signature() {
        return cursor.getRequired("signature", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R signer(final Function<UserSelector, R> selection) {
        return cursor.object("signer", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public GitSignatureState state() {
        return cursor.getRequired(
                "state", ScalarType.enumeration(GitSignatureState::fromWire, GitSignatureState.BAD_CERT));
    }

    @Override
    public @Nullable Instant verifiedAt() {
        return cursor.get("verifiedAt", ScalarType.INSTANT);
    }

    @Override
    public boolean wasSignedByGitHub() {
        return cursor.getRequired("wasSignedByGitHub", ScalarType.BOOLEAN);
    }
}
