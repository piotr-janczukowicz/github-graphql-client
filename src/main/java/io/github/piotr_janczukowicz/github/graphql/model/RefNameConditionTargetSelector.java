package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code RefNameConditionTarget}. */
public interface RefNameConditionTargetSelector {

    List<String> exclude();

    List<String> include();
}
