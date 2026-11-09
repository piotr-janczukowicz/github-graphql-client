package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Repository.rulesets}; an argument left {@code null} is not sent. */
@RecordBuilder
public record RepositoryRulesetsFilter(
        @Nullable Boolean includeParents, @Nullable List<RepositoryRulesetTarget> targets) {

    public RepositoryRulesetsFilter {
        targets = ListUtils.copyOrNull(targets);
    }
}
