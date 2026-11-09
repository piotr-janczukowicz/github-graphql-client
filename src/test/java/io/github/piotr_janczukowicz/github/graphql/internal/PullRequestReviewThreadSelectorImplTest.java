package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.DiffSide;
import io.github.piotr_janczukowicz.github.graphql.model.LockReason;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadCommentsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestReviewThreadSubjectType;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class PullRequestReviewThreadSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"comments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"diffSide\":\"LEFT\"" + "," + "\"id\":\"x\"" + "," + "\"isCollapsed\":true" + ","
            + "\"isOutdated\":true" + "," + "\"isResolved\":true" + "," + "\"line\":1" + "," + "\"originalLine\":1"
            + "," + "\"originalStartLine\":1" + "," + "\"path\":\"x\"" + ","
            + "\"pullRequest\":{\"activeLockReason\": \"OFF_TOPIC\"}" + ","
            + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resolvedBy\":{\"anyPinnableItems\": true}" + ","
            + "\"startDiffSide\":\"LEFT\"" + "," + "\"startLine\":1" + "," + "\"subjectType\":\"FILE\"" + ","
            + "\"viewerCanReply\":true" + "," + "\"viewerCanResolve\":true" + "," + "\"viewerCanUnresolve\":true" + "}";

    private static List<Object> readWithArguments(final PullRequestReviewThreadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.comments(
                Paging.first(1),
                PullRequestReviewThreadCommentsFilterBuilder.builder().skip(1).build(),
                PullRequestReviewCommentSelector::authorAssociation));
        values.add(selector.diffSide());
        values.add(selector.id());
        values.add(selector.isCollapsed());
        values.add(selector.isOutdated());
        values.add(selector.isResolved());
        values.add(selector.line());
        values.add(selector.originalLine());
        values.add(selector.originalStartLine());
        values.add(selector.path());
        values.add(selector.pullRequest(PullRequestSelector::activeLockReason));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resolvedBy(UserSelector::anyPinnableItems));
        values.add(selector.startDiffSide());
        values.add(selector.startLine());
        values.add(selector.subjectType());
        values.add(selector.viewerCanReply());
        values.add(selector.viewerCanResolve());
        values.add(selector.viewerCanUnresolve());
        return values;
    }

    private static List<Object> readWithoutArguments(final PullRequestReviewThreadSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.comments(Paging.first(1), PullRequestReviewCommentSelector::authorAssociation));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new PullRequestReviewThreadSelectorImpl(new RecordingCursor(root)));
        final PullRequestReviewThreadSelectorImpl selector =
                new PullRequestReviewThreadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        DiffSide.LEFT,
                        "x",
                        true,
                        true,
                        true,
                        1,
                        1,
                        1,
                        "x",
                        LockReason.OFF_TOPIC,
                        true,
                        true,
                        DiffSide.LEFT,
                        1,
                        PullRequestReviewThreadSubjectType.FILE,
                        true,
                        true,
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new PullRequestReviewThreadSelectorImpl(new RecordingCursor(root)));
        final PullRequestReviewThreadSelectorImpl selector =
                new PullRequestReviewThreadSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly(new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null));
    }
}
