package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class FieldSelectionTest {

    @Test
    void select_shouldReturnTheSameSelection_whenTheFieldIsSelectedAgainWithTheSameArguments() {
        final FieldSelection root = FieldSelection.root();
        final List<Argument> arguments = List.of(Argument.of("id", "ID!", "1"));
        final FieldSelection first = root.select("node", arguments);

        final FieldSelection second = root.select("node", arguments);

        assertThat(second).isSameAs(first);
    }

    @Test
    void select_shouldNameThePathOfTheField_whenItIsNested() {
        final FieldSelection root = FieldSelection.root();
        final FieldSelection repository = root.select("repository", List.of());

        final FieldSelection name = repository.select("name", List.of());

        assertThat(name.path()).isEqualTo("query.repository.name");
    }
}
