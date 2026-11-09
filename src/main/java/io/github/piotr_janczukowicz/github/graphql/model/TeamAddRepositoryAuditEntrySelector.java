package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code TeamAddRepositoryAuditEntry}. */
public interface TeamAddRepositoryAuditEntrySelector {

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    String action();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> @Nullable R actor(Function<AuditEntryActorSelector, R> selection);

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String actorIp();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> @Nullable R actorLocation(Function<ActorLocationSelector, R> selection);

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String actorLogin();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String actorResourcePath();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String actorUrl();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    Instant createdAt();

    String id();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable Boolean isLdapMapped();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable OperationType operationType();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> @Nullable R organization(Function<OrganizationSelector, R> selection);

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String organizationName();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String organizationResourcePath();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String organizationUrl();

    <R> @Nullable R repository(Function<RepositorySelector, R> selection);

    @Nullable String repositoryName();

    @Nullable String repositoryResourcePath();

    @Nullable String repositoryUrl();

    <R> @Nullable R team(Function<TeamSelector, R> selection);

    @Nullable String teamName();

    @Nullable String teamResourcePath();

    @Nullable String teamUrl();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    <R> @Nullable R user(Function<UserSelector, R> selection);

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String userLogin();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String userResourcePath();

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Deprecated(forRemoval = true)
    @Nullable String userUrl();
}
