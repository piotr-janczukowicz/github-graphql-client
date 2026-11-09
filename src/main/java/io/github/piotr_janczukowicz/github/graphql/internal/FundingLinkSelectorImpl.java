package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.FundingLinkSelector;
import io.github.piotr_janczukowicz.github.graphql.model.FundingPlatform;

/** Reads and records the fields of {@code FundingLink}; used by the generated selection code only. */
final class FundingLinkSelectorImpl implements FundingLinkSelector {

    private final Cursor cursor;

    FundingLinkSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public FundingPlatform platform() {
        return cursor.getRequired(
                "platform", ScalarType.enumeration(FundingPlatform::fromWire, FundingPlatform.BUY_ME_A_COFFEE));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
