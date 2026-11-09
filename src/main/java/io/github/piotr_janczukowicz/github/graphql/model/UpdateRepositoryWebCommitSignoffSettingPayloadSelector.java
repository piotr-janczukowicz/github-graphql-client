package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code UpdateRepositoryWebCommitSignoffSettingPayload}. */
public interface UpdateRepositoryWebCommitSignoffSettingPayloadSelector {

    @Nullable String clientMutationId();

    @Nullable String message();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);
}
