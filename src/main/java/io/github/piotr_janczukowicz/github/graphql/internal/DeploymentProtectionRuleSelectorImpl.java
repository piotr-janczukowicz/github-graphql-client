package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentProtectionRuleSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentProtectionRuleType;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewerSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeploymentProtectionRule}; used by the generated selection code only. */
final class DeploymentProtectionRuleSelectorImpl implements DeploymentProtectionRuleSelector {

    private final Cursor cursor;

    DeploymentProtectionRuleSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public @Nullable Boolean preventSelfReview() {
        return cursor.get("preventSelfReview", ScalarType.BOOLEAN);
    }

    @Override
    public <R> Page<R> reviewers(final Paging paging, final Function<DeploymentReviewerSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "reviewers",
                child -> selection.apply(new DeploymentReviewerSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public int timeout() {
        return cursor.getRequired("timeout", ScalarType.INT);
    }

    @Override
    public DeploymentProtectionRuleType type() {
        return cursor.getRequired(
                "type",
                ScalarType.enumeration(
                        DeploymentProtectionRuleType::fromWire, DeploymentProtectionRuleType.BRANCH_POLICY));
    }
}
