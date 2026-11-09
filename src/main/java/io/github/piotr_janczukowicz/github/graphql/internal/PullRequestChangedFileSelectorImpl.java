package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.FileViewedState;
import io.github.piotr_janczukowicz.github.graphql.model.PatchStatus;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestChangedFileSelector;

/** Reads and records the fields of {@code PullRequestChangedFile}; used by the generated selection code only. */
final class PullRequestChangedFileSelectorImpl implements PullRequestChangedFileSelector {

    private final Cursor cursor;

    PullRequestChangedFileSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public int additions() {
        return cursor.getRequired("additions", ScalarType.INT);
    }

    @Override
    public PatchStatus changeType() {
        return cursor.getRequired("changeType", ScalarType.enumeration(PatchStatus::fromWire, PatchStatus.ADDED));
    }

    @Override
    public int deletions() {
        return cursor.getRequired("deletions", ScalarType.INT);
    }

    @Override
    public String path() {
        return cursor.getRequired("path", ScalarType.STRING);
    }

    @Override
    public FileViewedState viewerViewedState() {
        return cursor.getRequired(
                "viewerViewedState", ScalarType.enumeration(FileViewedState::fromWire, FileViewedState.DISMISSED));
    }
}
