package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CvssSeverities}. */
public interface CvssSeveritiesSelector {

    <R> @Nullable R cvssV3(Function<CVSSSelector, R> selection);

    <R> @Nullable R cvssV4(Function<CVSSSelector, R> selection);
}
