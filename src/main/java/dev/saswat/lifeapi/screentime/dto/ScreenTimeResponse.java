package dev.saswat.lifeapi.screentime.dto;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public record ScreenTimeResponse(
        UUID id,
        String source,
        Instant recordedAt,
        Duration duration,
        String category,
        String notes,
        Instant createdAt,
        Instant updatedAt
) {
}
