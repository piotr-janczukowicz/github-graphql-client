package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseServerInstallationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountEnterpriseInstallationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountMembershipRole;
import io.github.piotr_janczukowicz.github.graphql.model.EnterpriseUserAccountOrganizationsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class EnterpriseUserAccountSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"avatarUrl\":\"x\"" + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\""
            + "," + "\"enterprise\":{\"avatarUrl\": \"x\"}" + ","
            + "\"enterpriseInstallations\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"login\":\"x\"" + "," + "\"name\":\"x\"" + ","
            + "\"organizations\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"resourcePath\":\"x\"" + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\""
            + "," + "\"user\":{\"anyPinnableItems\": true}" + "}";

    private static List<Object> readWithArguments(final EnterpriseUserAccountSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl(
                EnterpriseUserAccountAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.createdAt());
        values.add(selector.enterprise(EnterpriseSelector::avatarUrl));
        values.add(selector.enterpriseInstallations(
                Paging.first(1),
                EnterpriseUserAccountEnterpriseInstallationsFilterBuilder.builder()
                        .orderBy(EnterpriseServerInstallationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(EnterpriseServerInstallationOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .role(EnterpriseUserAccountMembershipRole.MEMBER)
                        .build(),
                EnterpriseServerInstallationSelector::createdAt));
        values.add(selector.id());
        values.add(selector.login());
        values.add(selector.name());
        values.add(selector.organizations(
                Paging.first(1),
                EnterpriseUserAccountOrganizationsFilterBuilder.builder()
                        .orderBy(OrganizationOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(OrganizationOrderField.CREATED_AT)
                                .build())
                        .query("x")
                        .role(EnterpriseUserAccountMembershipRole.MEMBER)
                        .build(),
                OrganizationSelector::anyPinnableItems));
        values.add(selector.resourcePath());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.user(UserSelector::anyPinnableItems));
        return values;
    }

    private static List<Object> readWithoutArguments(final EnterpriseUserAccountSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        values.add(selector.enterpriseInstallations(Paging.first(1), EnterpriseServerInstallationSelector::createdAt));
        values.add(selector.organizations(Paging.first(1), OrganizationSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new EnterpriseUserAccountSelectorImpl(new RecordingCursor(root)));
        final EnterpriseUserAccountSelectorImpl selector =
                new EnterpriseUserAccountSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        "x",
                        "x",
                        new Page<>(List.of(true), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new EnterpriseUserAccountSelectorImpl(new RecordingCursor(root)));
        final EnterpriseUserAccountSelectorImpl selector =
                new EnterpriseUserAccountSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null));
    }
}
