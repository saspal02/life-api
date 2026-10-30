package dev.saswat.lifeapi.screentime.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Duration;
import java.time.Instant;

public record ScreenTimeRequest(
        @NotBlank String source,
        Instant recordedAt,
        Duration duration,
        String category,
        String notes
) {
}
