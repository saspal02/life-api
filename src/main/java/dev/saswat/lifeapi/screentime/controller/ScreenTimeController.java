package dev.saswat.lifeapi.screentime.controller;

import dev.saswat.lifeapi.screentime.dto.ScreenTimeRequest;
import dev.saswat.lifeapi.screentime.dto.ScreenTimeResponse;
import dev.saswat.lifeapi.screentime.service.ScreenTimeService;
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
@RequestMapping("/api/screen-time")
@RequiredArgsConstructor
public class ScreenTimeController {

    private final ScreenTimeService screenTimeService;

    @PostMapping
    public ResponseEntity<ScreenTimeResponse> createScreenTimeEntry(@Valid @RequestBody ScreenTimeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(screenTimeService.createScreenTimeEntry(request));
    }

    @GetMapping
    public ResponseEntity<List<ScreenTimeResponse>> getAllScreenTimeEntries() {
        return ResponseEntity.ok(screenTimeService.getAllScreenTimeEntries());
    }

    @GetMapping("/by-date-range")
    public ResponseEntity<List<ScreenTimeResponse>> getScreenTimeByDateRange(
            @RequestParam Instant start,
            @RequestParam Instant end) {
        return ResponseEntity.ok(screenTimeService.getScreenTimeByDateRange(start, end));
    }

    @GetMapping("/by-source")
    public ResponseEntity<List<ScreenTimeResponse>> getScreenTimeBySource(@RequestParam String source) {
        return ResponseEntity.ok(screenTimeService.getScreenTimeBySource(source));
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<ScreenTimeResponse>> getScreenTimeByCategory(@RequestParam String category) {
        return ResponseEntity.ok(screenTimeService.getScreenTimeByCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreenTimeEntry(@PathVariable UUID id) {
        screenTimeService.deleteScreenTimeEntry(id);
        return ResponseEntity.noContent().build();
    }
}
