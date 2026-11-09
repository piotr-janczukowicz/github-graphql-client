package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorLocationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AuditEntryActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OperationType;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepoConfigEnableCollaboratorsOnlyAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code RepoConfigEnableCollaboratorsOnlyAuditEntry}; used by the generated selection
 * code only.
 */
final class RepoConfigEnableCollaboratorsOnlyAuditEntrySelectorImpl
        implements RepoConfigEnableCollaboratorsOnlyAuditEntrySelector {

    private static final String REMOVAL = "removal";

    private final Cursor cursor;

    RepoConfigEnableCollaboratorsOnlyAuditEntrySelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public String action() {
        return cursor.getRequired("action", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R actor(final Function<AuditEntryActorSelector, R> selection) {
        return cursor.object("actor", child -> selection.apply(new AuditEntryActorSelectorImpl(child)));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String actorIp() {
        return cursor.get("actorIp", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R actorLocation(final Function<ActorLocationSelector, R> selection) {
        return cursor.object("actorLocation", child -> selection.apply(new ActorLocationSelectorImpl(child)));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String actorLogin() {
        return cursor.get("actorLogin", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String actorResourcePath() {
        return cursor.get("actorResourcePath", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String actorUrl() {
        return cursor.get("actorUrl", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable OperationType operationType() {
        return cursor.get("operationType", ScalarType.enumeration(OperationType::fromWire, OperationType.ACCESS));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R organization(final Function<OrganizationSelector, R> selection) {
        return cursor.object("organization", child -> selection.apply(new OrganizationSelectorImpl(child)));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String organizationName() {
        return cursor.get("organizationName", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String organizationResourcePath() {
        return cursor.get("organizationResourcePath", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String organizationUrl() {
        return cursor.get("organizationUrl", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R repository(final Function<RepositorySelector, R> selection) {
        return cursor.object("repository", child -> selection.apply(new RepositorySelectorImpl(child)));
    }

    @Override
    public @Nullable String repositoryName() {
        return cursor.get("repositoryName", ScalarType.STRING);
    }

    @Override
    public @Nullable String repositoryResourcePath() {
        return cursor.get("repositoryResourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable String repositoryUrl() {
        return cursor.get("repositoryUrl", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R user(final Function<UserSelector, R> selection) {
        return cursor.object("user", child -> selection.apply(new UserSelectorImpl(child)));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String userLogin() {
        return cursor.get("userLogin", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String userResourcePath() {
        return cursor.get("userResourcePath", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String userUrl() {
        return cursor.get("userUrl", ScalarType.STRING);
    }
}
