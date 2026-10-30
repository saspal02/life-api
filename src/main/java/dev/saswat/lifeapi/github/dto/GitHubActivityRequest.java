package dev.saswat.lifeapi.github.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public record GitHubActivityRequest(
        @NotBlank String type,
        @NotBlank String repository,
        String description,
        Instant occurredAt,
        String url,
        String actor
) {
}
