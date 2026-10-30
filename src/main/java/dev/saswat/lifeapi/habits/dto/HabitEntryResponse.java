package dev.saswat.lifeapi.habits.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record HabitEntryResponse(
        UUID id,
        String name,
        String description,
        LocalDate date,
        boolean completed,
        String notes,
        Instant createdAt,
        Instant updatedAt
) {
}
