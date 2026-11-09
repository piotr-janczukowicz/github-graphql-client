package io.github.piotr_janczukowicz.github.graphql;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * The value of a repository custom property, which GitHub sends and expects as a string (text and single-select
 * properties) or as a list of strings (multi-select properties). The schema does not say which one a property wants, so
 * the value keeps the shape you give it or GitHub sent.
 */
public final class CustomPropertyValue {

    private final @Nullable String text;
    private final @Nullable List<String> options;

    private CustomPropertyValue(final @Nullable String text, final @Nullable List<String> options) {
        this.text = text;
        this.options = options;
    }

    /**
     * A value for a text or single-select property.
     *
     * @param text the value
     * @return the property value
     * @throws NullPointerException if {@code text} is {@code null}
     */
    public static CustomPropertyValue ofText(final String text) {
        return new CustomPropertyValue(requireNonNull(text, "text"), null);
    }

    /**
     * A value for a multi-select property.
     *
     * @param options the selected values; the list is copied
     * @return the property value
     * @throws NullPointerException if {@code options} is {@code null} or has a {@code null} element
     */
    public static CustomPropertyValue ofOptions(final List<String> options) {
        return new CustomPropertyValue(null, ListUtils.copyOf(options, "options"));
    }

    /**
     * Returns the string value.
     *
     * @return the text, or {@code null} when the value is a list
     */
    public @Nullable String text() {
        return text;
    }

    /**
     * Returns the list value.
     *
     * @return the options, or {@code null} when the value is a string
     */
    public @Nullable List<String> options() {
        return options;
    }

    @Override
    public boolean equals(final @Nullable Object other) {
        return this == other
                || other instanceof final CustomPropertyValue value
                        && Objects.equals(text, value.text)
                        && Objects.equals(options, value.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, options);
    }

    @Override
    public String toString() {
        return "CustomPropertyValue[" + (text != null ? text : options) + "]";
    }
}
