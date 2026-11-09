package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PullRequestTemplateSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"body\":\"x\"" + "," + "\"filename\":\"x\"" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "}";

    private static List<Object> readWithArguments(final PullRequestTemplateSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.body());
        values.add(selector.filename());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestTemplateSelectorImpl(new RecordingCursor(root)));
        final PullRequestTemplateSelectorImpl selector =
                new PullRequestTemplateSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", true);
    }
}
