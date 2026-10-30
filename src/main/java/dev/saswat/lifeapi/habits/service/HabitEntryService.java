package dev.saswat.lifeapi.habits.service;

import dev.saswat.lifeapi.habits.dto.HabitEntryRequest;
import dev.saswat.lifeapi.habits.dto.HabitEntryResponse;
import dev.saswat.lifeapi.habits.entity.HabitEntry;
import dev.saswat.lifeapi.habits.mapper.HabitEntryMapper;
import dev.saswat.lifeapi.habits.repository.HabitEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HabitEntryService {

    private final HabitEntryRepository habitEntryRepository;
    private final HabitEntryMapper habitEntryMapper;

    @Transactional
    public HabitEntryResponse createHabitEntry(HabitEntryRequest request) {
        HabitEntry entry = habitEntryMapper.toEntity(request);
        entry.setDate(request.date() != null ? request.date() : LocalDate.now());
        return habitEntryMapper.toResponse(habitEntryRepository.save(entry));
    }

    @Transactional(readOnly = true)
    public List<HabitEntryResponse> getAllHabitEntries() {
        return habitEntryMapper.toResponseList(habitEntryRepository.findAll());
    }

    @Transactional(readOnly = true)
    public HabitEntryResponse getHabitEntryById(UUID id) {
        return habitEntryRepository.findById(id)
                .map(habitEntryMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Habit entry not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public List<HabitEntryResponse> getHabitsByDateRange(LocalDate start, LocalDate end) {
        return habitEntryMapper.toResponseList(habitEntryRepository.findByDateBetween(start, end));
    }

    @Transactional(readOnly = true)
    public List<HabitEntryResponse> getHabitsByName(String name) {
        return habitEntryMapper.toResponseList(habitEntryRepository.findByName(name));
    }

    @Transactional(readOnly = true)
    public List<HabitEntryResponse> getHabitsByCompleted(boolean completed) {
        return habitEntryMapper.toResponseList(habitEntryRepository.findByCompleted(completed));
    }

    @Transactional
    public void deleteHabitEntry(UUID id) {
        if (!habitEntryRepository.existsById(id)) {
            throw new RuntimeException("Habit entry not found with id: " + id);
        }
        habitEntryRepository.deleteById(id);
    }
}
