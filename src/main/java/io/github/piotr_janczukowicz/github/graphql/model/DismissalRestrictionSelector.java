package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code DismissalRestriction}. */
public interface DismissalRestrictionSelector {

    List<String> allowedActors();

    boolean enabled();
}
