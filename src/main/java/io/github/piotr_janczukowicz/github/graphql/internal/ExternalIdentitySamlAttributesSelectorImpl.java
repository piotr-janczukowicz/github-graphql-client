package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentityAttributeSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ExternalIdentitySamlAttributesSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserEmailMetadataSelector;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code ExternalIdentitySamlAttributes}; used by the generated selection code only.
 */
final class ExternalIdentitySamlAttributesSelectorImpl implements ExternalIdentitySamlAttributesSelector {

    private final Cursor cursor;

    ExternalIdentitySamlAttributesSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> List<R> attributes(final Function<ExternalIdentityAttributeSelector, R> selection) {
        return cursor.listRequired(
                "attributes", child -> selection.apply(new ExternalIdentityAttributeSelectorImpl(child)));
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
    public @Nullable String nameId() {
        return cursor.get("nameId", ScalarType.STRING);
    }

    @Override
    public @Nullable String username() {
        return cursor.get("username", ScalarType.STRING);
    }
}
