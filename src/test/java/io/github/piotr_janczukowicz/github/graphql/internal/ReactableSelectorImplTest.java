package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ReactableReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReactableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"databaseId\":1" + "," + "\"id\":\"x\"" + ","
            + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]" + ","
            + "\"reactions\":{\"nodes\": [{\"content\": \"CONFUSED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanReact\":true" + "," + "\"authorAssociation\":\"COLLABORATOR\"" + ","
            + "\"__typename\":\"CommitComment\"" + "}";

    private static List<Object> readWithArguments(final ReactableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.databaseId());
        values.add(selector.id());
        values.add(selector.reactionGroups(ReactionGroupSelector::content));
        values.add(selector.reactions(
                Paging.first(1),
                ReactableReactionsFilterBuilder.builder()
                        .content(ReactionContent.CONFUSED)
                        .orderBy(ReactionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReactionOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReactionSelector::content));
        values.add(selector.viewerCanReact());
        values.add(selector.on(CommitCommentSelector.class, CommitCommentSelector::authorAssociation));
        return values;
    }

    private static List<Object> readWithoutArguments(final ReactableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.reactions(Paging.first(1), ReactionSelector::content));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReactableSelectorImpl(new RecordingCursor(root)));
        final ReactableSelectorImpl selector =
                new ReactableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        1,
                        "x",
                        List.of(ReactionContent.CONFUSED),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        true,
                        CommentAuthorAssociation.COLLABORATOR);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ReactableSelectorImpl(new RecordingCursor(root)));
        final ReactableSelectorImpl selector =
                new ReactableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(ReactionContent.CONFUSED), false, null));
    }
}
