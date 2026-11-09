package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldRepositoryValue}. */
public interface ProjectV2ItemFieldRepositoryValueSelector {

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);
}
