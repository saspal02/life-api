package dev.saswat.lifeapi.workouts.mapper;

import dev.saswat.lifeapi.workouts.dto.WorkoutRequest;
import dev.saswat.lifeapi.workouts.dto.WorkoutResponse;
import dev.saswat.lifeapi.workouts.entity.Workout;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkoutMapper {

    WorkoutResponse toResponse(Workout workout);

    List<WorkoutResponse> toResponseList(List<Workout> workouts);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Workout toEntity(WorkoutRequest request);
}
