package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;

/** Selection of the GraphQL type {@code MemberFeatureRequestNotification}. */
public interface MemberFeatureRequestNotificationSelector {

    String body();

    String id();

    String title();

    Instant updatedAt();
}
