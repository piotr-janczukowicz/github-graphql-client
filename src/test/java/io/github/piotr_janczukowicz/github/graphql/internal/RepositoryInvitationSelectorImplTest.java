package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositoryInfoSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPermission;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryInvitationSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"email\":\"x\"" + "," + "\"id\":\"x\"" + ","
            + "\"invitee\":{\"anyPinnableItems\": true}" + "," + "\"inviter\":{\"anyPinnableItems\": true}" + ","
            + "\"permalink\":\"x\"" + "," + "\"permission\":\"ADMIN\"" + ","
            + "\"repository\":{\"archivedAt\": \"2024-05-01T10:15:30Z\"}" + "}";

    private static List<Object> readWithArguments(final RepositoryInvitationSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.email());
        values.add(selector.id());
        values.add(selector.invitee(UserSelector::anyPinnableItems));
        values.add(selector.inviter(UserSelector::anyPinnableItems));
        values.add(selector.permalink());
        values.add(selector.permission());
        values.add(selector.repository(RepositoryInfoSelector::archivedAt));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryInvitationSelectorImpl(new RecordingCursor(root)));
        final RepositoryInvitationSelectorImpl selector =
                new RepositoryInvitationSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", "x", true, true, "x", RepositoryPermission.ADMIN, Instant.parse("2024-05-01T10:15:30Z"));
    }
}
