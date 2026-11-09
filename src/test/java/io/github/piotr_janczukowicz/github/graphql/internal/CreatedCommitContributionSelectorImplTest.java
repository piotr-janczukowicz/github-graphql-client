package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CreatedCommitContributionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"commitCount\":1" + "," + "\"isRestricted\":true" + ","
            + "\"occurredAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + ","
            + "\"resourcePath\":\"x\"" + "," + "\"url\":\"x\"" + "," + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final CreatedCommitContributionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.commitCount());
        values.add(selector.isRestricted());
        values.add(selector.occurredAt());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.url());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CreatedCommitContributionSelectorImpl(new RecordingCursor(root)));
        final CreatedCommitContributionSelectorImpl selector =
                new CreatedCommitContributionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, true, Instant.parse("2024-05-01T10:15:30Z"), true, "x", "x", true);
    }
}
