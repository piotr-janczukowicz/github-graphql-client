package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code RefUpdateRule}. */
public interface RefUpdateRuleSelector {

    boolean allowsDeletions();

    boolean allowsForcePushes();

    boolean blocksCreations();

    String pattern();

    @Nullable Integer requiredApprovingReviewCount();

    List<String> requiredStatusCheckContexts();

    boolean requiresCodeOwnerReviews();

    boolean requiresConversationResolution();

    boolean requiresLinearHistory();

    boolean requiresSignatures();

    boolean viewerAllowedToDismissReviews();

    boolean viewerCanPush();
}
