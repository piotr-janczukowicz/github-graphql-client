package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryContactLinkSelector;

/** Reads and records the fields of {@code RepositoryContactLink}; used by the generated selection code only. */
final class RepositoryContactLinkSelectorImpl implements RepositoryContactLinkSelector {

    private final Cursor cursor;

    RepositoryContactLinkSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String about() {
        return cursor.getRequired("about", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }
}
