package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.SubmoduleSelector;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Submodule}; used by the generated selection code only. */
final class SubmoduleSelectorImpl implements SubmoduleSelector {

    private final Cursor cursor;

    SubmoduleSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String branch() {
        return cursor.get("branch", ScalarType.STRING);
    }

    @Override
    public String gitUrl() {
        return cursor.getRequired("gitUrl", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String nameRaw() {
        return cursor.getRequired("nameRaw", ScalarType.STRING);
    }

    @Override
    public String path() {
        return cursor.getRequired("path", ScalarType.STRING);
    }

    @Override
    public String pathRaw() {
        return cursor.getRequired("pathRaw", ScalarType.STRING);
    }

    @Override
    public @Nullable String subprojectCommitOid() {
        return cursor.get("subprojectCommitOid", ScalarType.STRING);
    }
}
