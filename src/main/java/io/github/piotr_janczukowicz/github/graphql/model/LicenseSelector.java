package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code License}. */
public interface LicenseSelector {

    String body();

    <R> List<R> conditions(Function<LicenseRuleSelector, R> selection);

    @Nullable String description();

    boolean featured();

    boolean hidden();

    String id();

    @Nullable String implementation();

    String key();

    <R> List<R> limitations(Function<LicenseRuleSelector, R> selection);

    String name();

    @Nullable String nickname();

    <R> List<R> permissions(Function<LicenseRuleSelector, R> selection);

    boolean pseudoLicense();

    @Nullable String spdxId();

    @Nullable String url();
}
