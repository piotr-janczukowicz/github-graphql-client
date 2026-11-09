package io.github.piotr_janczukowicz.github.graphql.model;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/** The GraphQL input object {@code DraftPullRequestReviewThread}; a field left {@code null} is not sent. */
@RecordBuilder
public record DraftPullRequestReviewThread(
        String body,
        @Nullable Integer line,
        @Nullable String path,
        @Nullable DiffSide side,
        @Nullable Integer startLine,
        @Nullable DiffSide startSide) {

    public DraftPullRequestReviewThread {
        requireNonNull(body, "body");
    }

    /**
     * Returns this input object as GraphQL expects it in a variable; a field left {@code null} is left out.
     *
     * @return the field names and their values
     */
    public Map<String, Object> toVariable() {
        final Map<String, Object> variable = new LinkedHashMap<>();
        variable.put("body", this.body);
        if (this.line != null) {
            variable.put("line", this.line);
        }
        if (this.path != null) {
            variable.put("path", this.path);
        }
        if (this.side != null) {
            variable.put("side", this.side.wireValue());
        }
        if (this.startLine != null) {
            variable.put("startLine", this.startLine);
        }
        if (this.startSide != null) {
            variable.put("startSide", this.startSide.wireValue());
        }
        return Collections.unmodifiableMap(variable);
    }
}
