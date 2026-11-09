package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierAdminInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierAdminInfoSponsorshipsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsTierAdminInfoSponsorshipsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import java.util.function.Function;

/** Reads and records the fields of {@code SponsorsTierAdminInfo}; used by the generated selection code only. */
final class SponsorsTierAdminInfoSelectorImpl implements SponsorsTierAdminInfoSelector {

    private final Cursor cursor;

    SponsorsTierAdminInfoSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean isDraft() {
        return cursor.getRequired("isDraft", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isPublished() {
        return cursor.getRequired("isPublished", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isRetired() {
        return cursor.getRequired("isRetired", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> sponsorships(
            final Paging paging,
            final SponsorsTierAdminInfoSponsorshipsFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "sponsorships",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("includePrivate", "Boolean", arguments.includePrivate()),
                Argument.of(
                        "orderBy",
                        "SponsorshipOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsorships(final Paging paging, final Function<SponsorshipSelector, R> selection) {
        return sponsorships(
                paging, SponsorsTierAdminInfoSponsorshipsFilterBuilder.builder().build(), selection);
    }
}
