package dev.saswat.lifeapi.workouts.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Duration;
import java.time.Instant;

public record WorkoutRequest(
        @NotBlank String type,
        @NotBlank String name,
        String description,
        Instant performedAt,
        Duration duration,
        Integer caloriesBurned,
        String notes
) {
}
