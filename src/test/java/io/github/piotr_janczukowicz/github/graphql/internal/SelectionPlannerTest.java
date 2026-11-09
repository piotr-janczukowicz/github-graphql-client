package io.github.piotr_janczukowicz.github.graphql.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.github.graphql.CustomPropertyValue;
import io.github.piotr_janczukowicz.github.graphql.Page;
import io.github.piotr_janczukowicz.github.graphql.Paging;
import io.github.piotr_janczukowicz.github.graphql.model.AddCommentPayload;
import io.github.piotr_janczukowicz.github.graphql.model.AddCommentPayloadBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.BotSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueCommentSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueFiltersBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.IssueOrderField;
import io.github.piotr_janczukowicz.github.graphql.model.IssueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.IssueState;
import io.github.piotr_janczukowicz.github.graphql.model.MutationSelector;
import io.github.piotr_janczukowicz.github.graphql.model.OrderDirection;
import io.github.piotr_janczukowicz.github.graphql.model.PullRequestSelector;
import io.github.piotr_janczukowicz.github.graphql.model.QuerySelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryCustomPropertyValueSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilter;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryIssuesFilterBuilder;
import io.github.piotr_janczukowicz.github.graphql.model.RepositoryOwnerSelector;
import io.github.piotr_janczukowicz.github.graphql.model.RepositorySelector;
import io.github.piotr_janczukowicz.github.graphql.model.UserSelector;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

@UnitTest
class SelectionPlannerTest {

    private static final JsonMapper MAPPER = JsonMapper.builder().build();

    record Info(String name, int stars, String owner) {}

    record Disk(Integer usage, String description) {}

    private static JsonNode json(final String text) {
        return MAPPER.readTree(text);
    }

    private static Function<QuerySelector, Info> infoQuery() {
        return query -> query.repository(
                "Hello-World",
                "octocat",
                repository -> new Info(
                        repository.name(),
                        repository.stargazerCount(),
                        repository.owner(RepositoryOwnerSelector::login)));
    }

    @Test
    void plan_shouldCollectFieldsAndNesting_whenTheLambdaReadsNestedFields() {
        final Function<QuerySelector, Info> query = infoQuery();

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertSoftly(softly -> {
            softly.assertThat(document.text())
                    .isEqualTo("query($name:String!,$owner:String!){repository(name:$name,owner:$owner)"
                            + "{name stargazerCount owner{login}}}");
            softly.assertThat(document.variables())
                    .containsEntry("owner", "octocat")
                    .containsEntry("name", "Hello-World");
        });
    }

    @Test
    void plan_shouldFail_whenTheSelectionOfAnObjectReadsNoField() {
        final Function<QuerySelector, String> query =
                selector -> selector.repository("Hello-World", "octocat", repository -> "nothing");

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("selection reads no field");
    }

    @Test
    void plan_shouldFail_whenARequiredArgumentIsNull() {
        final Function<QuerySelector, String> query =
                selector -> selector.repository("Hello-World", null, RepositorySelector::name);

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("owner must not be null");
    }

    @Test
    void plan_shouldFail_whenTheQueryReadsNoField() {
        final Function<QuerySelector, String> query = selector -> "nothing";

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("selection reads no field");
    }

    @Test
    void plan_shouldFail_whenTheSameFieldIsSelectedWithDifferentArguments() {
        final Function<QuerySelector, String> query =
                selector -> selector.repository("x", "a", RepositorySelector::name)
                        + selector.repository("y", "b", RepositorySelector::name);

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("repository")
                .hasMessageContaining("different arguments");
    }

    @Test
    void map_shouldReturnTheUsersType_whenTheResponseHasTheData() {
        final Planned<Info> planned = SelectionPlanner.plan(infoQuery());
        final JsonNode data = json("""
                {"repository":{"name":"Hello-World","stargazerCount":42,"owner":{"login":"octocat"}}}
                """);

        final Info info = planned.map(data);

        assertThat(info).isEqualTo(new Info("Hello-World", 42, "octocat"));
    }

    @Test
    void map_shouldHandNull_whenANullableFieldIsNullInTheResponse() {
        final Planned<Disk> planned = SelectionPlanner.plan(query ->
                query.repository("n", "o", repository -> new Disk(repository.diskUsage(), repository.description())));
        final JsonNode data = json("""
                {"repository":{"diskUsage":null,"description":null}}
                """);

        final Disk disk = planned.map(data);

        assertThat(disk).isEqualTo(new Disk(null, null));
    }

