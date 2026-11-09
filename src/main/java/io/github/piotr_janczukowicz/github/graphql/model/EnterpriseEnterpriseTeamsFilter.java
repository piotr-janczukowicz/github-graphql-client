package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Enterprise.enterpriseTeams}; an argument left {@code null} is not sent. */
@RecordBuilder
public record EnterpriseEnterpriseTeamsFilter(
        @Nullable EnterpriseTeamOrder orderBy,
        @Nullable String query,
        @Nullable List<String> userLogins) {

    public EnterpriseEnterpriseTeamsFilter {
        userLogins = ListUtils.copyOrNull(userLogins);
    }
}
