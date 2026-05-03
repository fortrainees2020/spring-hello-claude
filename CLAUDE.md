# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
mvn compile

# Run the application
mvn exec:java

# Package
mvn package

# Clean build artifacts
mvn clean
```

## Architecture

This is a minimal **Spring Core 6.2.6 / Java 17** project demonstrating XML-based dependency injection — no Spring Boot, no annotations.

**Wiring flow:**
1. `applicationContext.xml` declares the `hello` bean and injects `message` via a `<property>` tag.
2. `App.java` bootstraps the container with `ClassPathXmlApplicationContext`, retrieves the bean by ID, calls `greet()`, then closes the context.
3. `Hello.java` is a plain POJO with a setter — Spring sets `message` at startup via setter injection.

New beans belong in `applicationContext.xml`; new classes belong in `src/main/java/com/example/hello/`.

## GitHub Actions

Two workflows run via `anthropics/claude-code-action@v1`, both requiring the `CLAUDE_CODE_OAUTH_TOKEN` secret.

| Workflow | Trigger | What it does |
|---|---|---|
| `claude.yml` | Issue/PR comment or review containing `@claude` | Claude responds to the comment and acts on instructions |
| `claude-code-review.yml` | PR opened, updated, or reopened | Claude automatically reviews the PR using the `code-review` plugin |

To invoke Claude on a PR or issue, mention `@claude` in a comment.

## Jira Integration

When asked to create a Jira ticket, use the following environment variables (available in CI):

| Variable | Value |
|---|---|
| `JIRA_BASE_URL` | `https://fortrainees2020.atlassian.net` |
| `JIRA_EMAIL` | `ashujauhari@gmail.com` |
| `JIRA_API_TOKEN` | from secret |
| `JIRA_PROJECT_KEY` | `SHC` |
| `JIRA_ASSIGNEE_ID` | `712020:bd497527-a183-4e54-8103-3ccdb5f16337` |

**To create a ticket:**
```bash
curl -s -X POST "$JIRA_BASE_URL/rest/api/3/issue" \
  -u "$JIRA_EMAIL:$JIRA_API_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "fields": {
      "project": { "key": "'"$JIRA_PROJECT_KEY"'" },
      "summary": "<ticket title>",
      "description": {
        "type": "doc", "version": 1,
        "content": [{ "type": "paragraph", "content": [{ "type": "text", "text": "<description>" }] }]
      },
      "issuetype": { "name": "Task" },
      "assignee": { "id": "'"$JIRA_ASSIGNEE_ID"'" }
    }
  }'
```

After creating a ticket, reply with the ticket URL: `$JIRA_BASE_URL/browse/<ISSUE-KEY>`.

## Style
- Follow Pastal colot images
