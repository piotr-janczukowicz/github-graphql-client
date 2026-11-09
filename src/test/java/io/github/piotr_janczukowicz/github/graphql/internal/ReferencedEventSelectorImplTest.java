package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReferencedEventSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"actor\":{\"avatarUrl\": \"x\"}" + ","
            + "\"commit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"commitRepository\":{\"allowUpdateBranch\": true}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"id\":\"x\"" + "," + "\"isCrossRepository\":true"
            + "," + "\"isDirectReference\":true" + ","
            + "\"subject\":{\"__typename\": \"Issue\", \"activeLockReason\": \"OFF_TOPIC\"}" + "}";

    private static List<Object> readWithArguments(final ReferencedEventSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.actor(ActorSelector::avatarUrl));
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.commitRepository(RepositorySelector::allowUpdateBranch));
        values.add(selector.createdAt());
        values.add(selector.id());
        values.add(selector.isCrossRepository());
        values.add(selector.isDirectReference());
        values.add(selector.subject(child -> child.on(IssueSelector.class, IssueSelector::activeLockReason)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReferencedEventSelectorImpl(new RecordingCursor(root)));
        final ReferencedEventSelectorImpl selector =
                new ReferencedEventSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x", "x", true, Instant.parse("2024-05-01T10:15:30Z"), "x", true, true, LockReason.OFF_TOPIC);
    }
}
