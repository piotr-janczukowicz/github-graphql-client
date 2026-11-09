package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.ActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PinnedIssueCommentSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"databaseId\":1" + "," + "\"fullDatabaseId\":\"1\"" + ","
            + "\"id\":\"x\"" + "," + "\"issue\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"issueComment\":{\"authorAssociation\": \"COLLABORATOR\"}" + ","
            + "\"pinnedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"pinnedBy\":{\"avatarUrl\": \"x\"}" + "}";

    private static List<Object> readWithArguments(final PinnedIssueCommentSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.databaseId());
        values.add(selector.fullDatabaseId());
        values.add(selector.id());
        values.add(selector.issue(IssueSelector::activeLockReason));
        values.add(selector.issueComment(IssueCommentSelector::authorAssociation));
        values.add(selector.pinnedAt());
        values.add(selector.pinnedBy(ActorSelector::avatarUrl));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PinnedIssueCommentSelectorImpl(new RecordingCursor(root)));
        final PinnedIssueCommentSelectorImpl selector =
                new PinnedIssueCommentSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        1,
                        BigInteger.ONE,
                        "x",
                        LockReason.OFF_TOPIC,
                        CommentAuthorAssociation.COLLABORATOR,
                        Instant.parse("2024-05-01T10:15:30Z"),
                        "x");
    }
}
