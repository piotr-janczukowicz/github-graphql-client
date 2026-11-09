package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.FileExtensionRestrictionParametersSelector;
import java.util.List;

/**
 * Reads and records the fields of {@code FileExtensionRestrictionParameters}; used by the generated selection code
 * only.
 */
final class FileExtensionRestrictionParametersSelectorImpl implements FileExtensionRestrictionParametersSelector {

    private final Cursor cursor;

    FileExtensionRestrictionParametersSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public List<String> restrictedFileExtensions() {
        return cursor.scalarListRequired("restrictedFileExtensions", ScalarType.STRING);
    }
}
