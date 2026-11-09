package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LanguageSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.SubmoduleSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class TreeEntrySelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"extension\":\"x\"" + "," + "\"isGenerated\":true" + ","
            + "\"language\":{\"color\": \"x\"}" + "," + "\"lineCount\":1" + "," + "\"mode\":1" + "," + "\"name\":\"x\""
            + "," + "\"nameRaw\":\"x\"" + "," + "\"object\":{\"abbreviatedOid\": \"x\"}" + "," + "\"oid\":\"x\"" + ","
            + "\"path\":\"x\"" + "," + "\"pathRaw\":\"x\"" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + ","
            + "\"size\":1" + "," + "\"submodule\":{\"branch\": \"x\"}" + "," + "\"type\":\"x\"" + "}";

    private static List<Object> readWithArguments(final TreeEntrySelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.extension());
        values.add(selector.isGenerated());
        values.add(selector.language(LanguageSelector::color));
        values.add(selector.lineCount());
        values.add(selector.mode());
        values.add(selector.name());
        values.add(selector.nameRaw());
        values.add(selector.object(GitObjectSelector::abbreviatedOid));
        values.add(selector.oid());
        values.add(selector.path());
        values.add(selector.pathRaw());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.size());
        values.add(selector.submodule(SubmoduleSelector::branch));
        values.add(selector.type());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new TreeEntrySelectorImpl(new RecordingCursor(root)));
        final TreeEntrySelectorImpl selector =
                new TreeEntrySelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, "x", 1, 1, "x", "x", "x", "x", "x", "x", true, 1, "x", "x");
    }
}
