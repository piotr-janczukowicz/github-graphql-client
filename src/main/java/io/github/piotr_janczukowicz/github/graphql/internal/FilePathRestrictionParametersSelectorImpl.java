package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.FilePathRestrictionParametersSelector;
import java.util.List;

/** Reads and records the fields of {@code FilePathRestrictionParameters}; used by the generated selection code only. */
final class FilePathRestrictionParametersSelectorImpl implements FilePathRestrictionParametersSelector {

    private final Cursor cursor;

    FilePathRestrictionParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> ignoredFilePaths() {
        return cursor.scalarList("ignoredFilePaths", ScalarType.STRING);
    }

    @Override
    public List<String> restrictedFilePaths() {
        return cursor.scalarListRequired("restrictedFilePaths", ScalarType.STRING);
    }
}
