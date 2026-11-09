package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;

/** Selection of the GraphQL type {@code EnterpriseServerUserAccountsUpload}. */
public interface EnterpriseServerUserAccountsUploadSelector {

    Instant createdAt();

    <R> R enterprise(Function<EnterpriseSelector, R> selection);

    <R> R enterpriseServerInstallation(Function<EnterpriseServerInstallationSelector, R> selection);

    String id();

    String name();

    EnterpriseServerUserAccountsUploadSyncState syncState();

    Instant updatedAt();
}
