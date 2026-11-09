package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code ProjectV2SingleSelectField.options}; an argument left {@code null} is not sent. */
@RecordBuilder
public record ProjectV2SingleSelectFieldOptionsFilter(
        @Nullable List<String> names) {

    public ProjectV2SingleSelectFieldOptionsFilter {
        names = ListUtils.copyOrNull(names);
    }
}
