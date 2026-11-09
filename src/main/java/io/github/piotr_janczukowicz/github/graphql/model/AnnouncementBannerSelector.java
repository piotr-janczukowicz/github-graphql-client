package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code AnnouncementBanner}. */
public interface AnnouncementBannerSelector {

    Instant createdAt();

    @Nullable Instant expiresAt();

    boolean isUserDismissible();

    @Nullable String message();
}
