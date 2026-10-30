package dev.saswat.lifeapi.github.service;

import dev.saswat.lifeapi.github.dto.GitHubActivityRequest;
import dev.saswat.lifeapi.github.dto.GitHubActivityResponse;
import dev.saswat.lifeapi.github.entity.GitHubActivity;
import dev.saswat.lifeapi.github.mapper.GitHubActivityMapper;
import dev.saswat.lifeapi.github.repository.GitHubActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GitHubActivityService {

    private final GitHubActivityRepository githubActivityRepository;
    private final GitHubActivityMapper githubActivityMapper;

    @Transactional
    public GitHubActivityResponse createActivity(GitHubActivityRequest request) {
        GitHubActivity activity = githubActivityMapper.toEntity(request);
        activity.setOccurredAt(request.occurredAt() != null ? request.occurredAt() : Instant.now());
        return githubActivityMapper.toResponse(githubActivityRepository.save(activity));
    }

    @Transactional(readOnly = true)
    public List<GitHubActivityResponse> getAllActivities() {
        return githubActivityMapper.toResponseList(githubActivityRepository.findAll());
    }

    @Transactional(readOnly = true)
    public GitHubActivityResponse getActivityById(UUID id) {
        return githubActivityRepository.findById(id)
                .map(githubActivityMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("GitHub activity not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public List<GitHubActivityResponse> getActivitiesByDateRange(Instant start, Instant end) {
        return githubActivityMapper.toResponseList(githubActivityRepository.findByOccurredAtBetween(start, end));
    }

    @Transactional(readOnly = true)
    public List<GitHubActivityResponse> getActivitiesByType(String type) {
        return githubActivityMapper.toResponseList(githubActivityRepository.findByType(type));
    }

    @Transactional
    public void deleteActivity(UUID id) {
        if (!githubActivityRepository.existsById(id)) {
            throw new RuntimeException("GitHub activity not found with id: " + id);
        }
        githubActivityRepository.deleteById(id);
    }
}
