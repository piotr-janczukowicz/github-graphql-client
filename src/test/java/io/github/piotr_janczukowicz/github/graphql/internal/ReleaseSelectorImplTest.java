package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.CommitSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionContent;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionGroupSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.ReactionSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RefSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseAssetSelector;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseReactionsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseReleaseAssetsFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.ReleaseShortDescriptionHTMLFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ReleaseSelectorImplTest {

    private static final String VALUE_2024_05_01_T10_15_30_Z = "2024-05-01T10:15:30Z";

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"author\":{\"anyPinnableItems\": true}" + ","
            + "\"createdAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"databaseId\":1" + "," + "\"description\":\"x\"" + ","
            + "\"descriptionHTML\":\"x\"" + "," + "\"id\":\"x\"" + "," + "\"immutable\":true" + "," + "\"isDraft\":true"
            + "," + "\"isLatest\":true" + "," + "\"isPrerelease\":true" + ","
            + "\"mentions\":{\"nodes\": [{\"anyPinnableItems\": true}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"name\":\"x\"" + "," + "\"publishedAt\":\"2024-05-01T10:15:30Z\"" + ","
            + "\"reactionGroups\":[{\"content\": \"CONFUSED\"}]" + ","
            + "\"reactions\":{\"nodes\": [{\"content\": \"CONFUSED\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + ","
            + "\"releaseAssets\":{\"nodes\": [{\"contentType\": \"x\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "," + "\"repository\":{\"allowUpdateBranch\": true}" + "," + "\"resourcePath\":\"x\"" + ","
            + "\"shortDescriptionHTML\":\"x\"" + "," + "\"tag\":{\"id\": \"x\"}" + ","
            + "\"tagCommit\":{\"abbreviatedOid\": \"x\"}" + "," + "\"tagName\":\"x\"" + ","
            + "\"updatedAt\":\"2024-05-01T10:15:30Z\"" + "," + "\"url\":\"x\"" + "," + "\"viewerCanReact\":true" + "}";

    private static List<Object> readWithArguments(final ReleaseSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.author(UserSelector::anyPinnableItems));
        values.add(selector.createdAt());
        values.add(selector.databaseId());
        values.add(selector.description());
        values.add(selector.descriptionHTML());
        values.add(selector.id());
        values.add(selector.immutable());
        values.add(selector.isDraft());
        values.add(selector.isLatest());
        values.add(selector.isPrerelease());
        values.add(selector.mentions(Paging.first(1), UserSelector::anyPinnableItems));
        values.add(selector.name());
        values.add(selector.publishedAt());
        values.add(selector.reactionGroups(ReactionGroupSelector::content));
        values.add(selector.reactions(
                Paging.first(1),
                ReleaseReactionsFilterBuilder.builder()
                        .content(ReactionContent.CONFUSED)
                        .orderBy(ReactionOrderBuilder.builder()
                                .direction(OrderDirection.ASC)
                                .field(ReactionOrderField.CREATED_AT)
                                .build())
                        .build(),
                ReactionSelector::content));
        values.add(selector.releaseAssets(
                Paging.first(1),
                ReleaseReleaseAssetsFilterBuilder.builder().name("x").build(),
                ReleaseAssetSelector::contentType));
        values.add(selector.repository(RepositorySelector::allowUpdateBranch));
        values.add(selector.resourcePath());
        values.add(selector.shortDescriptionHTML(
                ReleaseShortDescriptionHTMLFilterBuilder.builder().limit(1).build()));
        values.add(selector.tag(RefSelector::id));
        values.add(selector.tagCommit(CommitSelector::abbreviatedOid));
        values.add(selector.tagName());
        values.add(selector.updatedAt());
        values.add(selector.url());
        values.add(selector.viewerCanReact());
        return values;
    }

    private static List<Object> readWithoutArguments(final ReleaseSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.reactions(Paging.first(1), ReactionSelector::content));
        values.add(selector.releaseAssets(Paging.first(1), ReleaseAssetSelector::contentType));
        values.add(selector.shortDescriptionHTML());
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ReleaseSelectorImpl(new RecordingCursor(root)));
        final ReleaseSelectorImpl selector =
                new ReleaseSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(
                        true,
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        1,
                        "x",
                        "x",
                        "x",
                        true,
                        true,
                        true,
                        true,
                        new Page<>(List.of(true), false, null),
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        List.of(ReactionContent.CONFUSED),
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        new Page<>(List.of("x"), false, null),
                        true,
                        "x",
                        "x",
                        "x",
                        "x",
                        "x",
                        Instant.parse(VALUE_2024_05_01_T10_15_30_Z),
                        "x",
                        true);
    }

    @Test
    void read_shouldMapTheShortForms_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithoutArguments(new ReleaseSelectorImpl(new RecordingCursor(root)));
        final ReleaseSelectorImpl selector =
                new ReleaseSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithoutArguments(selector);

        assertThat(values)
                .containsExactly(
                        new Page<>(List.of(ReactionContent.CONFUSED), false, null),
                        new Page<>(List.of("x"), false, null),
                        "x");
    }
}
