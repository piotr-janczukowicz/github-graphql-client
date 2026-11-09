package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactableSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
@SuppressWarnings({"deprecation", "removal"})
class ReactionGroupSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"content\":\"CONFUSED\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
                    + "\"reactors\":{\"nodes\": [{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"subject\":{\"databaseId\": 1}" + ","
                    + "\"users\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"viewerHasReacted\":true" + "}";

    private static List<Object> readWithArguments(final ReactionGroupSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.content());
        values.add(selector.createdAt());
        values.add(selector.reactors(Paging.first(1), child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.subject(ReactableSelector::databaseId));
        values.add(selector.users(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.viewerHasReacted());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReactionGroupSelectorImpl(new RecordingCursor(root)));
        final ReactionGroupSelectorImpl selector =
                new ReactionGroupSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        ReactionContent.CONFUSED,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        new Page<>(List.of("x"), false, null),
                        1,
                        new Page<>(List.of(true), false, null),
                        true);
    }
}
