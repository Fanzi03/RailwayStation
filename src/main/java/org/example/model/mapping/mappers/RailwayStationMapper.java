package org.example.model.mapping.mappers;

import org.example.model.entity.RailwayStation;
import org.example.model.mapping.dto.RailwayStationDataTransferObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RailwayStationMapper {
    RailwayStationDataTransferObject toDTO(RailwayStation railwayStation);
    @Mapping(target = "id", ignore = true)
    RailwayStation toEntity(RailwayStationDataTransferObject railwayStationDataTransferObject);
}
