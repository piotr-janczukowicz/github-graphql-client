package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserListSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class UpdateUserListsForItemPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"clientMutationId\":\"x\"" + ","
            + "\"item\":{\"__typename\": \"Repository\", \"allowUpdateBranch\": true}" + ","
            + "\"lists\":[{\"createdAt\": \"2024-05-01T10:15:30Z\"}]" + "," + "\"user\":{\"anyPinnableItems\": true}"
            + "}";

    private static List<Object> readWithArguments(final UpdateUserListsForItemPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.item(child -> child.on(RepositorySelector.class, RepositorySelector::allowUpdateBranch)));
        values.add(selector.lists(UserListSelector::createdAt));
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new UpdateUserListsForItemPayloadSelectorImpl(new RecordingCursor(root)));
        final UpdateUserListsForItemPayloadSelectorImpl selector =
                new UpdateUserListsForItemPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", true, List.of(Instant.parse("2024-05-01T10:15:30Z")), true);
    }
}