    @Test
    void map_shouldReturnNull_whenTheObjectFieldIsNullInTheResponse() {
        final Planned<String> planned =
                SelectionPlanner.plan(query -> query.repository("n", "o", RepositorySelector::name));
        final JsonNode data = json("{\"repository\":null}");

        final String result = planned.map(data);

        assertThat(result).isNull();
    }

    @Test
    void map_shouldReturnNull_whenTheObjectFieldIsMissingInTheResponse() {
        final Planned<String> planned =
                SelectionPlanner.plan(query -> query.repository("n", "o", RepositorySelector::name));
        final JsonNode data = json("{}");

        final String result = planned.map(data);

        assertThat(result).isNull();
    }

    @Test
    void map_shouldFail_whenANonNullObjectFieldIsNullInTheResponse() {
        final Planned<String> planned = SelectionPlanner.plan(
                query -> query.repository("n", "o", repository -> repository.owner(RepositoryOwnerSelector::login)));
        final JsonNode data = json("{\"repository\":{\"owner\":null}}");

        final Throwable thrown = catchThrowable(() -> planned.map(data));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("query.repository.owner");
    }

    @Test
    void map_shouldFail_whenTheLambdaReadsAFieldTheRecordingPassDidNotSee() {
        final Planned<String> planned = SelectionPlanner.plan(query -> query.repository(
                "n", "o", repository -> repository.name().isEmpty() ? "none" : repository.description()));
        final JsonNode data = json("{\"repository\":{\"name\":\"x\",\"description\":\"d\"}}");

        final Throwable thrown = catchThrowable(() -> planned.map(data));

        assertThat(thrown)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("query.repository.description")
                .hasMessageContaining("branch");
    }

    @Test
    void map_shouldFail_whenANonNullFieldIsMissingInTheResponse() {
        final Planned<String> planned =
                SelectionPlanner.plan(query -> query.repository("n", "o", RepositorySelector::name));
        final JsonNode data = json("{\"repository\":{}}");

        final Throwable thrown = catchThrowable(() -> planned.map(data));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("repository.name");
    }

    @Test
    void plan_shouldRunTheLambdaExactlyTwice_whenTheQueryIsPlannedAndMapped() {
        final AtomicInteger runs = new AtomicInteger();
        final Planned<String> planned = SelectionPlanner.plan(query -> {
            runs.incrementAndGet();
            return query.repository("n", "o", RepositorySelector::name);
        });
        final JsonNode data = json("{\"repository\":{\"name\":\"x\"}}");

        planned.map(data);

        assertThat(runs).hasValue(2);
    }

    private static Function<QuerySelector, Page<String>> titlesPage(final Paging paging) {
        return query -> query.repository("n", "o", repository -> repository.issues(paging, IssueSelector::title));
    }

    @Test
    void plan_shouldAddThePageInfoFields_whenAPageIsSelected() {
        final Function<QuerySelector, Page<String>> query = titlesPage(Paging.first(10));

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertSoftly(softly -> {
            softly.assertThat(document.text())
                    .isEqualTo("query($name:String!,$owner:String!,$first:Int!){repository(name:$name,owner:$owner)"
                            + "{issues(first:$first){nodes{title} pageInfo{hasNextPage endCursor}}}}");
            softly.assertThat(document.variables()).containsEntry("first", 10);
        });
    }

    @Test
    void plan_shouldSendTheCursor_whenThePagingHasOne() {
        final Function<QuerySelector, Page<String>> query =
                titlesPage(Paging.first(10).after("c1"));

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertSoftly(softly -> {
            softly.assertThat(document.text())
                    .contains("issues(first:$first,after:$after)")
                    .contains("$after:String");
            softly.assertThat(document.variables()).containsEntry("after", "c1");
        });
    }

    @Test
    void plan_shouldFail_whenThePagingIsNull() {
        final Paging paging = null;
        final Function<QuerySelector, Page<String>> query = titlesPage(paging);

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("paging must not be null");
    }

    @Test
    void map_shouldReturnAPageWithoutNextAndCursor_whenTheLastPageIsRead() {
        final Planned<Page<String>> planned = SelectionPlanner.plan(titlesPage(Paging.first(10)));
        final JsonNode data = json("""
                {"repository":{"issues":{"nodes":[{"title":"a"}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}
                """);

        final Page<String> page = planned.map(data);

        assertThat(page).isEqualTo(new Page<>(List.of("a"), false, null));
    }

