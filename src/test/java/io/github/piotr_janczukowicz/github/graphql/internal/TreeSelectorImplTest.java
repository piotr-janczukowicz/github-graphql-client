package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TreeEntrySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class TreeSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"abbreviatedOid\":\"x\"" + "," + "\"commitResourcePath\":\"x\"" + ","
            + "\"commitUrl\":\"x\"" + "," + "\"entries\":[{\"extension\": \"x\"}]" + "," + "\"id\":\"x\"" + ","
            + "\"oid\":\"x\"" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "}";

    private static List<Object> readWithArguments(final TreeSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.abbreviatedOid());
        values.add(selector.commitResourcePath());
        values.add(selector.commitUrl());
        values.add(selector.entries(TreeEntrySelector::extension));
        values.add(selector.id());
        values.add(selector.oid());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new TreeSelectorImpl(new RecordingCursor(root)));
        final TreeSelectorImpl selector = new TreeSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", List.of("x"), "x", "x", true);
    }
}
