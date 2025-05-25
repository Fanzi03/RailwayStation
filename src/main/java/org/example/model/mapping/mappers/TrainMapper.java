package org.example.model.mapping.mappers;

import org.example.model.entity.Train;
import org.example.model.mapping.dto.TrainDataTransferObject;
import org.example.service.RailwayStationService;
import org.example.service.RoadService;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {RoadMapper.class, RailwayStationMapper.class})
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
        train.setRoad(roadService.findEntityByName(dto.getNameOfRoad()));
        train.setRailwayStation(railwayStationService.findEntityByName(dto.getNameOfStation()));
    }
}
