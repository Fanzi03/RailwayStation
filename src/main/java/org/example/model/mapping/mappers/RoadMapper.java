package org.example.model.mapping.mappers;

import org.example.model.entity.Road;
import org.example.model.mapping.dto.RoadDataTransferObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoadMapper {
    RoadDataTransferObject toDTO(Road road);
    @Mapping(target = "id", ignore = true)
    Road toEntity(RoadDataTransferObject roadDataTransferObject);
}
