package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code PullRequest.reviews}; an argument left {@code null} is not sent. */
@RecordBuilder
public record PullRequestReviewsFilter(
        @Nullable String author, @Nullable List<PullRequestReviewState> states) {

    public PullRequestReviewsFilter {
        states = ListUtils.copyOrNull(states);
    }
}
