package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ProjectV2ItemIssueFieldValue}. */
public interface ProjectV2ItemIssueFieldValueSelector {

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> @Nullable R issueFieldValue(Function<ProjectV2IssueFieldValuesSelector, R> selection);
}
