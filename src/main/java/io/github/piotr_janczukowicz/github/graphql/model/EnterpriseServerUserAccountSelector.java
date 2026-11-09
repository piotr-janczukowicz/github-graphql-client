package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code EnterpriseServerUserAccount}. */
public interface EnterpriseServerUserAccountSelector {

    Instant createdAt();

    <R> Page<R> emails(
            Paging paging,
            EnterpriseServerUserAccountEmailsFilter arguments,
            Function<EnterpriseServerUserAccountEmailSelector, R> selection);

    <R> Page<R> emails(Paging paging, Function<EnterpriseServerUserAccountEmailSelector, R> selection);

    <R> R enterpriseServerInstallation(Function<EnterpriseServerInstallationSelector, R> selection);

    String id();

    boolean isSiteAdmin();

    String login();

    @Nullable String profileName();

    Instant remoteCreatedAt();

    int remoteUserId();

    Instant updatedAt();
}
