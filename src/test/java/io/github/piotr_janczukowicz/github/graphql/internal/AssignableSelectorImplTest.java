package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AssignableSuggestedActorsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class AssignableSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"assignedActors\":{\"nodes\": [{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"assignees\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"suggestedActors\":{\"nodes\": [{\"__typename\": \"Bot\", \"avatarUrl\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"viewerCanAssign\":true" + "," + "\"activeLockReason\":\"OFF_TOPIC\"" + ","
            + "\"__typename\":\"Issue\"" + "}";

    private static List<Object> readWithArguments(final AssignableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(
                selector.assignedActors(Paging.first(1), child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.assignees(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.suggestedActors(
                Paging.first(1),
                AssignableSuggestedActorsFilterBuilder.builder().query("x").build(),
                child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        values.add(selector.viewerCanAssign());
        values.add(selector.on(IssueSelector.class, IssueSelector::activeLockReason));
        return values;
    }

    private static List<Object> readWithoutArguments(final AssignableSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.suggestedActors(
                Paging.first(1), child -> child.on(BotSelector.class, BotSelector::avatarUrl)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new AssignableSelectorImpl(new RecordingCursor(root)));
        final AssignableSelectorImpl selector =
                new AssignableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of("x"), false, null),
                        new Page<>(List.of(true), false, null),
                        new Page<>(List.of("x"), false, null),
                        true,
                        LockReason.OFF_TOPIC);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new AssignableSelectorImpl(new RecordingCursor(root)));
        final AssignableSelectorImpl selector =
                new AssignableSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of("x"), false, null));
    }
}
