package dev.saswat.lifeapi.feed.service;

import dev.saswat.lifeapi.feed.dto.ActivityFeedItem;
import dev.saswat.lifeapi.github.entity.GitHubActivity;
import dev.saswat.lifeapi.github.repository.GitHubActivityRepository;
import dev.saswat.lifeapi.habits.entity.HabitEntry;
import dev.saswat.lifeapi.habits.repository.HabitEntryRepository;
import dev.saswat.lifeapi.screentime.entity.ScreenTimeEntry;
import dev.saswat.lifeapi.screentime.repository.ScreenTimeRepository;
import dev.saswat.lifeapi.workouts.entity.Workout;
import dev.saswat.lifeapi.workouts.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityFeedService {

    private final GitHubActivityRepository githubActivityRepository;
    private final WorkoutRepository workoutRepository;
    private final HabitEntryRepository habitEntryRepository;
    private final ScreenTimeRepository screenTimeRepository;

    @Transactional(readOnly = true)
    public Page<ActivityFeedItem> getActivities(Pageable pageable) {
        List<ActivityFeedItem> allActivities = getAllActivities();
        allActivities.sort((a, b) -> b.timestamp().compareTo(a.timestamp()));

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), allActivities.size());

        List<ActivityFeedItem> pageContent = allActivities.subList(start, end);
        return new org.springframework.data.domain.PageImpl<>(pageContent, pageable, allActivities.size());
    }

    @Transactional(readOnly = true)
    public Page<ActivityFeedItem> getActivitiesByType(String activityType, Pageable pageable) {
        List<ActivityFeedItem> allActivities = getAllActivities();
        allActivities = allActivities.stream()
                .filter(a -> a.activityType().equalsIgnoreCase(activityType))
                .collect(Collectors.toList());
        allActivities.sort((a, b) -> b.timestamp().compareTo(a.timestamp()));

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), allActivities.size());

        List<ActivityFeedItem> pageContent = allActivities.subList(start, end);
        return new org.springframework.data.domain.PageImpl<>(pageContent, pageable, allActivities.size());
    }

    @Transactional(readOnly = true)
    public Page<ActivityFeedItem> getActivitiesByDateRange(Instant start, Instant end, Pageable pageable) {
        List<ActivityFeedItem> allActivities = getAllActivities();
        allActivities = allActivities.stream()
                .filter(a -> !a.timestamp().isBefore(start) && !a.timestamp().isAfter(end))
                .collect(Collectors.toList());
        allActivities.sort((a, b) -> b.timestamp().compareTo(a.timestamp()));

        int startIdx = (int) pageable.getOffset();
        int endIdx = Math.min((startIdx + pageable.getPageSize()), allActivities.size());

        List<ActivityFeedItem> pageContent = allActivities.subList(startIdx, endIdx);
        return new org.springframework.data.domain.PageImpl<>(pageContent, pageable, allActivities.size());
    }

    @Transactional(readOnly = true)
    public Page<ActivityFeedItem> getActivitiesByTypeAndDateRange(String activityType, Instant start, Instant end, Pageable pageable) {
        List<ActivityFeedItem> allActivities = getAllActivities();
        allActivities = allActivities.stream()
                .filter(a -> a.activityType().equalsIgnoreCase(activityType))
                .filter(a -> !a.timestamp().isBefore(start) && !a.timestamp().isAfter(end))
                .collect(Collectors.toList());
        allActivities.sort((a, b) -> b.timestamp().compareTo(a.timestamp()));

        int startIdx = (int) pageable.getOffset();
        int endIdx = Math.min((startIdx + pageable.getPageSize()), allActivities.size());

        List<ActivityFeedItem> pageContent = allActivities.subList(startIdx, endIdx);
        return new org.springframework.data.domain.PageImpl<>(pageContent, pageable, allActivities.size());
    }

    private List<ActivityFeedItem> getAllActivities() {
        List<ActivityFeedItem> allActivities = new ArrayList<>();

        allActivities.addAll(convertGitHubActivities(githubActivityRepository.findAll()));
        allActivities.addAll(convertWorkouts(workoutRepository.findAll()));
        allActivities.addAll(convertHabits(habitEntryRepository.findAll()));
        allActivities.addAll(convertScreenTime(screenTimeRepository.findAll()));

        return allActivities;
    }

    private List<ActivityFeedItem> convertGitHubActivities(List<GitHubActivity> activities) {
        return activities.stream().map(activity -> {
            Map<String, Object> details = new HashMap<>();
            details.put("id", activity.getId());
            details.put("type", activity.getType());
            details.put("repository", activity.getRepository());
            details.put("description", activity.getDescription());
            details.put("url", activity.getUrl());
            details.put("actor", activity.getActor());

            return new ActivityFeedItem("GITHUB", activity.getOccurredAt(), details);
        }).collect(Collectors.toList());
    }

    private List<ActivityFeedItem> convertWorkouts(List<Workout> workouts) {
        return workouts.stream().map(workout -> {
            Map<String, Object> details = new HashMap<>();
            details.put("id", workout.getId());
            details.put("type", workout.getType());
            details.put("name", workout.getName());
            details.put("description", workout.getDescription());
            details.put("duration", workout.getDuration());
            details.put("caloriesBurned", workout.getCaloriesBurned());
            details.put("notes", workout.getNotes());

            return new ActivityFeedItem("WORKOUT", workout.getPerformedAt(), details);
        }).collect(Collectors.toList());
    }

    private List<ActivityFeedItem> convertHabits(List<HabitEntry> habits) {
        return habits.stream().map(habit -> {
            Map<String, Object> details = new HashMap<>();
            details.put("id", habit.getId());
            details.put("name", habit.getName());
            details.put("description", habit.getDescription());
            details.put("completed", habit.isCompleted());
            details.put("notes", habit.getNotes());

            Instant timestamp = habit.getDate().atStartOfDay().atZone(java.time.ZoneOffset.UTC).toInstant();
            return new ActivityFeedItem("HABIT", timestamp, details);
        }).collect(Collectors.toList());
    }

    private List<ActivityFeedItem> convertScreenTime(List<ScreenTimeEntry> entries) {
        return entries.stream().map(entry -> {
            Map<String, Object> details = new HashMap<>();
            details.put("id", entry.getId());
            details.put("source", entry.getSource());
            details.put("duration", entry.getDuration());
            details.put("category", entry.getCategory());
            details.put("notes", entry.getNotes());

            return new ActivityFeedItem("SCREEN_TIME", entry.getRecordedAt(), details);
        }).collect(Collectors.toList());
    }
}
