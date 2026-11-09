package io.github.piotr_janczukowicz.github.graphql.internal;

import io.github.piotr_janczukowicz.github.graphql.model.GitHubMetadataSelector;
import java.util.List;

/** Reads and records the fields of {@code GitHubMetadata}; used by the generated selection code only. */
final class GitHubMetadataSelectorImpl implements GitHubMetadataSelector {

    private final Cursor cursor;

    GitHubMetadataSelectorImpl(final Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public String gitHubServicesSha() {
        return cursor.getRequired("gitHubServicesSha", ScalarType.STRING);
    }

    @Override
    public List<String> gitIpAddresses() {
        return cursor.scalarList("gitIpAddresses", ScalarType.STRING);
    }

    @Override
    public List<String> githubEnterpriseImporterIpAddresses() {
        return cursor.scalarList("githubEnterpriseImporterIpAddresses", ScalarType.STRING);
    }

    @Override
    public List<String> hookIpAddresses() {
        return cursor.scalarList("hookIpAddresses", ScalarType.STRING);
    }

    @Override
    public List<String> importerIpAddresses() {
        return cursor.scalarList("importerIpAddresses", ScalarType.STRING);
    }

    @Override
    public boolean isPasswordAuthenticationVerifiable() {
        return cursor.getRequired("isPasswordAuthenticationVerifiable", ScalarType.BOOLEAN);
    }

    @Override
    public List<String> pagesIpAddresses() {
        return cursor.scalarList("pagesIpAddresses", ScalarType.STRING);
    }
}
