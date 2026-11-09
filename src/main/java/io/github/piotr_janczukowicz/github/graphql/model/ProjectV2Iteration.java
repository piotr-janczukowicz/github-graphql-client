package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code ProjectV2Iteration}; a field left {@code null} is not sent. */
@RecordBuilder
public record ProjectV2Iteration(Integer duration, @Nullable String id, LocalDate startDate, String title) {

    public ProjectV2Iteration {
        requireNonNull(duration, "duration");
        requireNonNull(startDate, "startDate");
        requireNonNull(title, "title");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("duration", this.duration);
        if (this.id != null) {
            variable.put("id", this.id);
        }
        variable.put("startDate", this.startDate.toString());
        variable.put("title", this.title);
        return Collections.unmodifiableMap(variable);
    }
}
