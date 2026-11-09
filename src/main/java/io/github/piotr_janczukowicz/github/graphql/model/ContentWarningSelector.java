package io.github.piotr_janczukowicz.github.graphql.model;

import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code ContentWarning}. */
public interface ContentWarningSelector {

    String category();

    @Nullable String customSubCategory();

    @Nullable String subCategory();

    @Nullable String subTitle();

    String title();

    String type();
}
