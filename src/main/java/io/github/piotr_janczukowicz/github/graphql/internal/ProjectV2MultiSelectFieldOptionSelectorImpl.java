package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2MultiSelectFieldOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2SingleSelectFieldOptionColor;

/**
 * Reads and records the fields of {@code ProjectV2MultiSelectFieldOption}; used by the generated selection code only.
 */
final class ProjectV2MultiSelectFieldOptionSelectorImpl implements ProjectV2MultiSelectFieldOptionSelector {

    private final Cursor cursor;

    ProjectV2MultiSelectFieldOptionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public ProjectV2SingleSelectFieldOptionColor color() {
        return cursor.getRequired(
                "color",
                ScalarType.enumeration(
                        ProjectV2SingleSelectFieldOptionColor::fromWire, ProjectV2SingleSelectFieldOptionColor.BLUE));
    }

    @Override
    public String description() {
        return cursor.getRequired("description", ScalarType.STRING);
    }

    @Override
    public String descriptionHTML() {
        return cursor.getRequired("descriptionHTML", ScalarType.STRING);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public String nameHTML() {
        return cursor.getRequired("nameHTML", ScalarType.STRING);
    }
}
