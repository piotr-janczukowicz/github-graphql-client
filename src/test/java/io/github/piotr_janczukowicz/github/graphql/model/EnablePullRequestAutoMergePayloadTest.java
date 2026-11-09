package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class EnablePullRequestAutoMergePayloadTest {

    @Test
    void constructor_shouldFail_whenPullRequestIdIsNull() {
        final EnablePullRequestAutoMergePayloadBuilder builder = EnablePullRequestAutoMergePayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("pullRequestId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final EnablePullRequestAutoMergePayload input = EnablePullRequestAutoMergePayloadBuilder.builder()
                .pullRequestId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("pullRequestId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final EnablePullRequestAutoMergePayload input = EnablePullRequestAutoMergePayloadBuilder.builder()
                .authorEmail("x")
                .clientMutationId("x")
                .commitBody("x")
                .commitHeadline("x")
                .expectedHeadOid("x")
                .mergeMethod(PullRequestMergeMethod.MERGE)
                .pullRequestId("x")
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("authorEmail", "x"),
                        entry("clientMutationId", "x"),
                        entry("commitBody", "x"),
                        entry("commitHeadline", "x"),
                        entry("expectedHeadOid", "x"),
                        entry("mergeMethod", "MERGE"),
                        entry("pullRequestId", "x"));
    }
}