    @Test
    void map_shouldReturnTheCursorAndSkipNullElements_whenThereIsANextPage() {
        final Planned<Page<String>> planned = SelectionPlanner.plan(titlesPage(Paging.first(2)));
        final JsonNode data = json("""
                {"repository":{"issues":{"nodes":[{"title":"a"},null,{"title":"b"}],
                 "pageInfo":{"hasNextPage":true,"endCursor":"c2"}}}}
                """);

        final Page<String> page = planned.map(data);

        assertThat(page).isEqualTo(new Page<>(List.of("a", "b"), true, "c2"));
    }

    @Test
    void map_shouldReturnAnEmptyPage_whenNodesIsEmpty() {
        final Planned<Page<String>> planned = SelectionPlanner.plan(titlesPage(Paging.first(2)));
        final JsonNode data = json("""
                {"repository":{"issues":{"nodes":[],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}
                """);

        final Page<String> page = planned.map(data);

        assertThat(page.items()).isEmpty();
    }

    @Test
    void map_shouldFail_whenTheConnectionIsNullInTheResponse() {
        final Planned<Page<String>> planned = SelectionPlanner.plan(titlesPage(Paging.first(2)));
        final JsonNode data = json("{\"repository\":{\"issues\":null}}");

        final Throwable thrown = catchThrowable(() -> planned.map(data));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("query.repository.issues");
    }

    private static Function<QuerySelector, Page<String>> filteredTitles(
            final List<String> labels, final List<IssueState> states) {
        return query -> query.repository(
                "n",
                "o",
                repository -> repository.issues(
                        Paging.first(10),
                        RepositoryIssuesFilterBuilder.builder()
                                .labels(labels)
                                .states(states)
                                .build(),
                        IssueSelector::title));
    }

    @Test
    void plan_shouldTypeTheListVariables_whenListArgumentsAreGiven() {
        final Function<QuerySelector, Page<String>> query =
                filteredTitles(List.of("bug"), List.of(IssueState.OPEN, IssueState.CLOSED));

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertSoftly(softly -> {
            softly.assertThat(document.text())
                    .contains("$labels:[String!]")
                    .contains("$states:[IssueState!]")
                    .contains("issues(first:$first,labels:$labels,states:$states)");
            softly.assertThat(document.variables())
                    .containsEntry("labels", List.of("bug"))
                    .containsEntry("states", List.of("OPEN", "CLOSED"));
        });
    }

    @Test
    void plan_shouldOmitTheArgument_whenTheListIsNull() {
        final Function<QuerySelector, Page<String>> query = filteredTitles(null, null);

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertSoftly(softly -> {
            softly.assertThat(document.text()).doesNotContain("labels").doesNotContain("states");
            softly.assertThat(document.variables()).doesNotContainKeys("labels", "states");
        });
    }

    @Test
    void plan_shouldSendAnEmptyList_whenTheListIsEmpty() {
        final Function<QuerySelector, Page<String>> query = filteredTitles(List.of(), List.of());

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertThat(document.variables()).containsEntry("labels", List.of()).containsEntry("states", List.of());
    }

    @Test
    void build_shouldFail_whenAListArgumentHasANullElement() {
        final RepositoryIssuesFilterBuilder builder =
                RepositoryIssuesFilterBuilder.builder().labels(Arrays.asList("bug", null));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }

    @Test
    void plan_shouldFail_whenAListArgumentContainsAnUnrecognizedEnum() {
        final Function<QuerySelector, Page<String>> query =
                filteredTitles(null, List.of(IssueState.OPEN, IssueState.UNRECOGNIZED));

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("states");
    }

    @Test
    void plan_shouldReadAScalarListField_whenTheRepositorySelectsItsCommitEmails() {
        final Function<QuerySelector, List<String>> query =
                selector -> selector.repository("n", "o", RepositorySelector::viewerPossibleCommitEmails);

        final Planned<List<String>> planned = SelectionPlanner.plan(query);
        final JsonNode data = json("""
                {"repository":{"viewerPossibleCommitEmails":["a@x.io","b@x.io"]}}
                """);

        final List<String> emails = planned.map(data);

        assertThat(emails).containsExactly("a@x.io", "b@x.io");
    }

