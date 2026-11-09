package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class BlobSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"abbreviatedOid\":\"x\"" + "," + "\"byteSize\":1" + ","
            + "\"commitResourcePath\":\"x\"" + "," + "\"commitUrl\":\"x\"" + "," + "\"id\":\"x\"" + ","
            + "\"isBinary\":true" + "," + "\"isTruncated\":true" + "," + "\"oid\":\"x\"" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"text\":\"x\"" + "}";

    private static List<Object> readWithArguments(final BlobSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.abbreviatedOid());
        values.add(selector.byteSize());
        values.add(selector.commitResourcePath());
        values.add(selector.commitUrl());
        values.add(selector.id());
        values.add(selector.isBinary());
        values.add(selector.isTruncated());
        values.add(selector.oid());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.text());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new BlobSelectorImpl(new RecordingCursor(root)));
        final BlobSelectorImpl selector = new BlobSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", 1, "x", "x", "x", true, true, "x", true, "x");
    }
}
