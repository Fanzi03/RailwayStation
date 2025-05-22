package org.example.model.mapping.mappers;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.entity.Train;
import org.example.model.mapping.dto.TrainDataTransferObject;
import org.example.repository.RailwayStationRepository;
import org.example.repository.RoadRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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
    Train toEntity(TrainDataTransferObject trainDataTransferObject);

    default void fillRoadAndStations(
            @MappingTarget Train train,
            TrainDataTransferObject dto,
            RoadRepository roadRepository,
            RailwayStationRepository stationRepository
    ) {
        train.setRoad(
                roadRepository.findByName(dto.getNameOfRoad())
                        .orElseThrow(() -> new EntityNotFoundException("Road not found: " + dto.getNameOfRoad()))
        );

        train.setRailwayStation(
                stationRepository.findByName(dto.getNameOfStation())
                        .orElseThrow(() -> new EntityNotFoundException("RailwayStation not found: " + dto.getNameOfStation()))
        );
    }
}
