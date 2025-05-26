package org.example.model.mapping.mappers;

import org.example.model.entity.RailwayStation;
import org.example.model.mapping.dto.RailwayStationDataTransferObject;
import org.example.model.mapping.dto.util.RailwayStationWithDetailsDataTransferObject;
import org.example.service.RailwayStationService;
import org.example.service.RoadService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {RoadMapper.class, TrainMapper.class})
public interface RailwayStationMapper {
    @Named("stationBasic")
    RailwayStationDataTransferObject toDTO(RailwayStation railwayStation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roads", ignore = true)
    @Mapping(target = "trains", ignore = true)
    RailwayStation toEntity(RailwayStationDataTransferObject railwayStationDataTransferObject);
    @Mapping(target = "id", ignore = true)
    @Mapping(source= "roads", target = "roads")
    @Mapping(source = "trains", target = "trains")
    RailwayStation toEntityWithMoreInfo(
            RailwayStationWithDetailsDataTransferObject railwayStationWithDetailsDataTransferObject,
            @Context RoadService roadService, @Context RailwayStationService railwayStationService
    );
    @Named("stationWithDetails")
    RailwayStationWithDetailsDataTransferObject toDTOWithDetails(RailwayStation railwayStation);

}
