Act as an experienced product manager.

Below is the summary of a brainstorming session for a product called **LifeAPI**. Write a Product Requirements Document (PRD) in Markdown with exactly these sections:

1. Overview
2. Problem Statement
3. Goal / Vision
4. Target Users
5. Key Features (MVP) - a short list, one line each
6. Out of Scope
7. Success Metrics
8. Risks and Assumptions
9. Open Questions

Rules:

- Do not include technical details, architecture, or tech stack.
- Do not write detailed requirements, user stories, or acceptance criteria yet.
- Do not invent features that are not in the summary. If something is unclear or missing, put it under Open Questions instead of guessing.
- Keep it concise: one or two pages at most. Plain language, no marketing fluff.
- Before writing, ask me any clarifying questions you have, one at a time. Once I answer, generate the full document.
- Save the result as `docs/PRD.md`.

## Brainstorming summary

**What we are going to build**

LifeAPI: a personal data aggregation platform that collects, organizes, and exposes data from different aspects of a person's life through a unified API.

The platform brings together information such as developer activity, workouts, screen time, and daily habits into one place.

Data collection follows a hybrid approach: automatic integrations where possible and manual entry when automatic collection is unavailable.

**Vision / goal**

Give individuals a centralized, structured way to access and understand their personal data without switching between multiple applications.

Enable users to explore their activities, track progress over time, and discover patterns across different areas of their lives.

**Problem**

Personal data is scattered across multiple applications and services.

For example:
- Developer activity is stored on GitHub.
- Workout history may be recorded in fitness applications or manually.
- Screen-time information is maintained by devices.
- Daily habits are tracked through separate applications or personal notes.

These systems rarely provide a unified view of an individual's activities.

As a result, users find it difficult to access their complete personal history, compare activities across different areas, and understand long-term patterns.

**Target users**

- Individuals who want to collect and organize their personal activity data.
- Developers who want programmatic access to their personal information.
- People interested in self-tracking, habit monitoring, and personal analytics.

**MVP scope**

- Collect developer activity through GitHub integration.
- Record workouts and fitness activities manually.
- Collect screen-time data where integrations are available.
- Track daily habits through manual entries.
- Store and organize historical activity data.
- Expose personal data through a unified API.
- Retrieve activity records and summaries for specified time periods.

**Out of scope for now**

- Full-featured web dashboard.
- Native mobile application.
- AI-powered recommendations or predictions.
- Social networking and activity sharing.
- Financial tracking.
- Integration with every available personal data provider.
- Advanced analytics and automated coaching.

**Success signal**

Users can consistently collect and retrieve their personal data from multiple sources through one API.

The initial success indicators are:

- Successful integration with GitHub.
- Reliable manual tracking of workouts and habits.
- Consistent storage and retrieval of historical data.
- Ability to access information from multiple life domains through a single API.
- Continued usage of the platform for personal activity tracking.

**Risks and assumptions**

- Some services may not provide accessible APIs for automatic data collection.
- Screen-time integration may depend on operating-system restrictions.
- Manual data entry may become inconvenient over time.
- Personal data requires appropriate privacy and access controls.
- Data from different sources may have inconsistent formats or timestamps.
- The usefulness of the platform depends on maintaining accurate and reasonably complete data.

**Open questions**

- Should LifeAPI initially support only one user or multiple users?
- Which personal data categories should be prioritized for the first release?
- Should users be able to import historical data?
- Should the API support both private and publicly shareable information?
- How frequently should automatic integrations synchronize data?
- Should users be able to define custom activity categories?
- What level of aggregated insights should be included in the MVP?
- Should a simple dashboard be introduced after validating the API-only version?