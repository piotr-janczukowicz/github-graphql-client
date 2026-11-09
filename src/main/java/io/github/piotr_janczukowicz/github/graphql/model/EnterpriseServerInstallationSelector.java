package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;

/** Selection of the GraphQL type {@code EnterpriseServerInstallation}. */
public interface EnterpriseServerInstallationSelector {

    Instant createdAt();

    String customerName();

    String hostName();

    String id();

    boolean isConnected();

    Instant updatedAt();

    <R> Page<R> userAccounts(
            Paging paging,
            EnterpriseServerInstallationUserAccountsFilter arguments,
            Function<EnterpriseServerUserAccountSelector, R> selection);

    <R> Page<R> userAccounts(Paging paging, Function<EnterpriseServerUserAccountSelector, R> selection);

    <R> Page<R> userAccountsUploads(
            Paging paging,
            EnterpriseServerInstallationUserAccountsUploadsFilter arguments,
            Function<EnterpriseServerUserAccountsUploadSelector, R> selection);

    <R> Page<R> userAccountsUploads(Paging paging, Function<EnterpriseServerUserAccountsUploadSelector, R> selection);
}
