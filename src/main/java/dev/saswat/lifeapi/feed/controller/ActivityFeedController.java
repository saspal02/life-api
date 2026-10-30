package dev.saswat.lifeapi.feed.controller;

import dev.saswat.lifeapi.feed.dto.ActivityFeedItem;
import dev.saswat.lifeapi.feed.service.ActivityFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityFeedController {

    private final ActivityFeedService activityFeedService;

    @GetMapping
    public ResponseEntity<Page<ActivityFeedItem>> getAllActivities(
            @PageableDefault(size = 20, sort = "timestamp") Pageable pageable) {
        return ResponseEntity.ok(activityFeedService.getActivities(pageable));
    }

    @GetMapping("/by-type")
    public ResponseEntity<Page<ActivityFeedItem>> getActivitiesByType(
            @RequestParam String type,
            @PageableDefault(size = 20, sort = "timestamp") Pageable pageable) {
        return ResponseEntity.ok(activityFeedService.getActivitiesByType(type, pageable));
    }

    @GetMapping("/by-date-range")
    public ResponseEntity<Page<ActivityFeedItem>> getActivitiesByDateRange(
            @RequestParam Instant start,
            @RequestParam Instant end,
            @PageableDefault(size = 20, sort = "timestamp") Pageable pageable) {
        return ResponseEntity.ok(activityFeedService.getActivitiesByDateRange(start, end, pageable));
    }

    @GetMapping("/by-type-and-date-range")
    public ResponseEntity<Page<ActivityFeedItem>> getActivitiesByTypeAndDateRange(
            @RequestParam String type,
            @RequestParam Instant start,
            @RequestParam Instant end,
            @PageableDefault(size = 20, sort = "timestamp") Pageable pageable) {
        return ResponseEntity.ok(activityFeedService.getActivitiesByTypeAndDateRange(type, start, end, pageable));
    }
}
