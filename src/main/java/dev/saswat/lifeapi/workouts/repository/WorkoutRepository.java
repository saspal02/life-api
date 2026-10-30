package dev.saswat.lifeapi.workouts.repository;

import dev.saswat.lifeapi.workouts.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, UUID> {

    List<Workout> findByPerformedAtBetween(Instant start, Instant end);

    List<Workout> findByType(String type);
}
