package io.github.piotr_janczukowicz.github.graphql.model;

import java.time.Instant;
import org.jspecify.annotations.Nullable;

/** Selection of the GraphQL type {@code CheckStep}. */
public interface CheckStepSelector {

    @Nullable Instant completedAt();

    @Nullable CheckConclusionState conclusion();

    @Nullable String externalId();

    String name();

    int number();

    @Nullable Integer secondsToCompletion();

    @Nullable Instant startedAt();

    CheckStatusState status();
}
