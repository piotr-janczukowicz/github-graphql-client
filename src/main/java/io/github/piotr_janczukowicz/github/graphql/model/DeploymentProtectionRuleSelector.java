package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code DeploymentProtectionRule}. */
public interface DeploymentProtectionRuleSelector {

    @Nullable Integer databaseId();

    @Nullable Boolean preventSelfReview();

    <R> Page<R> reviewers(Paging paging, Function<DeploymentReviewerSelector, R> selection);

    int timeout();

    DeploymentProtectionRuleType type();
}
