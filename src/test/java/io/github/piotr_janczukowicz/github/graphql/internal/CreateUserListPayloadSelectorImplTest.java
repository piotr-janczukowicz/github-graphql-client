package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.UserListSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CreateUserListPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"clientMutationId\":\"x\"" + "," + "\"list\":{\"createdAt\": \"2024-05-01T10:15:30Z\"}" + ","
                    + "\"viewer\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final CreateUserListPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.list(UserListSelector::createdAt));
        values.add(selector.viewer(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CreateUserListPayloadSelectorImpl(new RecordingCursor(root)));
        final CreateUserListPayloadSelectorImpl selector =
                new CreateUserListPayloadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", Instant.parse("2024-05-01T10:15:30Z"), true);
    }
}
