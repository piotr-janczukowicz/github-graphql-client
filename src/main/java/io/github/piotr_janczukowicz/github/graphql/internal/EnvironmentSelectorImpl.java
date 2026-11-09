package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code Environment}; used by the generated selection code only. */
final class EnvironmentSelectorImpl implements EnvironmentSelector {

    private final Cursor cursor;

    EnvironmentSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public @Nullable Boolean isPinned() {
        return cursor.get("isPinned", ScalarType.BOOLEAN);
    }

    @Override
    public <R> @Nullable R latestCompletedDeployment(final Function<DeploymentSelector, R> selection) {
        return cursor.object("latestCompletedDeployment", child -> selection.apply(new DeploymentSelectorImpl(child)));
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer pinnedPosition() {
        return cursor.get("pinnedPosition", ScalarType.INT);
    }

    @Override
    public <R> Page<R> protectionRules(
            final Paging paging, final Function<DeploymentProtectionRuleSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "protectionRules",
                child -> selection.apply(new DeploymentProtectionRuleSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }
}
