package dev.saswat.lifeapi.feed.dto;

import java.time.Instant;
import java.util.Map;

public record ActivityFeedItem(
        String activityType,
        Instant timestamp,
        Map<String, Object> details
) {
}