    @Test
    void plan_shouldSendTheFilterObjectAndTheOrderAsVariables_whenTheArgumentsHaveThem() {
        final Function<QuerySelector, Page<String>> query = selector -> selector.repository(
                "n",
                "o",
                repository -> repository.issues(
                        Paging.first(10),
                        RepositoryIssuesFilterBuilder.builder()
                                .filterBy(IssueFiltersBuilder.builder()
                                        .assignee("octocat")
                                        .states(List.of(IssueState.OPEN))
                                        .build())
                                .orderBy(IssueOrderBuilder.builder()
                                        .direction(OrderDirection.DESC)
                                        .field(IssueOrderField.CREATED_AT)
                                        .build())
                                .build(),
                        IssueSelector::title));

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertSoftly(softly -> {
            softly.assertThat(document.text())
                    .contains("$filterBy:IssueFilters")
                    .contains("$orderBy:IssueOrder")
                    .contains("issues(first:$first,filterBy:$filterBy,orderBy:$orderBy)");
            softly.assertThat(document.variables())
                    .containsEntry("filterBy", Map.of("assignee", "octocat", "states", List.of("OPEN")))
                    .containsEntry("orderBy", Map.of("direction", "DESC", "field", "CREATED_AT"));
        });
    }

    @Test
    void plan_shouldNotFail_whenTheLambdaRejectsAnUnrecognizedState() {
        final Function<QuerySelector, Page<String>> query = selector -> selector.repository(
                "n",
                "o",
                repository -> repository.issues(Paging.first(10), issue -> switch (issue.state()) {
                    case OPEN, CLOSED -> issue.title();
                    case UNRECOGNIZED -> throw new IllegalStateException("unknown state");
                }));

        final Planned<Page<String>> planned = SelectionPlanner.plan(query);
        final JsonNode data = json("""
                {"repository":{"issues":{"nodes":[{"state":"OPEN","title":"t"}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}
                """);

        final Page<String> page = planned.map(data);

        assertThat(page.items()).containsExactly("t");
    }

    @Test
    void map_shouldFail_whenTheLambdaReadsAFieldTheRecordingPassDidNotSeeBecauseOfTheListSize() {
        final Planned<String> planned = SelectionPlanner.plan(query -> query.repository("n", "o", repository -> {
            final Page<String> page = repository.issues(Paging.first(10), IssueSelector::title);
            return page.items().size() > 1 ? repository.name() : "few";
        }));
        final JsonNode data = json("""
                {"repository":{"issues":{"nodes":[{"title":"a"},{"title":"b"}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}
                """);

        final Throwable thrown = catchThrowable(() -> planned.map(data));

        assertThat(thrown).isInstanceOf(IllegalStateException.class).hasMessageContaining("name");
    }

    private static Function<QuerySelector, Page<String>> pageWith(final RepositoryIssuesFilter arguments) {
        return selector -> selector.repository(
                "n", "o", repository -> repository.issues(Paging.first(10), arguments, IssueSelector::title));
    }

    @Test
    void plan_shouldFail_whenThePageArgumentsAreNull() {
        final RepositoryIssuesFilter arguments = null;
        final Function<QuerySelector, Page<String>> query = pageWith(arguments);

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessage("arguments must not be null");
    }

    @Test
    void plan_shouldReadTheFieldOnce_whenTheSameFieldIsReadWithEqualArguments() {
        final Function<QuerySelector, String> query = selector -> selector.repository("n", "o", repository -> {
            final RepositoryIssuesFilter first = RepositoryIssuesFilterBuilder.builder()
                    .labels(List.of("bug"))
                    .build();
            final RepositoryIssuesFilter second = RepositoryIssuesFilterBuilder.builder()
                    .labels(List.of("bug"))
                    .build();
            return repository
                            .issues(Paging.first(3), first, IssueSelector::title)
                            .items()
                            .size()
                    + ":"
                    + repository
                            .issues(Paging.first(3), second, IssueSelector::number)
                            .items()
                            .size();
        });

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertSoftly(softly -> {
            softly.assertThat(document.text()).containsOnlyOnce("issues(");
            softly.assertThat(document.text()).contains("nodes{title number}");
        });
    }

