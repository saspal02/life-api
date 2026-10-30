package dev.saswat.lifeapi.habits.mapper;

import dev.saswat.lifeapi.habits.dto.HabitEntryRequest;
import dev.saswat.lifeapi.habits.dto.HabitEntryResponse;
import dev.saswat.lifeapi.habits.entity.HabitEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HabitEntryMapper {

    HabitEntryResponse toResponse(HabitEntry entry);

    List<HabitEntryResponse> toResponseList(List<HabitEntry> entries);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    HabitEntry toEntity(HabitEntryRequest request);
}
