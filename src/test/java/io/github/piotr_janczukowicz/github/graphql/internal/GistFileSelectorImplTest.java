package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.GistFileTextFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class GistFileSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"encodedName\":\"x\"" + "," + "\"encoding\":\"x\"" + "," + "\"extension\":\"x\"" + ","
                    + "\"isImage\":true" + "," + "\"isTruncated\":true" + "," + "\"language\":{\"color\": \"x\"}" + ","
                    + "\"name\":\"x\"" + "," + "\"size\":1" + "," + "\"text\":\"x\"" + "}";

    private static List<Object> readWithArguments(final GistFileSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.encodedName());
        values.add(selector.encoding());
        values.add(selector.extension());
        values.add(selector.isImage());
        values.add(selector.isTruncated());
        values.add(selector.language(LanguageSelector::color));
        values.add(selector.name());
        values.add(selector.size());
        values.add(selector.text(GistFileTextFilterBuilder.builder().truncate(1).build()));
        return values;
    }

    private static List<Object> readWithoutArguments(final GistFileSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.text());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new GistFileSelectorImpl(new RecordingCursor(root)));
        final GistFileSelectorImpl selector =
                new GistFileSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", true, true, "x", "x", 1, "x");
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new GistFileSelectorImpl(new RecordingCursor(root)));
        final GistFileSelectorImpl selector =
                new GistFileSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x");
    }
}
