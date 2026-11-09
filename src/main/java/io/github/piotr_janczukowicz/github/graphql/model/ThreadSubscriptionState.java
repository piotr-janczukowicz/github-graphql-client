package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.util.EnumUtils;

/**
 * The GraphQL enum {@code ThreadSubscriptionState}. {@link #UNRECOGNIZED} stands for a value GitHub added after this
 * version.
 */
public enum ThreadSubscriptionState {
    DISABLED,
    IGNORING_LIST,
    IGNORING_THREAD,
    NONE,
    SUBSCRIBED_TO_LIST,
    SUBSCRIBED_TO_THREAD,
    SUBSCRIBED_TO_THREAD_EVENTS,
    SUBSCRIBED_TO_THREAD_TYPE,
    UNAVAILABLE,
    UNRECOGNIZED;

    private static final EnumUtils.WireIndex<ThreadSubscriptionState> WIRE_INDEX =
            EnumUtils.index(ThreadSubscriptionState.class, ThreadSubscriptionState::name);

    /**
     * Returns the constant for a value GitHub sent.
     *
     * @param value the GraphQL value name
     * @return the constant, or {@link #UNRECOGNIZED} when this version does not know the value
     */
    public static ThreadSubscriptionState fromWire(final String value) {
        requireNonNull(value, "value");
        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
