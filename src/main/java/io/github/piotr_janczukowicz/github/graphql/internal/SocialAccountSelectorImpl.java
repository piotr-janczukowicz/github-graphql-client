package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SocialAccountProvider;
import io.github.piotr_janczukowicz.github.graphql.model.SocialAccountSelector;

/** Reads and records the fields of {@code SocialAccount}; used by the generated selection code only. */
final class SocialAccountSelectorImpl implements SocialAccountSelector {

    private final Cursor cursor;

    SocialAccountSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String displayName() {
        return cursor.getRequired("displayName", ScalarType.STRING);
    }

    @Override
    public SocialAccountProvider provider() {
        return cursor.getRequired(
                "provider", ScalarType.enumeration(SocialAccountProvider::fromWire, SocialAccountProvider.BLUESKY));
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
