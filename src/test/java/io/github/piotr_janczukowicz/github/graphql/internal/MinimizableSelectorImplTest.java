package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class MinimizableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"isMinimized\":true" + "," + "\"minimizedReason\":\"x\"" + ","
            + "\"viewerCanMinimize\":true" + "," + "\"viewerCanUnminimize\":true" + ","
            + "\"authorAssociation\":\"COLLABORATOR\"" + "," + "\"__typename\":\"CommitComment\"" + "}";

    private static List<Object> readWithArguments(final MinimizableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.isMinimized());
        values.add(selector.minimizedReason());
        values.add(selector.viewerCanMinimize());
        values.add(selector.viewerCanUnminimize());
        values.add(selector.on(CommitCommentSelector.class, CommitCommentSelector::authorAssociation));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new MinimizableSelectorImpl(new RecordingCursor(root)));
        final MinimizableSelectorImpl selector =
                new MinimizableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(true, "x", true, true, CommentAuthorAssociation.COLLABORATOR);
    }
}
