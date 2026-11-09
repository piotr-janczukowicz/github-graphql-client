package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedDiscussionGradient;
import io.github.piotr_janczukowicz.github.graphql.model.PinnedDiscussionPattern;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PinnedDiscussionSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1"
            + "," + "\"discussion\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"gradientStopColors\":[\"x\"]"
            + "," + "\"id\":\"x\"" + "," + "\"pattern\":\"CHEVRON_UP\"" + "," + "\"pinnedBy\":{\"avatarUrl\": \"x\"}"
            + "," + "\"preconfiguredGradient\":\"BLUE_MINT\"" + "," + "\"repository\":{\"allowUpdateBranch\": true}"
            + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "}";

    private static List<Object> readWithArguments(final PinnedDiscussionSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.discussion(DiscussionSelector::activeLockReason));
        values.add(selector.gradientStopColors());
        values.add(selector.id());
        values.add(selector.pattern());
        values.add(selector.pinnedBy(ActorSelector::avatarUrl));
        values.add(selector.preconfiguredGradient());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.updatedAt());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PinnedDiscussionSelectorImpl(new RecordingCursor(root)));
        final PinnedDiscussionSelectorImpl selector =
                new PinnedDiscussionSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        Instant.parse("2024-05-01T10:15:30Z"),
                        1,
                        LockReason.OFF_TOPIC,
                        List.of("x"),
                        "x",
                        PinnedDiscussionPattern.CHEVRON_UP,
                        "x",
                        PinnedDiscussionGradient.BLUE_MINT,
                        true,
                        Instant.parse("2024-05-01T10:15:30Z"));
    }
}
