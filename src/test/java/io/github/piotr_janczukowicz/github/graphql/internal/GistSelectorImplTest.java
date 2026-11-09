package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommentAuthorAssociation;
import io.github.piotr_janczukowicz.github.graphql.model.GistCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistFileSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistFilesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.GistForksFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.GistOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.GistOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.github.graphql.model.GistStargazersFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.StarOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class GistSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{"
            + "\"comments\":{\"nodes\": [{\"authorAssociation\": \"COLLABORATOR\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"description\":\"x\"" + ","
            + "\"files\":[{\"encodedName\": \"x\"}]" + ","
            + "\"forks\":{\"nodes\": [{\"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"id\":\"x\"" + "," + "\"isFork\":true" + "," + "\"isPublic\":true" + "," + "\"name\":\"x\"" + ","
            + "\"owner\":{\"avatarUrl\": \"x\"}" + "," + "\"pushedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"resourcePath\":\"x\"" + "," + "\"stargazerCount\":1" + ","
            + "\"stargazers\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "," + "\"viewerHasStarred\":true"
            + "}";

    private static List<Object> readWithArguments(final GistSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.comments(Paging.first(1), GistCommentSelector::authorAssociation));
        values.add(selector.createdAt());
        values.add(selector.description());
        values.add(selector.files(
                GistFilesFilterBuilder.builder().limit(1).oid("x").build(), GistFileSelector::encodedName));
        values.add(selector.forks(
                Paging.first(1),
                GistForksFilterBuilder.builder()
                        .orderBy(GistOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(GistOrderField.CREATED_AT)
                                .build())
                        .build(),
                GistSelector::createdAt));
        values.add(selector.id());
        values.add(selector.isFork());
        values.add(selector.isPublic());
        values.add(selector.name());
        values.add(selector.owner(RepositoryOwnerSelector::avatarUrl));
        values.add(selector.pushedAt());
        values.add(selector.resourcePath());
        values.add(selector.stargazerCount());
        values.add(selector.stargazers(
                Paging.first(1),
                GistStargazersFilterBuilder.builder()
                        .orderBy(StarOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(StarOrderField.STARRED_AT)
                                .build())
                        .build(),
                UserSelector::anyPinnableItems));
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.viewerHasStarred());
        return values;
    }

    private static List<Object> readWithoutArguments(final GistSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.files(GistFileSelector::encodedName));
        values.add(selector.forks(Paging.first(1), GistSelector::createdAt));
        values.add(selector.stargazers(Paging.first(1), UserSelector::anyPinnableItems));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new GistSelectorImpl(new RecordingCursor(root)));
        final GistSelectorImpl selector = new GistSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(CommentAuthorAssociation.COLLABORATOR), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        List.of("x"),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        "x",
                        true,
                        true,
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        1,
                        new Page<>(List.of(true), false, null),
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new GistSelectorImpl(new RecordingCursor(root)));
        final GistSelectorImpl selector = new GistSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        List.of("x"),
                        new Page<>(List.of(Instant.parse(VALUE_2024_05_01_T10_15_30_Z)), false, null),
                        new Page<>(List.of(true), false, null));
    }
}
