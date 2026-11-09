package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class RepositoryInvitationOrderTest {

    @Test
    void constructor_shouldFail_whenDirectionIsNull() {
        final RepositoryInvitationOrderBuilder builder =
                RepositoryInvitationOrderBuilder.builder().field(RepositoryInvitationOrderField.CREATED_AT);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("direction must not be null");
    }

    @Test
    void constructor_shouldFail_whenFieldIsNull() {
        final RepositoryInvitationOrderBuilder builder =
                RepositoryInvitationOrderBuilder.builder().direction(OrderDirection.ASC);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("field must not be null");
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final RepositoryInvitationOrder input = RepositoryInvitationOrderBuilder.builder()
                .direction(OrderDirection.ASC)
                .field(RepositoryInvitationOrderField.CREATED_AT)
                .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("direction", "ASC"), entry("field", "CREATED_AT"));
    }
}
