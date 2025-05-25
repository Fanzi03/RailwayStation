package org.example.model.mapping.mappers;

import org.example.model.entity.Road;
import org.example.model.mapping.dto.RoadDataTransferObject;
import org.example.model.mapping.dto.util.RoadWithDetailsDataTransferObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RailwayStationMapper.class)
public interface RoadMapper {
    RoadDataTransferObject toDTO(Road road);
    @Mapping(target = "id", ignore = true)
    Road toEntity(RoadDataTransferObject roadDataTransferObject);
    @Mapping(target = "id", ignore = true)
    Road toEntity(RoadWithDetailsDataTransferObject roadWithDetailsDataTransferObject);
    RoadWithDetailsDataTransferObject toDTOWithDetails(Road road);

}
