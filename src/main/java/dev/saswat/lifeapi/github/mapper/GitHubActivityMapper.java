package dev.saswat.lifeapi.github.mapper;

import dev.saswat.lifeapi.github.dto.GitHubActivityRequest;
import dev.saswat.lifeapi.github.dto.GitHubActivityResponse;
import dev.saswat.lifeapi.github.entity.GitHubActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GitHubActivityMapper {

    GitHubActivityResponse toResponse(GitHubActivity activity);

    List<GitHubActivityResponse> toResponseList(List<GitHubActivity> activities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    GitHubActivity toEntity(GitHubActivityRequest request);
}
