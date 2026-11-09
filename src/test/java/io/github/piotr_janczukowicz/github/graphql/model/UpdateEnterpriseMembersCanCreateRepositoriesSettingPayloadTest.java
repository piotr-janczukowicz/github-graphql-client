package io.github.piotr_janczukowicz.github.graphql.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class UpdateEnterpriseMembersCanCreateRepositoriesSettingPayloadTest {

    @Test
    void constructor_shouldFail_whenEnterpriseIdIsNull() {
        final UpdateEnterpriseMembersCanCreateRepositoriesSettingPayloadBuilder builder =
                UpdateEnterpriseMembersCanCreateRepositoriesSettingPayloadBuilder.builder();

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("enterpriseId must not be null");
    }

    @Test
    void toVariable_shouldContainOnlyTheRequiredFields_whenNothingElseIsSet() {
        final UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload input =
                UpdateEnterpriseMembersCanCreateRepositoriesSettingPayloadBuilder.builder()
                        .enterpriseId("x")
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable).containsExactly(entry("enterpriseId", "x"));
    }

    @Test
    void toVariable_shouldContainEveryField_whenAllAreSet() {
        final UpdateEnterpriseMembersCanCreateRepositoriesSettingPayload input =
                UpdateEnterpriseMembersCanCreateRepositoriesSettingPayloadBuilder.builder()
                        .clientMutationId("x")
                        .enterpriseId("x")
                        .membersCanCreateInternalRepositories(true)
                        .membersCanCreatePrivateRepositories(true)
                        .membersCanCreatePublicRepositories(true)
                        .membersCanCreateRepositoriesPolicyEnabled(true)
                        .settingValue(EnterpriseMembersCanCreateRepositoriesSettingValue.ALL)
                        .build();

        final Map<String, Object> variable = input.toVariable();

        assertThat(variable)
                .containsExactly(
                        entry("clientMutationId", "x"),
                        entry("enterpriseId", "x"),
                        entry("membersCanCreateInternalRepositories", true),
                        entry("membersCanCreatePrivateRepositories", true),
                        entry("membersCanCreatePublicRepositories", true),
                        entry("membersCanCreateRepositoriesPolicyEnabled", true),
                        entry("settingValue", "ALL"));
    }
}
