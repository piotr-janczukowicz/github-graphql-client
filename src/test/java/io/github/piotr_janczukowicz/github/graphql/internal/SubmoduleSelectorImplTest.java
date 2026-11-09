package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SubmoduleSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"branch\":\"x\"" + "," + "\"gitUrl\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"nameRaw\":\"x\""
                    + "," + "\"path\":\"x\"" + "," + "\"pathRaw\":\"x\"" + "," + "\"subprojectCommitOid\":\"x\"" + "}";

    private static List<Object> readWithArguments(final SubmoduleSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.branch());
        values.add(selector.gitUrl());
        values.add(selector.name());
        values.add(selector.nameRaw());
        values.add(selector.path());
        values.add(selector.pathRaw());
        values.add(selector.subprojectCommitOid());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new SubmoduleSelectorImpl(new RecordingCursor(root)));
        final SubmoduleSelectorImpl selector =
                new SubmoduleSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x", "x", "x");
    }
}
