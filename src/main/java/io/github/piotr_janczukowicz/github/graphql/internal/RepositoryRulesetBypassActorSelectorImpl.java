package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.BypassActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetBypassActorBypassMode;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetBypassActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import java.math.BigInteger;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RepositoryRulesetBypassActor}; used by the generated selection code only. */
final class RepositoryRulesetBypassActorSelectorImpl implements RepositoryRulesetBypassActorSelector {

    private final Cursor cursor;

    RepositoryRulesetBypassActorSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> @Nullable R actor(final Function<BypassActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new BypassActorSelectorImpl(child)));
    }

    @Override
    public @Nullable RepositoryRulesetBypassActorBypassMode bypassMode() {
        return cursor.get(
                "bypassMode",
                ScalarType.enumeration(
                        RepositoryRulesetBypassActorBypassMode::fromWire,
                        RepositoryRulesetBypassActorBypassMode.ALWAYS));
    }

    @Override
    public boolean deployKey() {
        return cursor.getRequired("deployKey", ScalarType.BOOLEAN);
    }

    @Override
    public boolean enterpriseOwner() {
        return cursor.getRequired("enterpriseOwner", ScalarType.BOOLEAN);
    }

    @Override
    public boolean enterpriseRole() {
        return cursor.getRequired("enterpriseRole", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable BigInteger enterpriseRoleDatabaseId() {
        return cursor.get("enterpriseRoleDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean organizationAdmin() {
        return cursor.getRequired("organizationAdmin", ScalarType.BOOLEAN);
    }

    @Override
    public @Nullable Integer repositoryRoleDatabaseId() {
        return cursor.get("repositoryRoleDatabaseId", ScalarType.INT);
    }

    @Override
    public @Nullable String repositoryRoleName() {
        return cursor.get("repositoryRoleName", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R repositoryRuleset(final Function<RepositoryRulesetSelector, R> selection) {
        return cursor.object("repositoryRuleset", child -> selection.apply(new RepositoryRulesetSelectorImpl(child)));
    }
}
