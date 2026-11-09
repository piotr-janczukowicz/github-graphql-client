package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code MigrationSource}. */
public interface MigrationSourceSelector {

    String id();

    String name();

    MigrationSourceType type();

    String url();
}
