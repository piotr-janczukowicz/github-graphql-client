package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorAndLifetimeValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableLifetimeReceivedSponsorshipValuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableLifetimeReceivedSponsorshipValuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsoringFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsoringFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorsActivitiesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorsActivitiesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipForViewerAsSponsorFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipForViewerAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipForViewerAsSponsorableFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipForViewerAsSponsorableFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipNewslettersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipNewslettersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipsAsMaintainerFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipsAsMaintainerFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipsAsSponsorFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableSponsorshipsAsSponsorFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableTotalSponsorshipAmountAsSponsorInCentsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorableTotalSponsorshipAmountAsSponsorInCentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsActivitySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorsListingSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipNewsletterSelector;
import io.github.piotr_janczukowicz.github.graphql.model.SponsorshipSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Sponsorable}; used by the generated selection code only. */
final class SponsorableSelectorImpl implements SponsorableSelector {

    private static final String PAGING = "paging";

    private static final String ARGUMENTS = "arguments";

    private static final String FIRST = "first";

    private static final String INT = "Int!";

    private static final String AFTER = "after";

    private static final String STRING = "String";

    private static final String ORDER_BY = "orderBy";

    private static final String BOOLEAN = "Boolean";

    private static final String DATE_TIME = "DateTime";

    private static final String ACTIVE_ONLY = "activeOnly";

    private final Cursor cursor;

    SponsorableSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int estimatedNextSponsorsPayoutInCents() {
        return cursor.getRequired("estimatedNextSponsorsPayoutInCents", ScalarType.INT);
    }

    @Override
    public boolean hasSponsorsListing() {
        return cursor.getRequired("hasSponsorsListing", ScalarType.BOOLEAN);
    }

    @Override
    public boolean isSponsoredBy(final String accountLogin) {
        requireNonNull(accountLogin, "accountLogin");
        return cursor.getRequired(
                "isSponsoredBy", ScalarType.BOOLEAN, Argument.of("accountLogin", "String!", accountLogin));
    }

