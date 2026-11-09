package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code FileChanges}; a field left {@code null} is not sent. */
@RecordBuilder
public record FileChanges(
        @Nullable List<FileAddition> additions, @Nullable List<FileDeletion> deletions) {

    public FileChanges {
        additions = ListUtils.copyOrNull(additions);
        deletions = ListUtils.copyOrNull(deletions);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.additions != null) {
            variable.put(
                    "additions",
                    this.additions.stream().map(FileAddition::toVariable).toList());
        }
        if (this.deletions != null) {
            variable.put(
                    "deletions",
                    this.deletions.stream().map(FileDeletion::toVariable).toList());
        }
        return Collections.unmodifiableMap(variable);
    }
}
