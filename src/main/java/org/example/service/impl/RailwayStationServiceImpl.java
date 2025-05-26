package org.example.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.model.entity.RailwayStation;
import org.example.service.util.RailwayStationWithDetailsService;
import org.example.model.mapping.dto.RailwayStationDataTransferObject;
import org.example.model.mapping.dto.util.RailwayStationWithDetailsDataTransferObject;
import org.example.model.mapping.mappers.RailwayStationMapper;
import org.example.repository.RailwayStationRepository;
import org.example.service.RailwayStationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RailwayStationServiceImpl implements RailwayStationService {
    RailwayStationRepository repository;
    RailwayStationMapper railwayStationMapper;
    RailwayStationWithDetailsService railwayStationWithDetailsService;

    @Override
    public RailwayStationWithDetailsDataTransferObject getRailwayStationWithDetails(Long stationId) {
        return railwayStationWithDetailsService.getStationDetails(stationId);
    }

    @Override
    public List<RailwayStationDataTransferObject> findAll() {
        return repository.findAll().stream().map(railwayStationMapper::toDTO).collect(Collectors.toList());
    }

    public RailwayStationDataTransferObject findById(Long id) {
        RailwayStation railwayStation  = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Railway station with id" + id + " not found")
        );
        return railwayStationMapper.toDTO(railwayStation);
    }

    @Override
    public RailwayStationDataTransferObject findByName(String name) {
        RailwayStation railwayStation = repository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Railway station with name" + name  + " not found"));
        return railwayStationMapper.toDTO(railwayStation);
    }

    @Override
    public RailwayStation findEntityByName(String name) {
        return repository.findByName(name).orElseThrow(
                () -> new NoSuchElementException("Railway station with name" + name + " not found")
        );
    }


    @Override
    public void save(RailwayStationDataTransferObject railwayStationDataTransferObject) {
        RailwayStation railwayStation = railwayStationMapper.toEntity(railwayStationDataTransferObject);
        repository.save(railwayStation);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Railway station with id" + id + " not found"))
        );
    }


    @Override
    public void update(RailwayStationDataTransferObject railwayStationDataTransferObject, Long id) {
        repository.findById(id).ifPresent(existingRailwayStation -> {
            RailwayStation railwayStation = railwayStationMapper.toEntity(railwayStationDataTransferObject);
            existingRailwayStation.setFreePlaces(railwayStation.getFreePlaces());
            repository.save(existingRailwayStation);
        });
    }
}
