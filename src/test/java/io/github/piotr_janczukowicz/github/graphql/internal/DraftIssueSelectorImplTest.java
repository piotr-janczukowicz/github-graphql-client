package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2ItemSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ProjectV2Selector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DraftIssueSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"assignees\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"body\":\"x\"" + "," + "\"bodyHTML\":\"x\"" + "," + "\"bodyText\":\"x\"" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"creator\":{\"avatarUrl\": \"x\"}" + ","
            + "\"id\":\"x\"" + ","
            + "\"projectV2Items\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"projectsV2\":{\"nodes\": [{\"closed\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"title\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final DraftIssueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.assignees(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.body());
        values.add(selector.bodyHTML());
        values.add(selector.bodyText());
        values.add(selector.createdAt());
        values.add(selector.creator(ActorSelector::avatarUrl));
        values.add(selector.id());
        values.add(selector.projectV2Items(Paging.first(1), ProjectV2ItemSelector::createdAt));
        values.add(selector.projectsV2(Paging.first(1), ProjectV2Selector::closed));
        values.add(selector.title());
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DraftIssueSelectorImpl(new RecordingCursor(root)));
        final DraftIssueSelectorImpl selector =
                new DraftIssueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(true), false, null),
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z));
    }
}
