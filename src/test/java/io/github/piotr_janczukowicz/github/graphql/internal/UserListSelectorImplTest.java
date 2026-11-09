package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UserListSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"description\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"isPrivate\":true" + ","
            + "\"items\":{\"nodes\": [{\"__typename\": \"Repository\", \"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"lastAddedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"name\":\"x\"" + "," + "\"slug\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final UserListSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.description());
        values.add(selector.id());
        values.add(selector.isPrivate());
        values.add(selector.items(
                Paging.first(1), child -> child.on(RepositorySelector.class, RepositorySelector::allowUpdateBranch)));
        values.add(selector.lastAddedAt());
        values.add(selector.name());
        values.add(selector.slug());
        values.add(selector.updatedAt());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UserListSelectorImpl(new RecordingCursor(root)));
        final UserListSelectorImpl selector =
                new UserListSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        true,
                        new Page<>(List.of(true), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        true);
    }
}
