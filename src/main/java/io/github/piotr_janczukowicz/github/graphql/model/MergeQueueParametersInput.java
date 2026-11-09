package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** The GraphQL input object {@code MergeQueueParametersInput}; a field left {@code null} is not sent. */
@RecordBuilder
public record MergeQueueParametersInput(
        Integer checkResponseTimeoutMinutes,
        MergeQueueGroupingStrategy groupingStrategy,
        Integer maxEntriesToBuild,
        Integer maxEntriesToMerge,
        MergeQueueMergeMethod mergeMethod,
        Integer minEntriesToMerge,
        Integer minEntriesToMergeWaitMinutes) {

    public MergeQueueParametersInput {
        requireNonNull(checkResponseTimeoutMinutes, "checkResponseTimeoutMinutes");
        requireNonNull(groupingStrategy, "groupingStrategy");
        requireNonNull(maxEntriesToBuild, "maxEntriesToBuild");
        requireNonNull(maxEntriesToMerge, "maxEntriesToMerge");
        requireNonNull(mergeMethod, "mergeMethod");
        requireNonNull(minEntriesToMerge, "minEntriesToMerge");
        requireNonNull(minEntriesToMergeWaitMinutes, "minEntriesToMergeWaitMinutes");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("checkResponseTimeoutMinutes", this.checkResponseTimeoutMinutes);
        variable.put("groupingStrategy", this.groupingStrategy.wireValue());
        variable.put("maxEntriesToBuild", this.maxEntriesToBuild);
        variable.put("maxEntriesToMerge", this.maxEntriesToMerge);
        variable.put("mergeMethod", this.mergeMethod.wireValue());
        variable.put("minEntriesToMerge", this.minEntriesToMerge);
        variable.put("minEntriesToMergeWaitMinutes", this.minEntriesToMergeWaitMinutes);
        return Collections.unmodifiableMap(variable);
    }
}
