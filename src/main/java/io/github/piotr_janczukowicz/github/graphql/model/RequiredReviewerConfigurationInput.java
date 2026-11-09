package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** The GraphQL input object {@code RequiredReviewerConfigurationInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record RequiredReviewerConfigurationInput(
        List<String> filePatterns, Integer minimumApprovals, String reviewerId) {

    public RequiredReviewerConfigurationInput {
        requireNonNull(minimumApprovals, "minimumApprovals");
        requireNonNull(reviewerId, "reviewerId");
        filePatterns = ListUtils.copyOf(filePatterns, "filePatterns");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("filePatterns", this.filePatterns);
        variable.put("minimumApprovals", this.minimumApprovals);
        variable.put("reviewerId", this.reviewerId);
        return Collections.unmodifiableMap(variable);
    }
}
