package dev.saswat.lifeapi.github.repository;

import dev.saswat.lifeapi.github.entity.GitHubActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface GitHubActivityRepository extends JpaRepository<GitHubActivity, UUID> {

    List<GitHubActivity> findByOccurredAtBetween(Instant start, Instant end);

    List<GitHubActivity> findByType(String type);

    List<GitHubActivity> findByRepository(String repository);
}
