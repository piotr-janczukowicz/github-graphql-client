package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code SponsorshipNewsletter}; used by the generated selection code only. */
final class SponsorshipNewsletterSelectorImpl implements SponsorshipNewsletterSelector {

    private final Cursor cursor;

    SponsorshipNewsletterSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R author(final Function<UserSelector, R> selection) {
        return cursor.object("author", child -> selection.apply(new UserSelectorImpl(child)));
    }

    @Override
    public String body() {
        return cursor.getRequired("body", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isPublished() {
        return cursor.getRequired("isPublished", ScalarType.BOOLEAN);
    }

    @Override
    public <R> R sponsorable(final Function<SponsorableSelector, R> selection) {
        return cursor.objectRequired("sponsorable", child -> selection.apply(new SponsorableSelectorImpl(child)));
    }

    @Override
    public String subject() {
        return cursor.getRequired("subject", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
