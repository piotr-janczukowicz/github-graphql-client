package io.github.piotr_janczukowicz.github.graphql.model;

/** Selection of the GraphQL type {@code CodeScanningTool}. */
public interface CodeScanningToolSelector {

    String alertsThreshold();

    String securityAlertsThreshold();

    String tool();
}
