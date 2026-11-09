package io.github.piotr_janczukowicz.github.graphql.model;

import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.util.ListUtils;
import java.util.List;
import org.jspecify.annotations.Nullable;

/** The optional arguments of {@code Commit.deployments}; an argument left {@code null} is not sent. */
@RecordBuilder
public record CommitDeploymentsFilter(
        @Nullable List<String> environments, @Nullable DeploymentOrder orderBy) {

    public CommitDeploymentsFilter {
        environments = ListUtils.copyOrNull(environments);
    }
}
