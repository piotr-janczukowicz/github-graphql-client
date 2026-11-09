package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.StarrableStargazersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class StarrableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"id\":\"x\"" + "," + "\"stargazerCount\":1" + ","
            + "\"stargazers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerHasStarred\":true" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"__typename\":\"Gist\"" + "}";

    private static List<Object> readWithArguments(final StarrableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.stargazerCount());
        values.add(selector.stargazers(
                Paging.first(1),
                StarrableStargazersFilterBuilder.builder()
                        .orderBy(StarOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(StarOrderField.STARRED_AT)
                                .build())
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.viewerHasStarred());
        values.add(selector.on(GistSelector.class, GistSelector::createdAt));
        return values;
    }

    private static List<Object> readWithoutArguments(final StarrableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.stargazers(Paging.first(1), UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new StarrableSelectorImpl(new RecordingCursor(root)));
        final StarrableSelectorImpl selector =
                new StarrableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", 1, new Page<>(List.of(true), false, null), true, Instant.parse("2024-05-01T10:15:30Z"));
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new StarrableSelectorImpl(new RecordingCursor(root)));
        final StarrableSelectorImpl selector =
                new StarrableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(true), false, null));
    }
}
