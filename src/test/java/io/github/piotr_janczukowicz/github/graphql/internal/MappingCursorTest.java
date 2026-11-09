package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.DateTimeException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MappingCursorTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();
    private static final Function<Cursor, String> ID = child -> child.getRequired("id", ScalarType.STRING);

    private static FieldSelection recordedList() {
        final FieldSelection root = FieldSelection.root();
        new RecordingCursor(root).listRequired("items", ID);
        return root;
    }

    @Test
    void listRequired_shouldFail_whenTheListIsNullInTheResponse() {
        final MappingCursor cursor = new MappingCursor(MAPPER.readTree("{\"items\":null}"), recordedList());

        final Throwable thrown = catchThrowable(() -> cursor.listRequired("items", ID));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("query.items");
    }

    @Test
    void listRequired_shouldReturnTheItems_whenTheListIsPresent() {
        final JsonNode data = MAPPER.readTree("{\"items\":[{\"id\":\"a\"},{\"id\":\"b\"}]}");
        final MappingCursor cursor = new MappingCursor(data, recordedList());

        final List<String> items = cursor.listRequired("items", ID);

        assertThat(items).containsExactly("a", "b");
    }

    @Test
    void list_shouldReturnAnEmptyList_whenTheFieldIsMissingInTheResponse() {
        final MappingCursor cursor = new MappingCursor(MAPPER.readTree("{}"), recordedList());

        final List<String> items = cursor.list("items", ID);

        assertThat(items).isEmpty();
    }

    private static MappingCursor pageCursor(final String json) {
        final FieldSelection root = FieldSelection.root();
        new RecordingCursor(root).pageRequired("items", ID);
        return new MappingCursor(MAPPER.readTree(json), root);
    }

    private static Stream<Arguments> incompletePages() {
        return Stream.of(
                Arguments.of("{\"items\":{\"nodes\":[{\"id\":\"a\"}]}}", "query.items.pageInfo"),
                Arguments.of("{\"items\":{\"nodes\":[],\"pageInfo\":null}}", "query.items.pageInfo"),
                Arguments.of(
                        "{\"items\":{\"nodes\":[],\"pageInfo\":{\"hasNextPage\":null,\"endCursor\":null}}}",
                        "query.items.pageInfo.hasNextPage"),
                Arguments.of(
                        "{\"items\":{\"nodes\":[],\"pageInfo\":{\"endCursor\":null}}}",
                        "query.items.pageInfo.hasNextPage"),
                Arguments.of("{}", "query.items"),
                Arguments.of("{\"items\":null}", "query.items"));
    }

    @ParameterizedTest
    @MethodSource("incompletePages")
    void pageRequired_shouldFail_whenThePageIsIncomplete(final String json, final String path) {
        final MappingCursor cursor = pageCursor(json);

        final Throwable thrown = catchThrowable(() -> cursor.pageRequired("items", ID));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining(path);
    }

    @Test
    void page_shouldReturnAnEmptyPage_whenTheConnectionIsMissing() {
        final MappingCursor cursor = pageCursor("{}");

        final Page<String> page = cursor.page("items", ID);

        assertThat(page).isEqualTo(new Page<>(List.of(), false, null));
    }

    @Test
    void page_shouldReturnAnEmptyPage_whenTheConnectionIsNull() {
        final MappingCursor cursor = pageCursor("{\"items\":null}");

        final Page<String> page = cursor.page("items", ID);

        assertThat(page).isEqualTo(new Page<>(List.of(), false, null));
    }

    @Test
    void page_shouldReturnTheItemsAndCursor_whenThePageInfoIsComplete() {
        final MappingCursor cursor = pageCursor("""
                {"items":{"nodes":[{"id":"a"}],"pageInfo":{"hasNextPage":true,"endCursor":"c1"}}}
                """);

        final Page<String> page = cursor.page("items", ID);

        assertThat(page).isEqualTo(new Page<>(List.of("a"), true, "c1"));
    }

    @Test
    void page_shouldHaveNoCursor_whenTheEndCursorIsMissing() {
        final MappingCursor cursor = pageCursor("""
                {"items":{"nodes":[{"id":"a"}],"pageInfo":{"hasNextPage":false}}}
                """);

        final Page<String> page = cursor.page("items", ID);

        assertThat(page).isEqualTo(new Page<>(List.of("a"), false, null));
    }

    @Test
    void page_shouldFail_whenTheItemSelectionReadsNoField() {
        final RecordingCursor cursor = new RecordingCursor(FieldSelection.root());

        final Throwable thrown = catchThrowable(() -> cursor.page("items", child -> "nothing"));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("selection reads no field");
    }

    private static MappingCursor scalarCursor(final ScalarType<?> type, final String json) {
        final FieldSelection root = FieldSelection.root();
        new RecordingCursor(root).get("value", type);
        return new MappingCursor(MAPPER.readTree(json), root);
    }

    @Test
    void get_shouldFailWithThePath_whenADateTimeIsInvalid() {
        final MappingCursor cursor = scalarCursor(ScalarType.INSTANT, "{\"value\":\"yesterday\"}");

        final Throwable thrown = catchThrowable(() -> cursor.get("value", ScalarType.INSTANT));

        assertThat(thrown)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("query.value")
                .hasMessageContaining("invalid Instant value: yesterday")
                .hasRootCauseInstanceOf(DateTimeException.class);
    }

    @Test
    void get_shouldFailWithThePath_whenAnIntFieldHoldsText() {
        final MappingCursor cursor = scalarCursor(ScalarType.INT, "{\"value\":\"abc\"}");

        final Throwable thrown = catchThrowable(() -> cursor.get("value", ScalarType.INT));

        assertThat(thrown)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("query.value")
                .hasMessageContaining("invalid Integer value");
    }

    @Test
    void get_shouldFailWithThePath_whenAStringFieldHoldsAnObject() {
        final MappingCursor cursor = scalarCursor(ScalarType.STRING, "{\"value\":{\"a\":1}}");

        final Throwable thrown = catchThrowable(() -> cursor.get("value", ScalarType.STRING));

        assertThat(thrown)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("query.value")
                .hasMessageContaining("invalid String value");
    }

    @Test
    void getRequired_shouldFailWithThePath_whenABigIntIsNotNumeric() {
        final MappingCursor cursor = scalarCursor(ScalarType.BIG_INTEGER, "{\"value\":\"many\"}");

        final Throwable thrown = catchThrowable(() -> cursor.getRequired("value", ScalarType.BIG_INTEGER));

        assertThat(thrown)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("query.value")
                .hasMessageContaining("invalid BigInteger value: many");
    }

    private static MappingCursor scalarListCursor(final ScalarType<?> type, final String json) {
        final FieldSelection root = FieldSelection.root();
        new RecordingCursor(root).scalarList("values", type);
        return new MappingCursor(MAPPER.readTree(json), root);
    }

    @Test
    void scalarList_shouldReturnTheValuesAndSkipNullElements_whenTheListHasNulls() {
        final MappingCursor cursor = scalarListCursor(ScalarType.STRING, "{\"values\":[\"a\",null,\"b\"]}");

        final List<String> values = cursor.scalarList("values", ScalarType.STRING);

        assertThat(values).containsExactly("a", "b");
    }

    @Test
    void scalarList_shouldReturnAnEmptyList_whenTheListIsNullOrMissing() {
        final MappingCursor nullList = scalarListCursor(ScalarType.STRING, "{\"values\":null}");
        final MappingCursor missing = scalarListCursor(ScalarType.STRING, "{}");

        assertSoftly(softly -> {
            softly.assertThat(nullList.scalarList("values", ScalarType.STRING)).isEmpty();
            softly.assertThat(missing.scalarList("values", ScalarType.STRING)).isEmpty();
        });
    }

    @Test
    void scalarListRequired_shouldFail_whenTheListIsNull() {
        final MappingCursor cursor = scalarListCursor(ScalarType.STRING, "{\"values\":null}");

        final Throwable thrown = catchThrowable(() -> cursor.scalarListRequired("values", ScalarType.STRING));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("query.values");
    }

    @Test
    void scalarListRequired_shouldReturnTheValues_whenTheListIsPresent() {
        final MappingCursor cursor = scalarListCursor(ScalarType.INT, "{\"values\":[1,2]}");

        final List<Integer> values = cursor.scalarListRequired("values", ScalarType.INT);

        assertThat(values).containsExactly(1, 2);
    }

    @Test
    void scalarList_shouldFail_whenTheValueIsNotAnArray() {
        final MappingCursor cursor = scalarListCursor(ScalarType.STRING, "{\"values\":\"a\"}");

        final Throwable thrown = catchThrowable(() -> cursor.scalarList("values", ScalarType.STRING));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("query.values is not a list");
    }

    @Test
    void scalarList_shouldFailWithThePath_whenAnElementIsInvalid() {
        final MappingCursor cursor = scalarListCursor(ScalarType.INSTANT, "{\"values\":[\"yesterday\"]}");

        final Throwable thrown = catchThrowable(() -> cursor.scalarList("values", ScalarType.INSTANT));

        assertThat(thrown)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("query.values")
                .hasMessageContaining("invalid Instant value: yesterday");
    }

    @Test
    void list_shouldFail_whenTheValueIsAnObject() {
        final MappingCursor cursor = new MappingCursor(MAPPER.readTree("{\"items\":{\"id\":\"a\"}}"), recordedList());

        final Throwable thrown = catchThrowable(() -> cursor.list("items", ID));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("query.items is not a list");
    }

    @Test
    void listRequired_shouldFail_whenTheValueIsAScalar() {
        final MappingCursor cursor = new MappingCursor(MAPPER.readTree("{\"items\":\"a\"}"), recordedList());

        final Throwable thrown = catchThrowable(() -> cursor.listRequired("items", ID));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("query.items is not a list");
    }

    @Test
    void list_shouldFail_whenTheElementSelectionReadsNoField() {
        final RecordingCursor cursor = new RecordingCursor(FieldSelection.root());

        final Throwable thrown = catchThrowable(() -> cursor.list("items", child -> "nothing"));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("selection reads no field");
    }

    private static FieldSelection recordedBranch() {
        final FieldSelection root = FieldSelection.root();
        new RecordingCursor(root).branch("User", child -> child.getRequired("login", ScalarType.STRING));
        return root;
    }

    @Test
    void branch_shouldReadTheFragment_whenTheTypenameMatches() {
        final JsonNode data = MAPPER.readTree("{\"__typename\":\"User\",\"login\":\"octo\"}");
        final MappingCursor cursor = new MappingCursor(data, recordedBranch());

        final String login = cursor.branch("User", child -> child.getRequired("login", ScalarType.STRING));

        assertThat(login).isEqualTo("octo");
    }

    @Test
    void branch_shouldReturnNull_whenTheTypenameIsAnotherType() {
        final JsonNode data = MAPPER.readTree("{\"__typename\":\"Bot\"}");
        final MappingCursor cursor = new MappingCursor(data, recordedBranch());

        final String login = cursor.branch("User", child -> child.getRequired("login", ScalarType.STRING));

        assertThat(login).isNull();
    }

    @Test
    void branch_shouldFail_whenTheBranchWasNotRecorded() {
        final JsonNode data = MAPPER.readTree("{\"__typename\":\"User\"}");
        final MappingCursor cursor = new MappingCursor(data, FieldSelection.root());

        final Throwable thrown = catchThrowable(() -> cursor.branch("User", child -> "x"));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("... on User");
    }

    @Test
    void branch_shouldReturnNull_whenTheTypenameIsMissingInTheResponse() {
        final MappingCursor cursor = new MappingCursor(MAPPER.readTree("{}"), recordedBranch());

        final String login = cursor.branch("User", child -> child.getRequired("login", ScalarType.STRING));

        assertThat(login).isNull();
    }
}
