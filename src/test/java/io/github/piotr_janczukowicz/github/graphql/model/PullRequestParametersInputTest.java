package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class PullRequestParametersInputTest {

    @Test
    void constructor_shouldFail_whenDismissStaleReviewsOnPushIsNull() {
        final PullRequestParametersInputBuilder builder = PullRequestParametersInputBuilder.builder()
                .requireCodeOwnerReview(true)
                .requireLastPushApproval(true)
                .requiredApprovingReviewCount(1)
                .requiredReviewThreadResolution(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("dismissStaleReviewsOnPush must not be null");
    }

    @Test
    void constructor_shouldFail_whenRequireCodeOwnerReviewIsNull() {
        final PullRequestParametersInputBuilder builder = PullRequestParametersInputBuilder.builder()
                .dismissStaleReviewsOnPush(true)
                .requireLastPushApproval(true)
                .requiredApprovingReviewCount(1)
                .requiredReviewThreadResolution(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("requireCodeOwnerReview must not be null");
    }

    @Test
    void constructor_shouldFail_whenRequireLastPushApprovalIsNull() {
        final PullRequestParametersInputBuilder builder = PullRequestParametersInputBuilder.builder()
                .dismissStaleReviewsOnPush(true)
                .requireCodeOwnerReview(true)
                .requiredApprovingReviewCount(1)
                .requiredReviewThreadResolution(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("requireLastPushApproval must not be null");
    }

    @Test
    void constructor_shouldFail_whenRequiredApprovingReviewCountIsNull() {
        final PullRequestParametersInputBuilder builder = PullRequestParametersInputBuilder.builder()
                .dismissStaleReviewsOnPush(true)
                .requireCodeOwnerReview(true)
                .requireLastPushApproval(true)
                .requiredReviewThreadResolution(true);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("requiredApprovingReviewCount must not be null");
    }

    @Test
    void constructor_shouldFail_whenRequiredReviewThreadResolutionIsNull() {
        final PullRequestParametersInputBuilder builder = PullRequestParametersInputBuilder.builder()
                .dismissStaleReviewsOnPush(true)
                .requireCodeOwnerReview(true)
                .requireLastPushApproval(true)
                .requiredApprovingReviewCount(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown)
                .isInstanceOf(NullPointerException.class)
                .hasMessage("requiredReviewThreadResolution must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final PullRequestParametersInput input = PullRequestParametersInputBuilder.builder()
                .dismissStaleReviewsOnPush(true)
                .requireCodeOwnerReview(true)
                .requireLastPushApproval(true)
                .requiredApprovingReviewCount(1)
                .requiredReviewThreadResolution(true)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("dismissStaleReviewsOnPush", true),
                        entry("requireCodeOwnerReview", true),
                        entry("requireLastPushApproval", true),
                        entry("requiredApprovingReviewCount", 1),
                        entry("requiredReviewThreadResolution", true));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final PullRequestParametersInput input = PullRequestParametersInputBuilder.builder()
                .allowedMergeMethods(List.of(PullRequestAllowedMergeMethods.MERGE))
                .dismissStaleReviewsOnPush(true)
                .dismissalRestriction(
                        DismissalRestrictionInputBuilder.builder().enabled(true).build())
                .requireCodeOwnerReview(true)
                .requireExtraApprovalForUnattributedChanges(true)
                .requireLastPushApproval(true)
                .requiredApprovingReviewCount(1)
                .requiredReviewThreadResolution(true)
                .requiredReviewers(List.of(RequiredReviewerConfigurationInputBuilder.builder()
                        .filePatterns(List.of("x"))
                        .minimumApprovals(1)
                        .reviewerId("x")
                        .build()))
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("allowedMergeMethods", List.of("MERGE")),
                        entry("dismissStaleReviewsOnPush", true),
                        entry("dismissalRestriction", Map.ofEntries(entry("enabled", true))),
                        entry("requireCodeOwnerReview", true),
                        entry("requireExtraApprovalForUnattributedChanges", true),
                        entry("requireLastPushApproval", true),
                        entry("requiredApprovingReviewCount", 1),
                        entry("requiredReviewThreadResolution", true),
                        entry(
                                "requiredReviewers",
                                List.of(Map.ofEntries(
                                        entry("filePatterns", List.of("x")),
                                        entry("minimumApprovals", 1),
                                        entry("reviewerId", "x")))));
    }
}
