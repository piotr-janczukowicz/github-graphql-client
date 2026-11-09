package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.CreatedPullRequestReviewContributionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;

/**
 * Reads and records the fields of {@code CreatedPullRequestReviewContribution}; used by the generated selection code
 * only.
 */
final class CreatedPullRequestReviewContributionSelectorImpl implements CreatedPullRequestReviewContributionSelector {

    private final Cursor cursor;

    CreatedPullRequestReviewContributionSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean isRestricted() {
        return cursor.getRequired("isRestricted", ScalarType.BOOLEAN);
    }

    @Override
    public Instant occurredAt() {
        return cursor.getRequired("occurredAt", ScalarType.INSTANT);
    }

    @Override
    public <R> R pullRequest(final Function<PullRequestSelector, R> selection) {
        return cursor.objectRequired("pullRequest", child -> selection.apply(new PullRequestSelectorImpl(child)));
    }

    @Override
    public <R> R pullRequestReview(final Function<PullRequestReviewSelector, R> selection) {
        return cursor.objectRequired(
                "pullRequestReview", child -> selection.apply(new PullRequestReviewSelectorImpl(child)));
    }

    @Override
    public <R> R repository(final Function<RepositorySelector, R> selection) {
        return cursor.objectRequired("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public String resourcePath() {
        return cursor.getRequired("resourcePath", ScalarType.STRING);
    }

    @Override
    public String url() {
        return cursor.getRequired("url", ScalarType.STRING);
    }

    @Override
    public <R> R user(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
