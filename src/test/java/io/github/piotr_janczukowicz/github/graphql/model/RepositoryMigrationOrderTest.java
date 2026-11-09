package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryMigrationOrderTest {

    @Test
    void constructor_shouldFail_whenDirectionIsNull() {
        final RepositoryMigrationOrderBuilder builder =
                RepositoryMigrationOrderBuilder.builder().field(RepositoryMigrationOrderField.CREATED_AT);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("direction must not be null");
    }

    @Test
    void constructor_shouldFail_whenFieldIsNull() {
        final RepositoryMigrationOrderBuilder builder =
                RepositoryMigrationOrderBuilder.builder().direction(RepositoryMigrationOrderDirection.ASC);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("field must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RepositoryMigrationOrder input = RepositoryMigrationOrderBuilder.builder()
                .direction(RepositoryMigrationOrderDirection.ASC)
                .field(RepositoryMigrationOrderField.CREATED_AT)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("direction", "ASC"), entry("field", "CREATED_AT"));
    }
}