    @Override
    public boolean isSponsoringViewer() {
        return cursor.getRequired("isSponsoringViewer", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> lifetimeReceivedSponsorshipValues(
            final Paging paging,
            final SponsorableLifetimeReceivedSponsorshipValuesFilter arguments,
            final Function<SponsorAndLifetimeValueSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "lifetimeReceivedSponsorshipValues",
                child -> selection.apply(new SponsorAndLifetimeValueSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorAndLifetimeValueOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> lifetimeReceivedSponsorshipValues(
            final Paging paging, final Function<SponsorAndLifetimeValueSelector, R> selection) {
        return lifetimeReceivedSponsorshipValues(
                paging,
                SponsorableLifetimeReceivedSponsorshipValuesFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public int monthlyEstimatedSponsorsIncomeInCents() {
        return cursor.getRequired("monthlyEstimatedSponsorsIncomeInCents", ScalarType.INT);
    }

    @Override
    public <R> Page<R> sponsoring(
            final Paging paging,
            final SponsorableSponsoringFilter arguments,
            final Function<SponsorSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsoring",
                child -> selection.apply(new SponsorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsoring(final Paging paging, final Function<SponsorSelector, R> selection) {
        return sponsoring(paging, SponsorableSponsoringFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsors(
            final Paging paging,
            final SponsorableSponsorsFilter arguments,
            final Function<SponsorSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsors",
                child -> selection.apply(new SponsorSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("tierId", "ID", arguments.tierId()));
    }

    @Override
    public <R> Page<R> sponsors(final Paging paging, final Function<SponsorSelector, R> selection) {
        return sponsors(paging, SponsorableSponsorsFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsorsActivities(
            final Paging paging,
            final SponsorableSponsorsActivitiesFilter arguments,
            final Function<SponsorsActivitySelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorsActivities",
                child -> selection.apply(new SponsorsActivitySelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of("actions", "[SponsorsActivityAction!]", arguments.actions()),
                Argument.of("includeAsSponsor", BOOLEAN, arguments.includeAsSponsor()),
                Argument.of("includePrivate", BOOLEAN, arguments.includePrivate()),
                Argument.of(
                        ORDER_BY,
                        "SponsorsActivityOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("period", "SponsorsActivityPeriod", arguments.period()),
                Argument.of("since", DATE_TIME, arguments.since()),
                Argument.of("until", DATE_TIME, arguments.until()));
    }

    @Override
    public <R> Page<R> sponsorsActivities(final Paging paging, final Function<SponsorsActivitySelector, R> selection) {
        return sponsorsActivities(
                paging, SponsorableSponsorsActivitiesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R sponsorsListing(final Function<SponsorsListingSelector, R> selection) {
        return cursor.object("sponsorsListing", child -> selection.apply(new SponsorsListingSelectorImpl(child)));
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsor(
            final SponsorableSponsorshipForViewerAsSponsorFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "sponsorshipForViewerAsSponsor",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()));
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsor(final Function<SponsorshipSelector, R> selection) {
        return sponsorshipForViewerAsSponsor(
                SponsorableSponsorshipForViewerAsSponsorFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsorable(
            final SponsorableSponsorshipForViewerAsSponsorableFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.object(
                "sponsorshipForViewerAsSponsorable",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()));
    }

    @Override
    public <R> @Nullable R sponsorshipForViewerAsSponsorable(final Function<SponsorshipSelector, R> selection) {
        return sponsorshipForViewerAsSponsorable(
                SponsorableSponsorshipForViewerAsSponsorableFilterBuilder.builder()
                        .build(),
                selection);
    }

    @Override
    public <R> Page<R> sponsorshipNewsletters(
            final Paging paging,
            final SponsorableSponsorshipNewslettersFilter arguments,
            final Function<SponsorshipNewsletterSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipNewsletters",
                child -> selection.apply(new SponsorshipNewsletterSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(
                        ORDER_BY,
                        "SponsorshipNewsletterOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsorshipNewsletters(
            final Paging paging, final Function<SponsorshipNewsletterSelector, R> selection) {
        return sponsorshipNewsletters(
                paging, SponsorableSponsorshipNewslettersFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> Page<R> sponsorshipsAsMaintainer(
            final Paging paging,
            final SponsorableSponsorshipsAsMaintainerFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipsAsMaintainer",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()),
                Argument.of("includePrivate", BOOLEAN, arguments.includePrivate()),
                Argument.of(
                        ORDER_BY,
                        "SponsorshipOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsorshipsAsMaintainer(final Paging paging, final Function<SponsorshipSelector, R> selection) {
        return sponsorshipsAsMaintainer(
                paging,
                SponsorableSponsorshipsAsMaintainerFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public <R> Page<R> sponsorshipsAsSponsor(
            final Paging paging,
            final SponsorableSponsorshipsAsSponsorFilter arguments,
            final Function<SponsorshipSelector, R> selection) {
        requireNonNull(paging, PAGING);
        requireNonNull(arguments, ARGUMENTS);
        return cursor.pageRequired(
                "sponsorshipsAsSponsor",
                child -> selection.apply(new SponsorshipSelectorImpl(child)),
                Argument.of(FIRST, INT, paging.first()),
                Argument.of(AFTER, STRING, paging.after()),
                Argument.of(ACTIVE_ONLY, BOOLEAN, arguments.activeOnly()),
                Argument.of("maintainerLogins", "[String!]", arguments.maintainerLogins()),
                Argument.of(
                        ORDER_BY,
                        "SponsorshipOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> sponsorshipsAsSponsor(final Paging paging, final Function<SponsorshipSelector, R> selection) {
        return sponsorshipsAsSponsor(
                paging, SponsorableSponsorshipsAsSponsorFilterBuilder.builder().build(), selection);
    }

    @Override
    public @Nullable Integer totalSponsorshipAmountAsSponsorInCents(
            final SponsorableTotalSponsorshipAmountAsSponsorInCentsFilter arguments) {
        requireNonNull(arguments, ARGUMENTS);
        return cursor.get(
                "totalSponsorshipAmountAsSponsorInCents",
                ScalarType.INT,
                Argument.of("since", DATE_TIME, arguments.since()),
                Argument.of("sponsorableLogins", "[String!]", arguments.sponsorableLogins()),
                Argument.of("until", DATE_TIME, arguments.until()));
    }

    @Override
    public @Nullable Integer totalSponsorshipAmountAsSponsorInCents() {
        return totalSponsorshipAmountAsSponsorInCents(
                SponsorableTotalSponsorshipAmountAsSponsorInCentsFilterBuilder.builder()
                        .build());
    }

    @Override
    public boolean viewerCanSponsor() {
        return cursor.getRequired("viewerCanSponsor", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerIsSponsoring() {
        return cursor.getRequired("viewerIsSponsoring", ScalarType.BOOLEAN);
    }

    @Override
    public <S, R> @Nullable R on(final Class<S> type, final Function<S, R> selection) {
        return Branches.on(cursor, SponsorableSelector.class, type, selection);
    }
}
