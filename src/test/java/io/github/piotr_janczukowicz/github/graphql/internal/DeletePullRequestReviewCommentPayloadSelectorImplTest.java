package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class DeletePullRequestReviewCommentPayloadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"clientMutationId\":\"x\"" + "," + "\"pullRequestReview\":{\"authorAssociation\": \"COLLABORATOR\"}"
                    + "," + "\"pullRequestReviewComment\":{\"authorAssociation\": \"COLLABORATOR\"}" + "}";

    private static List<Object> readWithArguments(final DeletePullRequestReviewCommentPayloadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.clientMutationId());
        values.add(selector.pullRequestReview(PullRequestReviewSelector::authorAssociation));
        values.add(selector.pullRequestReviewComment(PullRequestReviewCommentSelector::authorAssociation));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new DeletePullRequestReviewCommentPayloadSelectorImpl(new RecordingCursor(root)));
        final DeletePullRequestReviewCommentPayloadSelectorImpl selector =
                new DeletePullRequestReviewCommentPayloadSelectorImpl(
                        new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly("x", CommentAuthorAssociation.COLLABORATOR, CommentAuthorAssociation.COLLABORATOR);
    }
}
