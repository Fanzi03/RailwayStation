package org.example.model.mapping.mappers;

import org.example.model.entity.Road;
import org.example.model.mapping.dto.RoadDataTransferObject;
import org.example.model.mapping.dto.util.RoadWithDetailsDataTransferObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = RailwayStationMapper.class)
public interface RoadMapper {
    @Named("roadBasic")
    RoadDataTransferObject toDTO(Road road);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "railwayStations", ignore = true)
    Road toEntity(RoadDataTransferObject roadDataTransferObject);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "railwayStations", target = "railwayStations")
    Road toEntityWithMoreDetails(RoadWithDetailsDataTransferObject roadWithDetailsDataTransferObject);

    @Named("roadWithDetails")
    @Mapping(source = "railwayStations", target = "railwayStations")
    RoadWithDetailsDataTransferObject toDTOWithDetails(Road road);

}
