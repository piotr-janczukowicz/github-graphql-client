package io.github.piotr_janczukowicz.github.graphql.model;

/** The GraphQL enum {@code TopicSuggestionDeclineReason}; it is only sent to GitHub, never read. */
public enum TopicSuggestionDeclineReason {
    /** @deprecated Suggested topics are no longer supported Removal on 2024-04-01 UTC. */
    @Deprecated(forRemoval = true)
    NOT_RELEVANT,
    /** @deprecated Suggested topics are no longer supported Removal on 2024-04-01 UTC. */
    @Deprecated(forRemoval = true)
    PERSONAL_PREFERENCE,
    /** @deprecated Suggested topics are no longer supported Removal on 2024-04-01 UTC. */
    @Deprecated(forRemoval = true)
    TOO_GENERAL,
    /** @deprecated Suggested topics are no longer supported Removal on 2024-04-01 UTC. */
    @Deprecated(forRemoval = true)
    TOO_SPECIFIC
}
