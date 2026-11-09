package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.GistSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class ProfileItemShowcaseSelectorImplTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    private static final String RESPONSE = "{" + "\"hasPinnedItems\":true" + ","
            + "\"items\":{\"nodes\": [{\"__typename\": \"Gist\", \"createdAt\": \"2024-05-01T10:15:30Z\"}], \"pageInfo\": {\"hasNextPage\": false, \"endCursor\": null}}"
            + "}";

    private static List<Object> readWithArguments(final ProfileItemShowcaseSelectorImpl selector) {
        final List<Object> values = new ArrayList<>();
        values.add(selector.hasPinnedItems());
        values.add(selector.items(Paging.first(1), child -> child.on(GistSelector.class, GistSelector::createdAt)));
        return values;
    }

    @Test
    void read_shouldMapEveryField_whenTheResponseHasAllValues() {
        final FieldSelection root = FieldSelection.root();
        readWithArguments(new ProfileItemShowcaseSelectorImpl(new RecordingCursor(root)));
        final ProfileItemShowcaseSelectorImpl selector =
                new ProfileItemShowcaseSelectorImpl(new MappingCursor(MAPPER.readTree(RESPONSE), root));

        final List<Object> values = readWithArguments(selector);

        assertThat(values)
                .containsExactly(true, new Page<>(List.of(Instant.parse("2024-05-01T10:15:30Z")), false, null));
    }
}
