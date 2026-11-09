package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import io.github.piotr_janczukowicz.json.OptionalNull;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code CustomPropertyValueInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record CustomPropertyValueInput(
        String propertyName, @Nullable OptionalNull<CustomPropertyValue> value) {

    public CustomPropertyValueInput {
        requireNonNull(propertyName, "propertyName");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, @Nullable Object> toVariable() {
        final Map<String, @Nullable Object> variable = new LinkedHashMap<>();
        variable.put("propertyName", this.propertyName);
        if (this.value != null) {
            variable.put("value", this.value.value() == null ? null : asVariable(this.value.value()));
        }
        return Collections.unmodifiableMap(variable);
    }

    private static Object asVariable(final CustomPropertyValue value) {
        final String text = value.text();
        return text != null ? text : requireNonNull(value.options(), "options");
    }
}
