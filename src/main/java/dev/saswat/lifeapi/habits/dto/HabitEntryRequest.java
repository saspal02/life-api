package dev.saswat.lifeapi.habits.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record HabitEntryRequest(
        @NotBlank String name,
        String description,
        LocalDate date,
        boolean completed,
        String notes
) {
}
