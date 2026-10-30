package dev.saswat.lifeapi.workouts.dto;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public record WorkoutResponse(
        UUID id,
        String type,
        String name,
        String description,
        Instant performedAt,
        Duration duration,
        Integer caloriesBurned,
        String notes,
        Instant createdAt,
        Instant updatedAt
) {
}
