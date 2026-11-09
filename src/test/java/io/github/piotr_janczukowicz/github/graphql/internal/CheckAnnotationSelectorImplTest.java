package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationLevel;
import io.github.piotr_janczukowicz.github.graphql.model.CheckAnnotationPositionSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class CheckAnnotationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"annotationLevel\":\"FAILURE\"" + "," + "\"blobUrl\":\"x\"" + ","
            + "\"databaseId\":1" + "," + "\"fullDatabaseId\":\"1\"" + "," + "\"location\":{\"end\": {\"column\": 1}}"
            + "," + "\"message\":\"x\"" + "," + "\"path\":\"x\"" + "," + "\"rawDetails\":\"x\"" + ","
            + "\"title\":\"x\"" + "}";

    private static List<Object> readWithArguments(final CheckAnnotationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.annotationLevel());
        values.add(selector.blobUrl());
        values.add(selector.databaseId());
        values.add(selector.fullDatabaseId());
        values.add(selector.location(child -> child.end(CheckAnnotationPositionSelector::column)));
        values.add(selector.message());
        values.add(selector.path());
        values.add(selector.rawDetails());
        values.add(selector.title());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CheckAnnotationSelectorImpl(new RecordingCursor(root)));
        final CheckAnnotationSelectorImpl selector =
                new CheckAnnotationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(CheckAnnotationLevel.FAILURE, "x", 1, BigInteger.ONE, 1, "x", "x", "x", "x");
    }
}
