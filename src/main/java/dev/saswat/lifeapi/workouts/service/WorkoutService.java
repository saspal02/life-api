package dev.saswat.lifeapi.workouts.service;

import dev.saswat.lifeapi.workouts.dto.WorkoutRequest;
import dev.saswat.lifeapi.workouts.dto.WorkoutResponse;
import dev.saswat.lifeapi.workouts.entity.Workout;
import dev.saswat.lifeapi.workouts.mapper.WorkoutMapper;
import dev.saswat.lifeapi.workouts.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutMapper workoutMapper;

    @Transactional
    public WorkoutResponse createWorkout(WorkoutRequest request) {
        Workout workout = workoutMapper.toEntity(request);
        workout.setPerformedAt(request.performedAt() != null ? request.performedAt() : Instant.now());
        return workoutMapper.toResponse(workoutRepository.save(workout));
    }

    @Transactional(readOnly = true)
    public List<WorkoutResponse> getAllWorkouts() {
        return workoutMapper.toResponseList(workoutRepository.findAll());
    }

    @Transactional(readOnly = true)
    public WorkoutResponse getWorkoutById(UUID id) {
        return workoutRepository.findById(id)
                .map(workoutMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Workout not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public List<WorkoutResponse> getWorkoutsByDateRange(Instant start, Instant end) {
        return workoutMapper.toResponseList(workoutRepository.findByPerformedAtBetween(start, end));
    }

    @Transactional(readOnly = true)
    public List<WorkoutResponse> getWorkoutsByType(String type) {
        return workoutMapper.toResponseList(workoutRepository.findByType(type));
    }

    @Transactional
    public void deleteWorkout(UUID id) {
        if (!workoutRepository.existsById(id)) {
            throw new RuntimeException("Workout not found with id: " + id);
        }
        workoutRepository.deleteById(id);
    }
}
