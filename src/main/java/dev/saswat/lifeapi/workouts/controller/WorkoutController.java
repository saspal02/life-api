package dev.saswat.lifeapi.workouts.controller;

import dev.saswat.lifeapi.workouts.dto.WorkoutRequest;
import dev.saswat.lifeapi.workouts.dto.WorkoutResponse;
import dev.saswat.lifeapi.workouts.service.WorkoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<WorkoutResponse> createWorkout(@Valid @RequestBody WorkoutRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(workoutService.createWorkout(request));
    }

    @GetMapping
    public ResponseEntity<List<WorkoutResponse>> getAllWorkouts() {
        return ResponseEntity.ok(workoutService.getAllWorkouts());
    }

    @GetMapping("/by-date-range")
    public ResponseEntity<List<WorkoutResponse>> getWorkoutsByDateRange(
            @RequestParam Instant start,
            @RequestParam Instant end) {
        return ResponseEntity.ok(workoutService.getWorkoutsByDateRange(start, end));
    }

    @GetMapping("/by-type")
    public ResponseEntity<List<WorkoutResponse>> getWorkoutsByType(@RequestParam String type) {
        return ResponseEntity.ok(workoutService.getWorkoutsByType(type));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable UUID id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }
}
