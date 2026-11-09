package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.Page;
import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * What the generated selector code reads fields through. In the recording pass a cursor notes which fields are read and
 * returns placeholders; in the mapping pass it reads the response. For generated code only.
 */
sealed interface Cursor permits RecordingCursor, MappingCursor {

    /**
     * Reads a nullable scalar field.
     *
     * @param field field name
     * @param type scalar type
     * @param arguments field arguments
     * @param <T> Java type of the scalar
     * @return the value, or {@code null} when the response has {@code null}
     */
    <T> @Nullable T get(String field, ScalarType<T> type, Argument... arguments);

    /**
     * Reads a non-null scalar field.
     *
     * @param field field name
     * @param type scalar type
     * @param arguments field arguments
     * @param <T> Java type of the scalar
     * @return the value
     */
    <T> T getRequired(String field, ScalarType<T> type, Argument... arguments);

    /**
     * Reads an object field and maps its selection.
     *
     * @param field field name
     * @param selection reads the fields of the object and builds the result
     * @param arguments field arguments
     * @param <R> result type of the selection
     * @return the result, or {@code null} when the response has {@code null} for the object
     */
    <R> @Nullable R object(String field, Function<Cursor, R> selection, Argument... arguments);

    /**
     * Reads a non-null object field and maps its selection.
     *
     * @param field field name
     * @param selection reads the fields of the object and builds the result
     * @param arguments field arguments
     * @param <R> result type of the selection
     * @return the result
     */
    <R> R objectRequired(String field, Function<Cursor, R> selection, Argument... arguments);

    /**
     * Reads the fragment {@code ... on Type} of an interface or union selection. The runtime selects {@code __typename}
     * itself.
     *
     * @param typeName the GraphQL name of the concrete type
     * @param selection reads the fields of the fragment and builds the result
     * @param <R> result type of the selection
     * @return the result, or {@code null} when the object in the response is another type
     */
    <R> @Nullable R branch(String typeName, Function<Cursor, R> selection);

    /**
     * Reads a nullable list of objects and maps the selection of each element. Elements that are {@code null} in the
     * response are skipped.
     *
     * @param field field name
     * @param selection reads the fields of one element and builds the result
     * @param arguments field arguments
     * @param <R> result type of the selection
     * @return the results, an empty list when the response has {@code null} for the list
     */
    <R> List<R> list(String field, Function<Cursor, R> selection, Argument... arguments);

    /**
     * Reads a non-null list of objects and maps the selection of each element. Elements that are {@code null} in the
     * response are skipped.
     *
     * @param field field name
     * @param selection reads the fields of one element and builds the result
     * @param arguments field arguments
     * @param <R> result type of the selection
     * @return the results
     */
    <R> List<R> listRequired(String field, Function<Cursor, R> selection, Argument... arguments);

    /**
     * Reads a nullable list of scalars or enums. Elements that are {@code null} in the response are skipped.
     *
     * @param field field name
     * @param type the leaf type of one element
     * @param arguments field arguments
     * @param <T> Java type of one element
     * @return the values, an empty list when the response has {@code null} for the list
     */
    <T> List<T> scalarList(String field, ScalarType<T> type, Argument... arguments);

    /**
     * Reads a non-null list of scalars or enums. Elements that are {@code null} in the response are skipped.
     *
     * @param field field name
     * @param type the leaf type of one element
     * @param arguments field arguments
     * @param <T> Java type of one element
     * @return the values
     */
    <T> List<T> scalarListRequired(String field, ScalarType<T> type, Argument... arguments);

    /**
     * Reads a nullable connection as a page. The runtime selects {@code nodes} and {@code pageInfo { hasNextPage
     * endCursor }} itself.
     *
     * @param field connection field name
     * @param itemSelection reads the fields of one item and builds the result
     * @param arguments field arguments
     * @param <R> result type of the selection
     * @return the page, an empty page without next page when the response has {@code null} for the connection
     */
    <R> Page<R> page(String field, Function<Cursor, R> itemSelection, Argument... arguments);

    /**
     * Reads a non-null connection as a page. The runtime selects {@code nodes} and {@code pageInfo { hasNextPage
     * endCursor }} itself.
     *
     * @param field connection field name
     * @param itemSelection reads the fields of one item and builds the result
     * @param arguments field arguments
     * @param <R> result type of the selection
     * @return the page
     */
    <R> Page<R> pageRequired(String field, Function<Cursor, R> itemSelection, Argument... arguments);
}
