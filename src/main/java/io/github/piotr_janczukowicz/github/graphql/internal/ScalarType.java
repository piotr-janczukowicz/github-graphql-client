package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.function.Function;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;

/**
 * A GraphQL leaf type the generated selectors read: the placeholder the recording pass returns and how the mapping pass
 * reads a value from the response.
 *
 * @param <T> Java type of the leaf
 */
final class ScalarType<T> {

    /** {@code String} and {@code ID}, and the opaque custom scalars such as {@code URI}. */
    static final ScalarType<String> STRING = new ScalarType<>("String", "", JsonNode::asString);

    /** {@code Int}. */
    static final ScalarType<Integer> INT = new ScalarType<>("Integer", 0, JsonNode::asInt);

    /** {@code Boolean}. */
    static final ScalarType<Boolean> BOOLEAN = new ScalarType<>("Boolean", false, JsonNode::asBoolean);

    /** {@code Float}. */
    static final ScalarType<Double> FLOAT = new ScalarType<>("Double", 0.0, JsonNode::asDouble);

    /** {@code DateTime} and {@code PreciseDateTime}. */
    static final ScalarType<Instant> INSTANT =
            new ScalarType<>("Instant", Instant.EPOCH, node -> Instant.parse(node.asString()));

    /** {@code Date}. */
    static final ScalarType<LocalDate> LOCAL_DATE =
            new ScalarType<>("LocalDate", LocalDate.EPOCH, node -> LocalDate.parse(node.asString()));

    /** {@code BigInt}, which GitHub sends as a string. */
    static final ScalarType<BigInteger> BIG_INTEGER =
            new ScalarType<>("BigInteger", BigInteger.ZERO, node -> new BigInteger(node.asString()));

    /** {@code GitTimestamp}, an ISO-8601 date with its own offset. */
    static final ScalarType<OffsetDateTime> OFFSET_DATE_TIME = new ScalarType<>(
            "OffsetDateTime", Instant.EPOCH.atOffset(ZoneOffset.UTC), node -> OffsetDateTime.parse(node.asString()));

    /** {@code CustomPropertyValue}, a string or an array of strings. */
    static final ScalarType<CustomPropertyValue> CUSTOM_PROPERTY_VALUE = new ScalarType<>(
            "CustomPropertyValue", CustomPropertyValue.ofText(""), ScalarType::readCustomPropertyValue);

    private final String label;
    private final T placeholder;
    private final Function<JsonNode, T> reader;

    private ScalarType(final String label, final T placeholder, final Function<JsonNode, T> reader) {
        this.label = label;
        this.placeholder = placeholder;
        this.reader = reader;
    }

    static <E extends Enum<E>> ScalarType<E> enumeration(final Function<String, E> fromWire, final E placeholder) {
        return new ScalarType<>(
                placeholder.getDeclaringClass().getSimpleName(), placeholder, node -> fromWire.apply(node.asString()));
    }

    T placeholder() {
        return placeholder;
    }

    T read(final JsonNode node) {
        try {
            return reader.apply(node);
        } catch (final DateTimeException | IllegalArgumentException | JacksonException failure) {
            final String text = node.isValueNode() ? node.asString() : node.toString();
            throw new IllegalArgumentException("invalid " + label + " value: " + text, failure);
        }
    }

    private static CustomPropertyValue readCustomPropertyValue(final JsonNode node) {
        if (node.isString()) {
            return CustomPropertyValue.ofText(node.asString());
        }
        if (!node.isArray() || node.valueStream().anyMatch(element -> !element.isString())) {
            throw new IllegalArgumentException("not a string or an array of strings");
        }
        return CustomPropertyValue.ofOptions(
                node.valueStream().map(JsonNode::asString).toList());
    }
}
