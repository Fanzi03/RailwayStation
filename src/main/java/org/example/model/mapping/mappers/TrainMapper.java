package org.example.model.mapping.mappers;

import org.example.model.entity.RailwayStation;
import org.example.model.entity.Road;
import org.example.model.entity.Train;
import org.example.model.mapping.dto.TrainDataTransferObject;
import org.example.service.RailwayStationService;
import org.example.service.RoadService;
import org.mapstruct.*;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TrainMapper {
    @Mapping(target = "nameOfRoad",
            expression = "java(train.getRoad() != null ? train.getRoad().getName() : null)")
    @Mapping(target = "nameOfStation",
            expression = "java(train.getRailwayStation() != null ? train.getRailwayStation().getName() : null)")
    TrainDataTransferObject toDTO(Train train);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "road", ignore = true)
    @Mapping(target = "railwayStation", ignore = true)
    Train toEntity(TrainDataTransferObject trainDataTransferObject, @Context RoadService roadService,
                   @Context RailwayStationService railwayStationService);

    @AfterMapping
    default void fillRoadAndStations(
            @MappingTarget Train train,
            TrainDataTransferObject dto,
            @Context RoadService roadService,
            @Context RailwayStationService railwayStationService
    ) {
        if (dto.getNameOfRoad() != null){
            Optional<Road> maybeRoad = Optional.ofNullable(roadService.findEntityByName(dto.getNameOfRoad()));
            maybeRoad.ifPresent(train::setRoad);
        }
        train.setRailwayStation(railwayStationService.findEntityByName(dto.getNameOfStation()));
        if(dto.getNameOfStation() != null){
            Optional<RailwayStation> maybeRailwayStation = Optional.ofNullable(
                    railwayStationService.findEntityByName(dto.getNameOfStation())
            );
            maybeRailwayStation.ifPresent(train::setRailwayStation);
        }
    }
}
