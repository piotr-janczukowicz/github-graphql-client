package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNoNullElements;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;
import org.jspecify.annotations.Nullable;

/**
 * One argument of a field in a GraphQL query. A {@code null} value means the argument is left out of the query.
 *
 * @param name argument name, as in the schema
 * @param graphqlType GraphQL type of the argument, such as {@code String!}
 * @param value the value sent as a query variable in its wire form, or {@code null} to omit the argument
 */
record Argument(String name, String graphqlType, @Nullable Object value) {

    private static final String UNRECOGNIZED = "UNRECOGNIZED";

    Argument {
        requireNonNull(name, "name");
        requireNonNull(graphqlType, "graphqlType");
    }

    /**
     * Creates an argument and converts its value to the wire form: an enum becomes its name, dates and big integers
     * become text, and a collection is converted element by element.
     *
     * @param name argument name, as in the schema
     * @param graphqlType GraphQL type of the argument
     * @param value the value, or {@code null} to omit the argument
     * @return the argument
     * @throws IllegalArgumentException when the value is {@code UNRECOGNIZED}, or a collection has a {@code null}
     *     element or an {@code UNRECOGNIZED} element
     */
    static Argument of(final String name, final String graphqlType, final @Nullable Object value) {
        return new Argument(name, graphqlType, wire(name, value));
    }

    private static @Nullable Object wire(final String name, final @Nullable Object value) {
        if (value instanceof Collection<?> items) {
            return requireNoNullElements(items, name).stream()
                    .map(item -> single(name, item))
                    .toList();
        }
        return value == null ? null : single(name, value);
    }

    private static Object single(final String name, final Object value) {
        if (value instanceof Enum<?> constant) {
            return enumName(name, constant);
        }
        if (value instanceof CustomPropertyValue property) {
            final String text = property.text();
            return text != null ? text : requireNonNull(property.options(), "options");
        }
        return isText(value) ? value.toString() : value;
    }

    private static String enumName(final String name, final Enum<?> constant) {
        if (UNRECOGNIZED.equals(constant.name())) {
            throw new IllegalArgumentException(name + " must not be " + UNRECOGNIZED);
        }
        return constant.name();
    }

    private static boolean isText(final Object value) {
        return value instanceof Instant
                || value instanceof LocalDate
                || value instanceof OffsetDateTime
                || value instanceof BigInteger;
    }
}
