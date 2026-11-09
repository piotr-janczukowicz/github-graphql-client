package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryRulesetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateRepositoryRulesetPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateRepositoryRulesetPayload}; used by the generated selection code only.
 */
final class UpdateRepositoryRulesetPayloadSelectorImpl implements UpdateRepositoryRulesetPayloadSelector {

    private final Cursor cursor;

    UpdateRepositoryRulesetPayloadSelectorImpl(final Cursor cursor) {
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
