package io.github.piotr_janczukowicz.github.graphql.internal;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamAssignedOrganizationsFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamAssignedOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamEnterpriseTeamMembersFilter;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamEnterpriseTeamMembersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamOrganizationSelectionType;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseTeamSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TeamNotificationSetting;
import io.github.piotr_janczukowicz.github.graphql.model.TeamPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import java.math.BigInteger;
import java.time.Instant;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/** Reads and records the fields of {@code EnterpriseTeam}; used by the generated selection code only. */
final class EnterpriseTeamSelectorImpl implements EnterpriseTeamSelector {

    private static final String STRING = "String";

    private final Cursor cursor;

    EnterpriseTeamSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public <R> Page<R> assignedOrganizations(
            final Paging paging,
            final EnterpriseTeamAssignedOrganizationsFilter arguments,
            final Function<OrganizationSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "assignedOrganizations",
                child -> selection.apply(new OrganizationSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "EnterpriseTeamOrganizationOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()));
    }

    @Override
    public <R> Page<R> assignedOrganizations(final Paging paging, final Function<OrganizationSelector, R> selection) {
        return assignedOrganizations(
                paging,
                EnterpriseTeamAssignedOrganizationsFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public String combinedSlug() {
        return cursor.getRequired("combinedSlug", ScalarType.STRING);
    }

    @Override
    public Instant createdAt() {
        return cursor.getRequired("createdAt", ScalarType.INSTANT);
    }

    @Override
    public @Nullable String description() {
        return cursor.get("description", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R enterprise(final Function<EnterpriseSelector, R> selection) {
        return cursor.object("enterprise", child -> selection.apply(new EnterpriseSelectorImpl(child)));
    }

    @Override
    public <R> Page<R> enterpriseTeamMembers(
            final Paging paging,
            final EnterpriseTeamEnterpriseTeamMembersFilter arguments,
            final Function<UserSelector, R> selection) {
        requireNonNull(paging, "paging");
        requireNonNull(arguments, "arguments");
        return cursor.pageRequired(
                "enterpriseTeamMembers",
                child -> selection.apply(new UserSelectorImpl(child)),
                Argument.of("first", "Int!", paging.first()),
                Argument.of("after", STRING, paging.after()),
                Argument.of(
                        "orderBy",
                        "EnterpriseTeamMemberOrder",
                        arguments.orderBy() == null ? null : arguments.orderBy().toVariable()),
                Argument.of("query", STRING, arguments.query()));
    }

    @Override
    public <R> Page<R> enterpriseTeamMembers(final Paging paging, final Function<UserSelector, R> selection) {
        return enterpriseTeamMembers(
                paging,
                EnterpriseTeamEnterpriseTeamMembersFilterBuilder.builder().build(),
                selection);
    }

    @Override
    public @Nullable BigInteger fullDatabaseId() {
        return cursor.get("fullDatabaseId", ScalarType.BIG_INTEGER);
    }

    @Override
    public String id() {
        return cursor.getRequired("id", ScalarType.STRING);
    }

    @Override
    public boolean isViewerMember() {
        return cursor.getRequired("isViewerMember", ScalarType.BOOLEAN);
    }

    @Override
    public String name() {
        return cursor.getRequired("name", ScalarType.STRING);
    }

    @Override
    public TeamNotificationSetting notificationSetting() {
        return cursor.getRequired(
                "notificationSetting",
                ScalarType.enumeration(
                        TeamNotificationSetting::fromWire, TeamNotificationSetting.NOTIFICATIONS_DISABLED));
    }

    @Override
    public EnterpriseTeamOrganizationSelectionType organizationSelectionType() {
        return cursor.getRequired(
                "organizationSelectionType",
                ScalarType.enumeration(
                        EnterpriseTeamOrganizationSelectionType::fromWire,
                        EnterpriseTeamOrganizationSelectionType.ALL));
    }

    @Override
    public TeamPrivacy privacy() {
        return cursor.getRequired("privacy", ScalarType.enumeration(TeamPrivacy::fromWire, TeamPrivacy.SECRET));
    }

    @Override
    public String slug() {
        return cursor.getRequired("slug", ScalarType.STRING);
    }

    @Override
    public Instant updatedAt() {
        return cursor.getRequired("updatedAt", ScalarType.INSTANT);
    }

    @Override
    public boolean viewerCanAdminister() {
        return cursor.getRequired("viewerCanAdminister", ScalarType.BOOLEAN);
    }
}
