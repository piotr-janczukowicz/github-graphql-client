package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Team.childTeams}; an argument left {@code null} is not sent. */
@RecordBuilder
public record TeamChildTeamsFilter(
        @Nullable Boolean immediateOnly,
        @Nullable TeamOrder orderBy,
        @Nullable List<String> userLogins) {

    public TeamChildTeamsFilter {
        userLogins = ListUtils.copyOrNull(userLogins);
    }
}
