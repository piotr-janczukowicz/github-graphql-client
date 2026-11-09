package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.RefUpdateRuleSelector;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code RefUpdateRule}; used by the generated selection code only. */
final class RefUpdateRuleSelectorImpl implements RefUpdateRuleSelector {

    private final Cursor cursor;

    RefUpdateRuleSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean allowsDeletions() {
        return cursor.getRequired("allowsDeletions", ScalarType.BOOLEAN);
    }

    @Override
    public boolean allowsForcePushes() {
        return cursor.getRequired("allowsForcePushes", ScalarType.BOOLEAN);
    }

    @Override
    public boolean blocksCreations() {
        return cursor.getRequired("blocksCreations", ScalarType.BOOLEAN);
    }

    @Override
    public String pattern() {
        return cursor.getRequired("pattern", ScalarType.STRING);
    }

    @Override
    public @Nullable Integer requiredApprovingReviewCount() {
        return cursor.get("requiredApprovingReviewCount", ScalarType.INT);
    }

    @Override
    public List<String> requiredStatusCheckContexts() {
        return cursor.scalarList("requiredStatusCheckContexts", ScalarType.STRING);
    }

    @Override
    public boolean requiresCodeOwnerReviews() {
        return cursor.getRequired("requiresCodeOwnerReviews", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresConversationResolution() {
        return cursor.getRequired("requiresConversationResolution", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresLinearHistory() {
        return cursor.getRequired("requiresLinearHistory", ScalarType.BOOLEAN);
    }

    @Override
    public boolean requiresSignatures() {
        return cursor.getRequired("requiresSignatures", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerAllowedToDismissReviews() {
        return cursor.getRequired("viewerAllowedToDismissReviews", ScalarType.BOOLEAN);
    }

    @Override
    public boolean viewerCanPush() {
        return cursor.getRequired("viewerCanPush", ScalarType.BOOLEAN);
    }
}
