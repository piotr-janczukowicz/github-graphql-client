package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentityScimAttributesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserEmailMetadataSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ExternalIdentityScimAttributes}; used by the generated selection code only.
 */
final class ExternalIdentityScimAttributesSelectorImpl implements ExternalIdentityScimAttributesSelector {

    private final Cursor cursor;

    ExternalIdentityScimAttributesSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> emails(final Function<UserEmailMetadataSelector, R> selection) {
        return cursor.list("emails", child -> selection.apply(new UserEmailMetadataSelectorImpl(child)));
    }

    @Override
    public @Nullable String familyName() {
        return cursor.get("familyName", ScalarType.STRING);
    }

    @Override
    public @Nullable String givenName() {
        return cursor.get("givenName", ScalarType.STRING);
    }

    @Override
    public List<String> groups() {
        return cursor.scalarList("groups", ScalarType.STRING);
    }

    @Override
    public @Nullable String username() {
        return cursor.get("username", ScalarType.STRING);
    }
}
