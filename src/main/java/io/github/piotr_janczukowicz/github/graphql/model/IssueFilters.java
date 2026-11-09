package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code IssueFilters}; a field left {@code null} is not sent. */
@RecordBuilder
public record IssueFilters(
        @Nullable String assignee,
        @Nullable String createdBy,
        @Nullable List<IssueFieldValueFilter> issueFieldValues,
        @Nullable List<String> labels,
        @Nullable String mentioned,
        @Nullable String milestone,
        @Nullable String milestoneNumber,
        @Nullable Instant since,
        @Nullable List<IssueState> states,
        @Nullable String type,
        @Nullable Boolean viewerSubscribed) {

    public IssueFilters {
        issueFieldValues = ListUtils.copyOrNull(issueFieldValues);
        labels = ListUtils.copyOrNull(labels);
        states = ListUtils.copyOrNull(states);
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        if (this.assignee != null) {
            variable.put("assignee", this.assignee);
        }
        if (this.createdBy != null) {
            variable.put("createdBy", this.createdBy);
        }
        if (this.issueFieldValues != null) {
            variable.put(
                    "issueFieldValues",
                    this.issueFieldValues.stream()
                            .map(IssueFieldValueFilter::toVariable)
                            .toList());
        }
        if (this.labels != null) {
            variable.put("labels", this.labels);
        }
        if (this.mentioned != null) {
            variable.put("mentioned", this.mentioned);
        }
        if (this.milestone != null) {
            variable.put("milestone", this.milestone);
        }
        if (this.milestoneNumber != null) {
            variable.put("milestoneNumber", this.milestoneNumber);
        }
        if (this.since != null) {
            variable.put("since", this.since.toString());
        }
        if (this.states != null) {
            variable.put(
                    "states", this.states.stream().map(IssueState::wireValue).toList());
        }
        if (this.type != null) {
            variable.put("type", this.type);
        }
        if (this.viewerSubscribed != null) {
            variable.put("viewerSubscribed", this.viewerSubscribed);
        }
        return Collections.unmodifiableMap(variable);
    }
}
