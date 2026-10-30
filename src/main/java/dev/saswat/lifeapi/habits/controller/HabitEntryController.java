package dev.saswat.lifeapi.habits.controller;

import dev.saswat.lifeapi.habits.dto.HabitEntryRequest;
import dev.saswat.lifeapi.habits.dto.HabitEntryResponse;
import dev.saswat.lifeapi.habits.service.HabitEntryService;
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

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/habits")
@RequiredArgsConstructor
public class HabitEntryController {

    private final HabitEntryService habitEntryService;

    @PostMapping
    public ResponseEntity<HabitEntryResponse> createHabitEntry(@Valid @RequestBody HabitEntryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(habitEntryService.createHabitEntry(request));
    }

    @GetMapping
    public ResponseEntity<List<HabitEntryResponse>> getAllHabitEntries() {
        return ResponseEntity.ok(habitEntryService.getAllHabitEntries());
    }

    @GetMapping("/by-date-range")
    public ResponseEntity<List<HabitEntryResponse>> getHabitsByDateRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return ResponseEntity.ok(habitEntryService.getHabitsByDateRange(start, end));
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<HabitEntryResponse>> getHabitsByName(@RequestParam String name) {
        return ResponseEntity.ok(habitEntryService.getHabitsByName(name));
    }

    @GetMapping("/by-completed")
    public ResponseEntity<List<HabitEntryResponse>> getHabitsByCompleted(@RequestParam boolean completed) {
        return ResponseEntity.ok(habitEntryService.getHabitsByCompleted(completed));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitEntry(@PathVariable UUID id) {
        habitEntryService.deleteHabitEntry(id);
        return ResponseEntity.noContent().build();
    }
}
