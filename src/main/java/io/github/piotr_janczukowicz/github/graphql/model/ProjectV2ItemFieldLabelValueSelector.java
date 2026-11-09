package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.util.function.Function;

/** Selection of the GraphQL type {@code ProjectV2ItemFieldLabelValue}. */
public interface ProjectV2ItemFieldLabelValueSelector {

    <R> R field(Function<ProjectV2FieldConfigurationSelector, R> selection);

    <R> Page<R> labels(Paging paging, Function<LabelSelector, R> selection);
}
