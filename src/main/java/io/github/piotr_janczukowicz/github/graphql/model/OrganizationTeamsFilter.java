package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Organization.teams}; an argument left {@code null} is not sent. */
@RecordBuilder
public record OrganizationTeamsFilter(
        @Nullable Boolean ldapMapped,
        @Nullable TeamNotificationSetting notificationSetting,
        @Nullable TeamOrder orderBy,
        @Nullable TeamPrivacy privacy,
        @Nullable String query,
        @Nullable TeamRole role,
        @Nullable Boolean rootTeamsOnly,
        @Nullable List<String> userLogins) {

    public OrganizationTeamsFilter {
        userLogins = ListUtils.copyOrNull(userLogins);
    }
}
