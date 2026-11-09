package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseRepositoryInfoSelector;

/** Reads and records the fields of {@code EnterpriseRepositoryInfo}; used by the generated selection code only. */
final class EnterpriseRepositoryInfoSelectorImpl implements EnterpriseRepositoryInfoSelector {

    private final Cursor cursor;

    EnterpriseRepositoryInfoSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isPrivate() {
        return cursor.getRequired("isPrivate", ScalarType.BOOLEAN);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String nameWithOwner() {
        return cursor.getRequired("nameWithOwner", ScalarType.STRING);
    }
}
