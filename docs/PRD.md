# LifeAPI — Product Requirements Document

## 1. Overview

LifeAPI is a personal data aggregation platform for individual, personal use. It collects information from different areas of a person's life — GitHub activity, workouts, screen time, and daily habits — and organizes it in one place, accessible through a unified API and chronological activity feed.

Collection follows a hybrid approach: automatic integrations where possible, and manual entry when automatic collection is unavailable.

## 2. Problem Statement

Personal data is scattered across multiple applications and services. GitHub activity lives on GitHub, workout history may be recorded in fitness applications or by hand, screen-time information is maintained by devices, and daily habits are tracked in separate apps or personal notes.

These systems rarely provide a unified view. As a result, users find it difficult to access their complete personal history, view activities across different areas in chronological order, compare activities, and understand long-term patterns.

## 3. Goal / Vision

Give individuals a centralized, structured way to access and understand their personal data without switching between multiple applications.

Enable users to explore their activities through a unified chronological feed, track progress over time, and discover patterns across different areas of their lives.

The platform should provide a personal activity history that users own and control, accessible programmatically and extensible to future dashboards or integrations.

## 4. Target Users

- The individual user (single person, personal use) who wants to collect and organize their own personal activity data.
- Developers who want programmatic access to their personal information.
- People interested in self-tracking, habit monitoring, and personal analytics.

## 5. Key Features (MVP)

### 5.1 GitHub Activity

- Collect GitHub activity through GitHub integration.
- Synchronize activity automatically.
- Store and retrieve historical GitHub activity.

### 5.2 Workout Tracking

- Record workouts and fitness activities manually.
- View, update, and delete workout records.
- Retrieve workout history for specified time periods.

### 5.3 Screen-Time Tracking

- Record screen-time data manually when automatic integration is unavailable.
- Collect screen-time data automatically where supported integrations are available.
- Store and retrieve historical screen-time records.

### 5.4 Daily Habit Tracking

- Track daily habits through manual entries.
- Record habit completion.
- Retrieve habit history for specified time periods.

### 5.5 Unified Activity Feed

- Combine activities from all supported domains into a single chronological feed.
- Represent activities using a consistent format containing activity type, timestamp, and relevant details.
- Display activities in chronological order, with the most recent activities first.
- Filter activities by date range and activity type.
- Support pagination for retrieving historical activities.
- Include automatically collected and manually recorded activities in the same feed.

### 5.6 Unified API

- Expose domain-specific endpoints for managing and retrieving personal data.
- Provide a unified endpoint for retrieving activities across multiple domains.
- Retrieve activity records and basic summaries for specified time periods.
- Return structured JSON responses suitable for integration with dashboards and other tools.

## 6. Out of Scope

- Full-featured web dashboard.
- Native mobile application.
- AI-powered recommendations or predictions.
- Social networking and activity sharing.
- Financial tracking.
- Sleep and reading-list integrations for the initial MVP.
- Integration with every available personal data provider.
- Advanced analytics and automated coaching.
- Real-time activity streaming.

## 7. Success Metrics

The core success signal is that users can consistently collect and retrieve their personal data from multiple sources through one API and explore their activities through a unified chronological feed.

Initial indicators:

- Successful integration with GitHub.
- Reliable manual tracking of workouts and habits.
- Consistent storage and retrieval of historical data.
- Ability to access information from multiple life domains through a single API.
- Accurate chronological ordering of activities from different sources.
- Ability to filter and retrieve historical activities through the unified feed.
- Continued usage of the platform for personal activity tracking.

No numeric targets have been defined yet.

## 8. Risks and Assumptions

### Risks

- Some services may not provide accessible APIs for automatic data collection.
- Screen-time integration may depend on operating-system restrictions.
- Manual data entry may become inconvenient over time.
- Personal data requires appropriate privacy and access controls.
- Data from different sources may have inconsistent formats or timestamps.
- Duplicate activities may occur during automatic synchronization.
- Combining different activity types into a unified feed may require consistent normalization.
- The usefulness of the platform depends on maintaining accurate and reasonably complete data.

### Assumptions

- The MVP serves a single individual for personal use rather than multiple accounts.
- GitHub provides an accessible integration suitable for the MVP.
- Users are willing to enter workouts and habits manually where no automatic integration exists.
- Activities from different domains can be represented through a common format for the unified feed.
- The initial product is API-first and does not require a graphical dashboard.

## 9. Open Questions

- Which personal data categories should be prioritized for the first release?
- Should users be able to import historical data?
- Should the API support both private and publicly shareable information?
- How frequently should automatic integrations synchronize data?
- Should users be able to define custom activity categories?
- What level of aggregated insights should be included in the MVP?
- How should users submit manual entries — through the API itself or a minimal interface?
- Should a simple dashboard be introduced after validating the API-only version?
- Should the unified feed include every recorded event or only meaningful activity summaries?
- How should duplicate activities and updates from synchronized sources be handled?
