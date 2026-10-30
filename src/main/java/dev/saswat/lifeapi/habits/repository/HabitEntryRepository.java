package dev.saswat.lifeapi.habits.repository;

import dev.saswat.lifeapi.habits.entity.HabitEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface HabitEntryRepository extends JpaRepository<HabitEntry, UUID> {

    List<HabitEntry> findByDateBetween(LocalDate start, LocalDate end);

    List<HabitEntry> findByName(String name);

    List<HabitEntry> findByCompleted(boolean completed);
}
