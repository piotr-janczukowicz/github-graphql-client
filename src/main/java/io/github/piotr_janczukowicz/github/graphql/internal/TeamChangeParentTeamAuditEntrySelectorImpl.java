package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.ActorLocationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.AuditEntryActorSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OperationType;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamChangeParentTeamAuditEntrySelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code TeamChangeParentTeamAuditEntry}; used by the generated selection code only.
 */
final class TeamChangeParentTeamAuditEntrySelectorImpl implements TeamChangeParentTeamAuditEntrySelector {

    private static final String REMOVAL = "removal";

    private final Cursor cursor;

    TeamChangeParentTeamAuditEntrySelectorImpl(final Cursor cursor) {
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
    public @Nullable Boolean isLdapMapped() {
        return cursor.get("isLdapMapped", ScalarType.BOOLEAN);
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

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R parentTeam(final Function<TeamSelector, R> selection) {
        return cursor.object("parentTeam", child -> selection.apply(new TeamSelectorImpl(child)));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String parentTeamName() {
        return cursor.get("parentTeamName", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String parentTeamNameWas() {
        return cursor.get("parentTeamNameWas", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String parentTeamResourcePath() {
        return cursor.get("parentTeamResourcePath", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String parentTeamUrl() {
        return cursor.get("parentTeamUrl", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public <R> @Nullable R parentTeamWas(final Function<TeamSelector, R> selection) {
        return cursor.object("parentTeamWas", child -> selection.apply(new TeamSelectorImpl(child)));
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String parentTeamWasResourcePath() {
        return cursor.get("parentTeamWasResourcePath", ScalarType.STRING);
    }

    /** @deprecated The GraphQL audit-log is deprecated. Please use the REST API instead. Removal on 2026-04-01 UTC. */
    @Override
    @Deprecated(forRemoval = true)
    @SuppressWarnings(REMOVAL)
    public @Nullable String parentTeamWasUrl() {
        return cursor.get("parentTeamWasUrl", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R team(final Function<TeamSelector, R> selection) {
        return cursor.object("team", child -> selection.apply(new TeamSelectorImpl(child)));
    }

    @Override
    public @Nullable String teamName() {
        return cursor.get("teamName", ScalarType.STRING);
    }

    @Override
    public @Nullable String teamResourcePath() {
        return cursor.get("teamResourcePath", ScalarType.STRING);
    }

    @Override
    public @Nullable String teamUrl() {
        return cursor.get("teamUrl", ScalarType.STRING);
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
