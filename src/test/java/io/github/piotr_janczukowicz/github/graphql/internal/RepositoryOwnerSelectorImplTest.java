package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.OrganizationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryAffiliation;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerAvatarUrlFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerRepositoryFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class RepositoryOwnerSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"avatarUrl\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"login\":\"x\""
            + ","
            + "\"repositories\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"url\":\"x\"" + "," + "\"anyPinnableItems\":true" + "," + "\"__typename\":\"Organization\"" + "}";

    private static List<Object> readWithArguments(final RepositoryOwnerSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl(
                RepositoryOwnerAvatarUrlFilterBuilder.builder().size(1).build()));
        values.add(selector.id());
        values.add(selector.login());
        values.add(selector.repositories(
                Paging.first(1),
                RepositoryOwnerRepositoriesFilterBuilder.builder()
                        .affiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .hasIssuesEnabled(true)
                        .isArchived(true)
                        .isFork(true)
                        .isLocked(true)
                        .orderBy(RepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryOrderField.CREATED_AT)
                                .build())
                        .ownerAffiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .privacy(RepositoryPrivacy.PRIVATE)
                        .visibility(RepositoryVisibility.INTERNAL)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.repository(
                "x",
                RepositoryOwnerRepositoryFilterBuilder.builder()
                        .followRenames(true)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.url());
        values.add(selector.on(OrganizationSelector.class, OrganizationSelector::anyPinnableItems));
        return values;
    }

    private static List<Object> readWithoutArguments(final RepositoryOwnerSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.avatarUrl());
        values.add(selector.repositories(Paging.first(1), RepositorySelector::allowUpdateBranch));
        values.add(selector.repository("x", RepositorySelector::allowUpdateBranch));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new RepositoryOwnerSelectorImpl(new RecordingCursor(root)));
        final RepositoryOwnerSelectorImpl selector =
                new RepositoryOwnerSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values).containsExactly("x", "x", "x", new Page<>(List.of(true), false, null), true, "x", "x", true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new RepositoryOwnerSelectorImpl(new RecordingCursor(root)));
        final RepositoryOwnerSelectorImpl selector =
                new RepositoryOwnerSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values).containsExactly("x", new Page<>(List.of(true), false, null), true);
    }
}
