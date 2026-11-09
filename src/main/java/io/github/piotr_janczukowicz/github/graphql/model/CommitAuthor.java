package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CommitAuthor}; a field left {@code null} is not sent. */
@RecordBuilder
public record CommitAuthor(
        @Nullable List<String> emails, @Nullable String id) {

    public CommitAuthor {
        emails = ListUtils.copyOrNull(emails);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.emails != null) {
            variable.put("emails", this.emails);
        }
        if (this.id != null) {
            variable.put("id", this.id);
        }
        return Collections.unmodifiableMap(variable);
    }
}