    @Test
    void plan_shouldFail_whenTheSameFieldIsReadWithDifferentArguments() {
        final Function<QuerySelector, String> query = selector -> selector.repository("n", "o", repository -> {
            final RepositoryIssuesFilter bugs = RepositoryIssuesFilterBuilder.builder()
                    .labels(List.of("bug"))
                    .build();
            final RepositoryIssuesFilter ui = RepositoryIssuesFilterBuilder.builder()
                    .labels(List.of("ui"))
                    .build();
            return repository
                            .issues(Paging.first(3), bugs, IssueSelector::title)
                            .items()
                            .size()
                    + ":"
                    + repository
                            .issues(Paging.first(3), ui, IssueSelector::title)
                            .items()
                            .size();
        });

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("query.repository.issues")
                .hasMessageContaining("different arguments");
    }

    @Test
    void plan_shouldRecordEveryField_whenAllFieldsOfTheFixtureTypesAreRead() {
        final Function<QuerySelector, String> query = selector -> selector.repository(
                "n",
                "o",
                repository -> repository.name()
                        + repository.stargazerCount()
                        + repository.diskUsage()
                        + repository.description()
                        + repository.owner(RepositoryOwnerSelector::login)
                        + repository.issues(
                                Paging.first(5).after("c1"),
                                RepositoryIssuesFilterBuilder.builder()
                                        .labels(List.of("bug"))
                                        .states(List.of(IssueState.OPEN))
                                        .build(),
                                issue -> issue.number() + ":" + issue.title() + issue.state() + issue.createdAt()
                                        + issue.closedAt() + issue.url() + issue.viewerCannotUpdateReasons()));

        final QueryDocument document = SelectionPlanner.plan(query).document();

        assertThat(document.text())
                .isEqualTo("query($name:String!,$owner:String!,$first:Int!,$after:String,$labels:[String!],"
                        + "$states:[IssueState!]){repository(name:$name,owner:$owner){name stargazerCount diskUsage "
                        + "description owner{login} issues(first:$first,after:$after,labels:$labels,states:$states)"
                        + "{nodes{number title state createdAt closedAt url viewerCannotUpdateReasons} "
                        + "pageInfo{hasNextPage endCursor}}}}");
    }

    @Test
    void planMutation_shouldWriteAMutationWithTheInputAsAVariable_whenTheLambdaAddsAComment() {
        final AddCommentPayload input =
                AddCommentPayloadBuilder.builder().body("x").subjectId("I_1").build();

        final Planned<String> planned = SelectionPlanner.planMutation(mutation -> mutation.addComment(
                input, payload -> payload.commentEdge(edge -> edge.node(IssueCommentSelector::id))));

        assertSoftly(softly -> {
            softly.assertThat(planned.document().text())
                    .isEqualTo("mutation($input:AddCommentInput!){addComment(input:$input){commentEdge{node{id}}}}");
            softly.assertThat(planned.document().variables())
                    .containsEntry("input", Map.of("body", "x", "subjectId", "I_1"));
        });
    }

    @Test
    void planMutation_shouldMapTheResponse_whenTheDataHasTheComment() {
        final AddCommentPayload input =
                AddCommentPayloadBuilder.builder().body("x").subjectId("I_1").build();
        final Planned<String> planned = SelectionPlanner.planMutation(mutation -> mutation.addComment(
                input, payload -> payload.commentEdge(edge -> edge.node(IssueCommentSelector::id))));
        final JsonNode data = json("""
                {"addComment":{"commentEdge":{"node":{"id":"IC_9"}}}}
                """);

        final String id = planned.map(data);

        assertThat(id).isEqualTo("IC_9");
    }

