package dev.saswat.lifeapi.screentime.service;

import dev.saswat.lifeapi.screentime.dto.ScreenTimeRequest;
import dev.saswat.lifeapi.screentime.dto.ScreenTimeResponse;
import dev.saswat.lifeapi.screentime.entity.ScreenTimeEntry;
import dev.saswat.lifeapi.screentime.mapper.ScreenTimeMapper;
import dev.saswat.lifeapi.screentime.repository.ScreenTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScreenTimeService {

    private final ScreenTimeRepository screenTimeRepository;
    private final ScreenTimeMapper screenTimeMapper;

    @Transactional
    public ScreenTimeResponse createScreenTimeEntry(ScreenTimeRequest request) {
        ScreenTimeEntry entry = screenTimeMapper.toEntity(request);
        entry.setRecordedAt(request.recordedAt() != null ? request.recordedAt() : Instant.now());
        return screenTimeMapper.toResponse(screenTimeRepository.save(entry));
    }

    @Transactional(readOnly = true)
    public List<ScreenTimeResponse> getAllScreenTimeEntries() {
        return screenTimeMapper.toResponseList(screenTimeRepository.findAll());
    }

    @Transactional(readOnly = true)
    public ScreenTimeResponse getScreenTimeEntryById(UUID id) {
        return screenTimeRepository.findById(id)
                .map(screenTimeMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Screen time entry not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public List<ScreenTimeResponse> getScreenTimeByDateRange(Instant start, Instant end) {
        return screenTimeMapper.toResponseList(screenTimeRepository.findByRecordedAtBetween(start, end));
    }

    @Transactional(readOnly = true)
    public List<ScreenTimeResponse> getScreenTimeBySource(String source) {
        return screenTimeMapper.toResponseList(screenTimeRepository.findBySource(source));
    }

    @Transactional(readOnly = true)
    public List<ScreenTimeResponse> getScreenTimeByCategory(String category) {
        return screenTimeMapper.toResponseList(screenTimeRepository.findByCategory(category));
    }

    @Transactional
    public void deleteScreenTimeEntry(UUID id) {
        if (!screenTimeRepository.existsById(id)) {
            throw new RuntimeException("Screen time entry not found with id: " + id);
        }
        screenTimeRepository.deleteById(id);
    }
}
