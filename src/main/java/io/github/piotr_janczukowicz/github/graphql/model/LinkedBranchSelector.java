package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code LinkedBranch}. */
public interface LinkedBranchSelector {

    String id();

    <R> @Nullable R ref(Function<RefSelector, R> selection);
}