    @Test
    void planMutation_shouldFail_whenTheLambdaReadsNoField() {
        final Function<MutationSelector, String> mutation = selector -> "nothing";

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.planMutation(mutation));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("mutation");
    }

    @Test
    void plan_shouldWriteOneFragmentPerBranch_whenAUnionIsReadThroughOn() {
        final Planned<String> planned = SelectionPlanner.plan(query -> query.repository("n", "o", repository -> {
            repository.issueOrPullRequest(7, item -> item.on(IssueSelector.class, IssueSelector::title));
            return repository.issueOrPullRequest(
                    7, item -> item.on(PullRequestSelector.class, pull -> pull.title() + pull.number()));
        }));

        assertThat(planned.document().text())
                .isEqualTo("query($name:String!,$owner:String!,$number:Int!){repository(name:$name,owner:$owner)"
                        + "{issueOrPullRequest(number:$number){__typename ... on Issue{title} ... on PullRequest{title"
                        + " number}}}}");
    }

    @Test
    void map_shouldReturnTheBranchOfTheType_whenTheResponseIsAPullRequest() {
        final Planned<String> planned = SelectionPlanner.plan(query -> query.repository(
                "n",
                "o",
                repository -> repository.issueOrPullRequest(7, item -> {
                    final String issue = item.on(IssueSelector.class, IssueSelector::title);
                    final String pull = item.on(PullRequestSelector.class, PullRequestSelector::title);
                    return issue != null ? "issue " + issue : "pull " + pull;
                })));
        final JsonNode data = json("""
                {"repository":{"issueOrPullRequest":{"__typename":"PullRequest","title":"Fix"}}}
                """);

        final String result = planned.map(data);

        assertThat(result).isEqualTo("pull Fix");
    }

    @Test
    void map_shouldReadTheSharedFieldAndTheBranch_whenTheInterfaceIsAUser() {
        final Planned<String> planned = SelectionPlanner.plan(query -> query.repository(
                "n",
                "o",
                repository -> repository
                        .issues(
                                Paging.first(1),
                                issue -> issue.author(actor -> {
                                    final String name = actor.on(UserSelector.class, UserSelector::name);
                                    return actor.login() + ":" + name;
                                }))
                        .items()
                        .getFirst()));
        final JsonNode data = json("""
                {"repository":{"issues":{"nodes":[{"author":{"__typename":"User","login":"octo","name":"Octo Cat"}}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}
                """);

        final String result = planned.map(data);

        assertThat(result).isEqualTo("octo:Octo Cat");
    }

    @Test
    void plan_shouldRejectAClassThatIsNotAPossibleType_whenTheBranchIsRecorded() {
        final Function<QuerySelector, String> query = selector -> selector.repository(
                "n",
                "o",
                repository ->
                        repository.issueOrPullRequest(7, item -> item.on(UserSelector.class, UserSelector::login)));

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("UserSelector is not a possible type of IssueOrPullRequestSelector");
    }

    @Test
    void plan_shouldRejectAClassThatIsNotASelector_whenTheBranchIsRecorded() {
        final Function<QuerySelector, String> query = selector -> selector.repository(
                "n", "o", repository -> repository.issueOrPullRequest(7, item -> item.on(String.class, text -> text)));

        final Throwable thrown = catchThrowable(() -> SelectionPlanner.plan(query));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("String");
    }

    @Test
    void map_shouldReturnNullFromEveryBranch_whenTheTypeHasNoBranch() {
        final Planned<String> planned = SelectionPlanner.plan(query -> query.repository(
                "n",
                "o",
                repository -> repository
                        .issues(
                                Paging.first(1),
                                issue -> issue.author(actor -> {
                                    final String bot = actor.on(BotSelector.class, BotSelector::login);
                                    final String user = actor.on(UserSelector.class, UserSelector::login);
                                    return bot == null && user == null ? "other" : "known";
                                }))
                        .items()
                        .getFirst()));
        final JsonNode data = json("""
                {"repository":{"issues":{"nodes":[{"author":{"__typename":"Mannequin"}}],
                 "pageInfo":{"hasNextPage":false,"endCursor":null}}}}
                """);

        final String result = planned.map(data);

        assertThat(result).isEqualTo("other");
    }

    @Test
    void map_shouldKeepTheShapeGitHubSent_whenAPropertyValueIsATextOrAList() {
        final Planned<CustomPropertyValue> planned = SelectionPlanner.plan(query -> query.repository(
                "n",
                "o",
                repository -> repository.repositoryCustomPropertyValue(
                        "team", RepositoryCustomPropertyValueSelector::value)));

        final CustomPropertyValue text =
                planned.map(json("{\"repository\":{\"repositoryCustomPropertyValue\":{\"value\":\"core\"}}}"));
        final CustomPropertyValue options =
                planned.map(json("{\"repository\":{\"repositoryCustomPropertyValue\":{\"value\":[\"a\",\"b\"]}}}"));

        assertSoftly(softly -> {
            softly.assertThat(text).isEqualTo(CustomPropertyValue.ofText("core"));
            softly.assertThat(options).isEqualTo(CustomPropertyValue.ofOptions(List.of("a", "b")));
        });
    }
}
