# LifeAPI — Product Requirements Document

## 1. Overview

LifeAPI is a personal data aggregation platform for individual, personal use. It collects information from different areas of a person's life — developer activity, workouts, screen time, and daily habits — and organizes it in one place, exposed through a unified API. Collection follows a hybrid approach: automatic integrations where possible, and manual entry when automatic collection is unavailable.

## 2. Problem Statement

Personal data is scattered across multiple applications and services. Developer activity lives on GitHub, workout history may be recorded in fitness applications or by hand, screen-time information is maintained by devices, and daily habits are tracked in separate apps or personal notes. These systems rarely provide a unified view. As a result, users find it difficult to access their complete personal history, compare activities across different areas, and understand long-term patterns.

## 3. Goal / Vision

Give individuals a centralized, structured way to access and understand their personal data without switching between multiple applications. Enable users to explore their activities, track progress over time, and discover patterns across different areas of their lives.

## 4. Target Users

- The individual user (single person, personal use) who wants to collect and organize their own personal activity data.
- Developers who want programmatic access to their personal information.
- People interested in self-tracking, habit monitoring, and personal analytics.

## 5. Key Features (MVP)

- Collect developer activity through GitHub integration.
- Record workouts and fitness activities manually.
- Collect screen-time data where integrations are available.
- Track daily habits through manual entries.
- Store and organize historical activity data.
- Expose personal data through a unified API.
- Retrieve activity records and summaries for specified time periods.

## 6. Out of Scope

- Full-featured web dashboard.
- Native mobile application.
- AI-powered recommendations or predictions.
- Social networking and activity sharing.
- Financial tracking.
- Integration with every available personal data provider.
- Advanced analytics and automated coaching.

## 7. Success Metrics

The core success signal is that users can consistently collect and retrieve their personal data from multiple sources through one API. Initial indicators:

- Successful integration with GitHub.
- Reliable manual tracking of workouts and habits.
- Consistent storage and retrieval of historical data.
- Ability to access information from multiple life domains through a single API.
- Continued usage of the platform for personal activity tracking.

No numeric targets have been defined yet.

## 8. Risks and Assumptions

Risks:

- Some services may not provide accessible APIs for automatic data collection.
- Screen-time integration may depend on operating-system restrictions.
- Manual data entry may become inconvenient over time.
- Personal data requires appropriate privacy and access controls.
- Data from different sources may have inconsistent formats or timestamps.
- The usefulness of the platform depends on maintaining accurate and reasonably complete data.

Assumptions:

- The MVP serves a single individual for personal use rather than multiple accounts.
- GitHub provides an accessible integration suitable for the MVP.
- Users are willing to enter workouts and habits manually where no automatic integration exists.

## 9. Open Questions

- Which personal data categories should be prioritized for the first release?
- Should users be able to import historical data?
- Should the API support both private and publicly shareable information?
- How frequently should automatic integrations synchronize data?
- Should users be able to define custom activity categories?
- What level of aggregated insights should be included in the MVP?
- How should users submit manual entries — through the API itself or a minimal interface?
- Should a simple dashboard be introduced after validating the API-only version?
