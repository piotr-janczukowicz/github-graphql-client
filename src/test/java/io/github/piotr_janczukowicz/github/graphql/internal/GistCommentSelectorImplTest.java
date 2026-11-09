package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommentCannotUpdateReason;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserContentEditSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class GistCommentSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"author\":{\"avatarUrl\": \"x\"}" + ","
            + "\"authorAssociation\":\"COLLABORATOR\"" + "," + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + ","
            + "\"bodyText\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"createdViaEmail\":true"
            + "," + "\"databaseId\":1" + "," + "\"editor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"gist\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + "," + "\"id\":\"x\"" + ","
            + "\"includesCreatedEdit\":true" + "," + "\"isMinimized\":true" + ","
            + "\"lastEditedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"minimizedReason\":\"x\"" + ","
            + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"userContentEdits\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanDelete\":true" + "," + "\"viewerCanMinimize\":true" + ","
            + "\"viewerCanUnminimize\":true" + "," + "\"viewerCanUpdate\":true" + ","
            + "\"viewerCannotUpdateReasons\":[\"ARCHIVED\"]" + "," + "\"viewerDidAuthor\":true" + "}";

    private static List<Object> readWithArguments(final GistCommentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.author(ActorSelector::avatarUrl));
        values.add(selector.authorAssociation());
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.bodyText());
        values.add(selector.createdAt());
        values.add(selector.createdViaEmail());
        values.add(selector.databaseId());
        values.add(selector.editor(ActorSelector::avatarUrl));
        values.add(selector.gist(GistSelector::createdAt));
        values.add(selector.id());
        values.add(selector.includesCreatedEdit());
        values.add(selector.isMinimized());
        values.add(selector.lastEditedAt());
        values.add(selector.minimizedReason());
        values.add(selector.publishedAt());
        values.add(selector.updatedAt());
        values.add(selector.userContentEdits(Paging.first(1), UserContentEditSelector::createdAt));
        values.add(selector.viewerCanDelete());
        values.add(selector.viewerCanMinimize());
        values.add(selector.viewerCanUnminimize());
        values.add(selector.viewerCanUpdate());
        values.add(selector.viewerCannotUpdateReasons());
        values.add(selector.viewerDidAuthor());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new GistCommentSelectorImpl(new RecordingCursor(root)));
        final GistCommentSelectorImpl selector =
                new GistCommentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        CommentAuthorAssociation.COLLABORATOR,
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true,
                        1,
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true,
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        true,
                        true,
                        true,
                        true,
                        List.of(CommentCannotUpdateReason.ARCHIVED),
                        true);
    }
}
