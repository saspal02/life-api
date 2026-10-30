package dev.saswat.lifeapi.screentime.repository;

import dev.saswat.lifeapi.screentime.entity.ScreenTimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface ScreenTimeRepository extends JpaRepository<ScreenTimeEntry, UUID> {

    List<ScreenTimeEntry> findByRecordedAtBetween(Instant start, Instant end);

    List<ScreenTimeEntry> findBySource(String source);

    List<ScreenTimeEntry> findByCategory(String category);
}
