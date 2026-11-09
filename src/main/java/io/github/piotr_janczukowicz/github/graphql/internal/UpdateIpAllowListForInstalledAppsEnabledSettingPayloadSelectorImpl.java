package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.IpAllowListOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.UpdateIpAllowListForInstalledAppsEnabledSettingPayloadSelector;
import java.util.function.Function;
import org.jspecify.annotations.Nullable;

/**
 * Reads and records the fields of {@code UpdateIpAllowListForInstalledAppsEnabledSettingPayload}; used by the generated
 * selection code only.
 */
final class UpdateIpAllowListForInstalledAppsEnabledSettingPayloadSelectorImpl
        implements UpdateIpAllowListForInstalledAppsEnabledSettingPayloadSelector {

    private final Cursor cursor;

    UpdateIpAllowListForInstalledAppsEnabledSettingPayloadSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public @Nullable String clientMutationId() {
        return cursor.get("clientMutationId", ScalarType.STRING);
    }

    @Override
    public <R> @Nullable R owner(final Function<IpAllowListOwnerSelector, R> selection) {
        return cursor.object("owner", child -> selection.apply(new IpAllowListOwnerSelectorImpl(child)));
    }
}
