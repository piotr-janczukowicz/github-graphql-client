package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code SecurityAdvisoryPackage}. */
public interface SecurityAdvisoryPackageSelector {

    SecurityAdvisoryEcosystem ecosystem();

    String name();
}
