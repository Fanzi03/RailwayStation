package org.example.service.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.entity.RailwayStation;

import org.example.model.mapping.dto.util.RailwayStationWithDetailsDataTransferObject;
import org.example.model.mapping.mappers.RailwayStationMapper;
import org.example.repository.RailwayStationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RailwayStationWithDetailsService {
    RailwayStationRepository repository;
    RailwayStationMapper railwayStationMapper;

    @Transactional(readOnly = true)
    public RailwayStationWithDetailsDataTransferObject getStationDetails(Long stationId){
        RailwayStation railwayStation = repository.findById(stationId).orElseThrow(
                () -> new NoSuchElementException("Station with id "+ stationId + " not found")
        );
        return railwayStationMapper.toDTOWithDetails(railwayStation);
    }
}
