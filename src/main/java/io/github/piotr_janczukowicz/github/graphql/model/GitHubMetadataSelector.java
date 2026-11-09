package io.github.piotr_janczukowicz.github.graphql.model;

import java.util.List;

/** Selection of the GraphQL type {@code GitHubMetadata}. */
public interface GitHubMetadataSelector {

    String gitHubServicesSha();

    List<String> gitIpAddresses();

    List<String> githubEnterpriseImporterIpAddresses();

    List<String> hookIpAddresses();

    List<String> importerIpAddresses();

    boolean isPasswordAuthenticationVerifiable();

    List<String> pagesIpAddresses();
}
