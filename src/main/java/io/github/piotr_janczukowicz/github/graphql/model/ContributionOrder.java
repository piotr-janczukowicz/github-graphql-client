package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** The GraphQL input object {@code ContributionOrder}; a field left {@code null} is not sent. */
@RecordBuilder
public record ContributionOrder(OrderDirection direction) {

    public ContributionOrder {
        requireNonNull(direction, "direction");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("direction", this.direction.wireValue());
        return Collections.unmodifiableMap(variable);
    }
}
