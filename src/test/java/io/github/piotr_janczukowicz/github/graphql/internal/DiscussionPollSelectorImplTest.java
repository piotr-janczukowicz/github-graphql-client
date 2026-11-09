package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionPollOptionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.DiscussionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DiscussionPollSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"discussion\":{\"activeLockReason\": \"OFF_TOPIC\"}" + "," + "\"id\":\"x\"" + ","
                    + "\"options\":{\"nodes\": [{\"id\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"question\":\"x\"" + "," + "\"totalVoteCount\":1" + "," + "\"viewerCanVote\":true" + ","
                    + "\"viewerHasVoted\":true" + "}";

    private static List<Object> readWithArguments(final DiscussionPollSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.discussion(DiscussionSelector::activeLockReason));
        values.add(selector.id());
        values.add(selector.options(
                Paging.first(1),
                DiscussionPollOptionsFilterBuilder.builder()
                        .orderBy(DiscussionPollOptionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(DiscussionPollOptionOrderField.AUTHORED_ORDER)
                                .build())
                        .build(),
                DiscussionPollOptionSelector::id));
        values.add(selector.question());
        values.add(selector.totalVoteCount());
        values.add(selector.viewerCanVote());
        values.add(selector.viewerHasVoted());
        return values;
    }

    private static List<Object> readWithoutArguments(final DiscussionPollSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.options(Paging.first(1), DiscussionPollOptionSelector::id));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DiscussionPollSelectorImpl(new RecordingCursor(root)));
        final DiscussionPollSelectorImpl selector =
                new DiscussionPollSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(LockReason.OFF_TOPIC, "x", new Page<>(List.of("x"), false, null), "x", 1, true, true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new DiscussionPollSelectorImpl(new RecordingCursor(root)));
        final DiscussionPollSelectorImpl selector =
                new DiscussionPollSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
