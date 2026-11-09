package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CreatedIssueContributionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"isRestricted\":true" + ","
            + "\"issue\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"occurredAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"resourcePath\":\"x\"" + "," + "\"url\":\"x\"" + "," + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final CreatedIssueContributionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.isRestricted());
        values.add(selector.issue(IssueSelector::activeLockReason));
        values.add(selector.occurredAt());
        values.add(selector.resourcePath());
        values.add(selector.url());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CreatedIssueContributionSelectorImpl(new RecordingCursor(root)));
        final CreatedIssueContributionSelectorImpl selector =
                new CreatedIssueContributionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(true, LockReason.OFF_TOPIC, Instant.parse("2024-05-01T10:15:30Z"), "x", "x", true);
    }
}
