package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryAffiliation;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryPrivacy;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryVisibility;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.TopicRelatedTopicsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TopicRepositoriesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.TopicSelector;
import io.github.piotr_janczukowicz.github.graphql.model.TopicStargazersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class TopicSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE =
            "{" + "\"id\":\"x\"" + "," + "\"name\":\"x\"" + "," + "\"relatedTopics\":[{\"id\": \"x\"}]" + ","
                    + "\"repositories\":{\"nodes\": [{\"allowUpdateBranch\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"stargazerCount\":1" + ","
                    + "\"stargazers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
                    + "," + "\"viewerHasStarred\":true" + "}";

    private static List<Object> readWithArguments(final TopicSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.id());
        values.add(selector.name());
        values.add(selector.relatedTopics(
                TopicRelatedTopicsFilterBuilder.builder().first(1).build(), TopicSelector::id));
        values.add(selector.repositories(
                Paging.first(1),
                TopicRepositoriesFilterBuilder.builder()
                        .affiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .hasIssuesEnabled(true)
                        .isLocked(true)
                        .orderBy(RepositoryOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(RepositoryOrderField.CREATED_AT)
                                .build())
                        .ownerAffiliations(List.of(RepositoryAffiliation.COLLABORATOR))
                        .privacy(RepositoryPrivacy.PRIVATE)
                        .sponsorableOnly(true)
                        .visibility(RepositoryVisibility.INTERNAL)
                        .build(),
                RepositorySelector::allowUpdateBranch));
        values.add(selector.stargazerCount());
        values.add(selector.stargazers(
                Paging.first(1),
                TopicStargazersFilterBuilder.builder()
                        .orderBy(StarOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(StarOrderField.STARRED_AT)
                                .build())
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.viewerHasStarred());
        return values;
    }

    private static List<Object> readWithoutArguments(final TopicSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.relatedTopics(TopicSelector::id));
        values.add(selector.repositories(Paging.first(1), RepositorySelector::allowUpdateBranch));
        values.add(selector.stargazers(Paging.first(1), UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new TopicSelectorImpl(new RecordingCursor(root)));
        final TopicSelectorImpl selector = new TopicSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        "x",
                        "x",
                        List.of("x"),
                        new Page<>(List.of(true), false, null),
                        1,
                        new Page<>(List.of(true), false, null),
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new TopicSelectorImpl(new RecordingCursor(root)));
        final TopicSelectorImpl selector = new TopicSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        List.of("x"), new Page<>(List.of(true), false, null), new Page<>(List.of(true), false, null));
    }
}
