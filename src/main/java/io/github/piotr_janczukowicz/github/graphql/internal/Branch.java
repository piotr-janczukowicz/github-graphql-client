package io.github.piotr_janczukowicz.github.graphql.internal;

import java.util.function.Function;

/**
 * One concrete type that an interface or union selection can branch to.
 *
 * @param typeName the GraphQL name of the type
 * @param factory builds the generated selector of the type over a cursor
 */
record Branch(String typeName, Function<Cursor, Object> factory) {}
