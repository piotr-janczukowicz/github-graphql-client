package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code RefUpdate}; a field left {@code null} is not sent. */
@RecordBuilder
public record RefUpdate(
        String afterOid,
        @Nullable String beforeOid,
        @Nullable Boolean force,
        String name) {

    public RefUpdate {
        requireNonNull(afterOid, "afterOid");
        requireNonNull(name, "name");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("afterOid", this.afterOid);
        if (this.beforeOid != null) {
            variable.put("beforeOid", this.beforeOid);
        }
        if (this.force != null) {
            variable.put("force", this.force);
        }
        variable.put("name", this.name);
        return Collections.unmodifiableMap(variable);
    }
}
