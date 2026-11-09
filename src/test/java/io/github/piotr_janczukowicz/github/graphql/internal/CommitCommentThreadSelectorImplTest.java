package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.CommitCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class CommitCommentThreadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"comments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"commit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"id\":\"x\"" + "," + "\"path\":\"x\"" + ","
            + "\"position\":1" + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "}";

    private static List<Object> readWithArguments(final CommitCommentThreadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.comments(Paging.first(1), CommitCommentSelector::authorAssociation));
        values.add(selector.commit(CommitSelector::abbreviatedOid));
        values.add(selector.id());
        values.add(selector.path());
        values.add(selector.position());
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new CommitCommentThreadSelectorImpl(new RecordingCursor(root)));
        final CommitCommentThreadSelectorImpl selector =
                new CommitCommentThreadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        "x",
                        "x",
                        "x",
                        1,
                        true);
    }
}
