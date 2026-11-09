package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleConditionsSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetBypassActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetRulesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetRulesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetTarget;
import io.github.piotr_janczukowicz.github.graphql.model.RuleEnforcement;
import io.github.piotr_janczukowicz.github.graphql.model.RuleSourceSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryRuleset}; used by the generated selection code only. */
final class RepositoryRulesetSelectorImpl implements RepositoryRulesetSelector {

    private final Cursor cursor;

    RepositoryRulesetSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> bypassActors(
            final Paging paging, final Function<RepositoryRulesetBypassActorSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.page(
                "bypassActors",
                child -> selection.apply(new RepositoryRulesetBypassActorSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public <R> R conditions(final Function<RepositoryRuleConditionsSelector, R> selection) {
        return cursor.objectRequired(
                "conditions", child -> selection.apply(new RepositoryRuleConditionsSelectorImpl(child)));
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public RuleEnforcement enforcement() {
        return cursor.getRequired(
                "enforcement", ScalarType.enumeration(RuleEnforcement::fromWire, RuleEnforcement.ACTIVE));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public <R> Page<R> rules(
            final Paging paging,
            final RepositoryRulesetRulesFilter arguments,
            final Function<RepositoryRuleSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.page(
                "rules",
                child -> selection.apply(new RepositoryRuleSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()),
                Argument.of("type", "RepositoryRuleType", arguments.type()));
    }

    @Override
    public <R> Page<R> rules(final Paging paging, final Function<RepositoryRuleSelector, R> selection) {
        return rules(paging, RepositoryRulesetRulesFilterBuilder.builder().build(), selection);
    }

    @Override
    public <R> R source(final Function<RuleSourceSelector, R> selection) {
        return cursor.objectRequired("source", child -> selection.apply(new RuleSourceSelectorImpl(child)));
    }

    @Override
    public @Nullable RepositoryRulesetTarget target() {
        return cursor.get(
                "target", ScalarType.enumeration(RepositoryRulesetTarget::fromWire, RepositoryRulesetTarget.BRANCH));
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }
}
