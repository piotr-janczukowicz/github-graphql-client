package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreateRepositoryRulesetPayloadSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code CreateRepositoryRulesetPayload}; used by the generated selection code only.
 */
final class CreateRepositoryRulesetPayloadSelectorImpl implements CreateRepositoryRulesetPayloadSelector {

    private final Cursor cursor;

    CreateRepositoryRulesetPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R ruleset(final Function<RepositoryRulesetSelector, R> selection) {
        return cursor.object("ruleset", child -> selection.apply(new RepositoryRulesetSelectorImpl(child)));
    }
}
