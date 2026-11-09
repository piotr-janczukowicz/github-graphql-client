package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PinnedIssueSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"databaseId\":1" + "," + "\"fullDatabaseId\":\"1\"" + ","
            + "\"id\":\"x\"" + "," + "\"issue\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"pinnedBy\":{\"avatarUrl\": \"x\"}" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "}";

    private static List<Object> readWithArguments(final PinnedIssueSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.databaseId());
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.issue(IssueSelector::activeLockReason));
        values.add(selector.pinnedBy(ActorSelector::avatarUrl));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PinnedIssueSelectorImpl(new RecordingCursor(root)));
        final PinnedIssueSelectorImpl selector =
                new PinnedIssueSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly(1, BigInteger.ONE, "x", LockReason.OFF_TOPIC, "x", true);
    }
}
