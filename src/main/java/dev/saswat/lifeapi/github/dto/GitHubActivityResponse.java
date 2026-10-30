package dev.saswat.lifeapi.github.dto;

import java.time.Instant;
import java.util.UUID;

public record GitHubActivityResponse(
        UUID id,
        String type,
        String repository,
        String description,
        Instant occurredAt,
        String url,
        String actor,
        Instant createdAt,
        Instant updatedAt
) {
}
