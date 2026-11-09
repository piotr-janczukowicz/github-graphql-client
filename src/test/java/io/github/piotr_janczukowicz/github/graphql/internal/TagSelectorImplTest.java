package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.GitActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GitObjectSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class TagSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"abbreviatedOid\":\"x\"" + "," + "\"commitResourcePath\":\"x\"" + ","
            + "\"commitUrl\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"message\":\"x\"" + "," + "\"name\":\"x\"" + ","
            + "\"oid\":\"x\"" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + ","
            + "\"tagger\":{\"avatarUrl\": \"x\"}" + "," + "\"target\":{\"abbreviatedOid\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final TagSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.abbreviatedOid());
        values.add(selector.commitResourcePath());
        values.add(selector.commitUrl());
        values.add(selector.id());
        values.add(selector.message());
        values.add(selector.name());
        values.add(selector.oid());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.tagger(GitActorSelector::avatarUrl));
        values.add(selector.target(GitObjectSelector::abbreviatedOid));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new TagSelectorImpl(new RecordingCursor(root)));
        final TagSelectorImpl selector = new TagSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", "x", "x", "x", "x", true, "x", "x");
    }
}
