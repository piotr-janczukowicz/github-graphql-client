package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DeploymentReviewState;
import io.github.piotr_janczukowicz.github.graphql.model.EnvironmentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code DeploymentReview}; used by the generated selection code only. */
final class DeploymentReviewSelectorImpl implements DeploymentReviewSelector {

    private final Cursor cursor;

    DeploymentReviewSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String comment() {
        return cursor.getRequired("comment", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer databaseId() {
        return cursor.get("databaseId", ScalarType.INT);
    }

    @Override
    public <R> Page<R> environments(final Paging paging, final Function<EnvironmentSelector, R> selection) {
        requireNonNull(paging, "paging");
        return cursor.pageRequired(
                "environments",
                child -> selection.apply(new EnvironmentSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", "String", paging.after()));
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public DeploymentReviewState state() {
        return cursor.getRequired(
                "state", ScalarType.enumeration(DeploymentReviewState::fromWire, DeploymentReviewState.APPROVED));
    }

    @Override
    public <R> R user(final Function<UserSelector, R> selection) {
        return cursor.objectRequired("user", child -> selection.apply(new UserSelectorImpl(child)));
    }
}
