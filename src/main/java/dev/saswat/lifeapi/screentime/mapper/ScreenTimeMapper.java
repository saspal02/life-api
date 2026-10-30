package dev.saswat.lifeapi.screentime.mapper;

import dev.saswat.lifeapi.screentime.dto.ScreenTimeRequest;
import dev.saswat.lifeapi.screentime.dto.ScreenTimeResponse;
import dev.saswat.lifeapi.screentime.entity.ScreenTimeEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScreenTimeMapper {

    ScreenTimeResponse toResponse(ScreenTimeEntry entry);

    List<ScreenTimeResponse> toResponseList(List<ScreenTimeEntry> entries);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ScreenTimeEntry toEntity(ScreenTimeRequest request);
}
